package com.project.StudentManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;


public class HandleException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
            //1st String (key)- the field name , 2nd String (value) - the message name
            var errors = new HashMap<String,String>();
            exception.getBindingResult().getAllErrors() //return list of errors as object
                    .forEach(error -> {
                        var fieldName = ((FieldError) error).getField(); //return the field name
                        var errorMessage = error.getDefaultMessage();
                        errors.put(fieldName,errorMessage);
                    });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);


    }
}
