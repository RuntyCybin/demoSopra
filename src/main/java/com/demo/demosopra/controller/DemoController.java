package com.demo.demosopra.controller;

import com.demo.demosopra.dto.OperationRequestDTO;
import com.demo.demosopra.dto.OperationResponseDTO;
import com.demo.demosopra.dto.OperationService;
import com.demo.demosopra.exception.OperationErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DemoController {

    @Autowired
    OperationService service;

    @PostMapping("/operacion")
    public ResponseEntity<OperationResponseDTO> operacionMatematica(
            @RequestBody OperationRequestDTO operationRequestDTO
    ) throws OperationErrorException {
        return new ResponseEntity<OperationResponseDTO>(
                service.operacionMatematica(
                        operationRequestDTO), HttpStatus.OK);
    }

}