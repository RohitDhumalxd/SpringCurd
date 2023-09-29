package com.springtest.fullbackend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("Could not found the User ID "+id);
    }
}
