package com.example.uk.ford.ExceptionHandler;

public class FordException extends RuntimeException {

    public FordException(Exception ex){
        super(ex);
    }

    public FordException(String userMessage, Exception ex){
        super(userMessage, ex);
    }

}
