package com.example.mapper.model.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleException(MethodArgumentNotValidException e){
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->{
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<Map<String, String>> handleException(UserAlreadyExists userAlreadyExists){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("USER_ALREADY_EXISTS", userAlreadyExists.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
