package com.example.demo.entity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ValidDateException extends RuntimeException{
    public ValidDateException(String message){
        System.out.println(message);
    }
}
