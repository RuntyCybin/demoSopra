package com.demo.demosopra.repository;

import com.demo.demosopra.dto.OperationRequestDTO;
import com.demo.demosopra.dto.OperationResponseDTO;
import com.demo.demosopra.exception.OperationErrorException;

public interface OperationServiceRepo {
    OperationResponseDTO operacionMatematica(OperationRequestDTO dto) throws OperationErrorException;
}
