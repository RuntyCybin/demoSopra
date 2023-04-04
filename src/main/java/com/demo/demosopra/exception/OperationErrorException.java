package com.demo.demosopra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class OperationErrorException extends Exception {
    public OperationErrorException(String mensaje) {
        super(mensaje);
    }
}
