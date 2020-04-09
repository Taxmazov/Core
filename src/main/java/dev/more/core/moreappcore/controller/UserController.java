package dev.more.core.moreappcore.controller;

import dev.more.core.moreappcore.entity.UserEntity;
import dev.more.core.moreappcore.exception.UserBadRequestException;
import dev.more.core.moreappcore.handler.UserExceptionHandler;
import dev.more.core.moreappcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity userEntity) {

        return new ResponseEntity<>(userService.createUser(userEntity), HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<UserEntity>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserEntity> getAllUser(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> updateById(@PathVariable("id") long id, @RequestBody UserEntity userEntity) {
        UserEntity entity = userService.findById(id);
        entity.setNickName(userEntity.getNickName());
        entity.setUserPhone(userEntity.getUserPhone());
        entity.setUserName(userEntity.getUserName());
        entity.setUserType(userEntity.getUserType());
        return new ResponseEntity<>(userService.createUser(entity), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("id") long id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            userService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

}
