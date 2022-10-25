package com.example.demo.entity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PatientDoesentExist extends RuntimeException{
    public PatientDoesentExist(String message){
        System.out.println(message);
    }
}
