package com.demo.demosopra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class DemoControllerException {
    public ResponseEntity<ErrorDetails> wrongOperationHandler(OperationErrorException exception) {

        return new ResponseEntity<>(new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage()), HttpStatus.CONFLICT);
    }
}
