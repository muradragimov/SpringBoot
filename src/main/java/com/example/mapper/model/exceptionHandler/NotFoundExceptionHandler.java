package com.example.mapper.model.exceptionHandler;

import com.example.mapper.dao.entity.TeacherEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

public class NotFoundExceptionHandler extends RuntimeException{

    public NotFoundExceptionHandler(String message){
            super(message);
    }
}
