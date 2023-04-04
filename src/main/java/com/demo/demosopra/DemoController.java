package com.demo.demosopra;

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
    ) {
        OperationResponseDTO operationResponseDTO = new OperationResponseDTO();
        return new ResponseEntity<OperationResponseDTO>(operationResponseDTO, HttpStatus.OK);
    }

}
