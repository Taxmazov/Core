package dev.more.core.moreappcore.handler;

import dev.more.core.moreappcore.exception.ApiError;
import dev.more.core.moreappcore.exception.UserBadRequestException;
import dev.more.core.moreappcore.exception.UserNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handlerUserNotFoundException(Exception exception, WebRequest request) {
        String errorMessage = "User not found in Database";
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, errorMessage, exception));
    }

    @ExceptionHandler(UserBadRequestException.class)
    public ResponseEntity<Object> handlerUserBadRequestException(Exception exception, WebRequest request) {
        String errorMessage = "User not found in Database";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, errorMessage, exception));
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage= "one or all parameters equals NULL";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST,errorMessage,ex));
    }
}
