package com.example.mapper.model.exceptionHandler;

public class UserAlreadyExists extends RuntimeException{

    public UserAlreadyExists(String message){
        super(message);
    }
}
