package com.educandoweb.springmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialversionUID = 1L;

    public ObjectNotFoundException (String msg){
        super(msg);
    }

}
