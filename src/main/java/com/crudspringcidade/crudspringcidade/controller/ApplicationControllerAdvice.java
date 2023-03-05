package com.crudspringcidade.crudspringcidade.controller;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.crudspringcidade.crudspringcidade.exception.CidadeNotFoundIdException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(CidadeNotFoundIdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleRecordNotFoundException(CidadeNotFoundIdException ex) {
        return ex.getMessage();
    }
    
}
