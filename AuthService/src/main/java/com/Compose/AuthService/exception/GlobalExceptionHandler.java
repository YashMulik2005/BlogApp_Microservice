package com.Compose.AuthService.exception;

import com.Compose.AuthService.dto.ErrorResposneHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> UsernameNotFoundExceptionHandler(UsernameNotFoundException ex){
        return ErrorResposneHandler.errorResponseBuilder(HttpStatus.NOT_FOUND,false,ex.getMessage());
    }

    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity<?> UsernameNotFoundExceptionHandler(UserAlreadyExist ex){
        return ErrorResposneHandler.errorResponseBuilder(HttpStatus.CONFLICT,false,ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();
        return ErrorResposneHandler.errorResponseBuilder(HttpStatus.BAD_REQUEST,false,message );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundExceptionHandler(NotFoundException ex){
        return ErrorResposneHandler.errorResponseBuilder(HttpStatus.NOT_FOUND,false,ex.getMessage());
    }
}
