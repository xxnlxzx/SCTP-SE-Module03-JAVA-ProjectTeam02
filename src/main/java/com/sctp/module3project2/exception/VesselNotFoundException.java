package com.sctp.module3project2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VesselNotFoundException extends RuntimeException{
    public VesselNotFoundException(String message){
        super(message);
    }
}