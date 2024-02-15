package com.workintech.burger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerException burgerException){
        BurgerErrorResponse burgerErrorResponse=new BurgerErrorResponse(burgerException.getHttpStatus().value(),burgerException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(burgerErrorResponse,burgerException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleOtherExceptions(Exception exception){
        BurgerErrorResponse otherErrorResponse=new BurgerErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(otherErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
