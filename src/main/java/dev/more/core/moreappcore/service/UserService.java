package dev.more.core.moreappcore.service;

import dev.more.core.moreappcore.entity.UserEntity;
import dev.more.core.moreappcore.exception.UserBadRequestException;
import dev.more.core.moreappcore.exception.UserNotFoundException;
import dev.more.core.moreappcore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity userEntity) {
        UserEntity entity = userRepository.save(userEntity);
        return findById(entity.getUserId());
    }

    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    public UserEntity findById(Long id) {
        if (id == 0) {
            throw new UserBadRequestException("id not found");
        }
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found by Id : " + id));
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public void deleteAll(){
        userRepository.deleteAll();;
    }


}

