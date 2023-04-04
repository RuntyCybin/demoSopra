package com.demo.demosopra.service;

import com.demo.demosopra.dto.OperationRequestDTO;
import com.demo.demosopra.dto.OperationResponseDTO;
import com.demo.demosopra.exception.OperationErrorException;
import org.springframework.stereotype.Service;

import static com.demo.demosopra.util.Constantes.MENSAJE_ERROR_RESTA;

@Service
public class OperationService {

    public OperationResponseDTO operacionMatematica(OperationRequestDTO dto) throws OperationErrorException {

        return switch (dto.getOperacion()) {
            case SUMA -> new OperationResponseDTO(dto.getDatoA() + dto.getDatoB());
            case RESTA -> {
                if (dto.getDatoB() > dto.getDatoB()) {
                    throw new OperationErrorException(MENSAJE_ERROR_RESTA);
                }
                yield new OperationResponseDTO(dto.getDatoA() - dto.getDatoB());
            }
        };
    }
}
