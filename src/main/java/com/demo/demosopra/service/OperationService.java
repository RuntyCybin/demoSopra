package com.demo.demosopra.service;

import com.demo.demosopra.dto.OperationRequestDTO;
import com.demo.demosopra.dto.OperationResponseDTO;
import com.demo.demosopra.exception.OperationErrorException;

public interface OperationService {
    OperationResponseDTO operacionMatematica(OperationRequestDTO dto) throws OperationErrorException;
}
