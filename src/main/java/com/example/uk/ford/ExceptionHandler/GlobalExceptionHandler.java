package com.example.uk.ford.ExceptionHandler;

import com.example.uk.ford.model.FordResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FordException.class)
    public ResponseEntity<FordResponse> handleFordException(HttpServletRequest request, Exception ex){
        FordResponse respDelete = new FordResponse();
        respDelete.setErrorMsg(ex.getMessage());
        ResponseEntity responseEntityUpdate = new ResponseEntity(respDelete, HttpStatus.EXPECTATION_FAILED);
        return responseEntityUpdate;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FordResponse> handleException(HttpServletRequest request, Exception ex){
        FordResponse respDelete = new FordResponse();
        respDelete.setErrorMsg(ex.getMessage());
        ResponseEntity responseEntityUpdate = new ResponseEntity(respDelete, HttpStatus.EXPECTATION_FAILED);
        return responseEntityUpdate;
    }
}
