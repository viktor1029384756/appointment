package com.example.demo.entity.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class DoktorDoesentExists extends RuntimeException{
   public DoktorDoesentExists(String message){
       System.out.println(message);
   }
}
