package com.demo.demosopra.service;

import com.demo.demosopra.dto.OperationRequestDTO;
import com.demo.demosopra.dto.OperationResponseDTO;
import com.demo.demosopra.exception.OperationErrorException;
import com.demo.demosopra.repository.OperationServiceRepo;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

import static com.demo.demosopra.util.Constantes.MENSAJE_ERROR_RESTA;

@Service
public class OperationService implements OperationServiceRepo {
    public OperationResponseDTO operacionMatematica(OperationRequestDTO dto) throws OperationErrorException {
        TracerImpl tracer = new TracerImpl();


        return switch (dto.getOperacion()) {
            case SUMA -> {
                var suma = dto.getDatoA() + dto.getDatoB();
                tracer.trace(suma);
                yield new OperationResponseDTO(suma);
            }
            case RESTA -> {
                if (dto.getDatoB() > dto.getDatoA()) {
                    throw new OperationErrorException(MENSAJE_ERROR_RESTA);
                }
                var resta = dto.getDatoA() - dto.getDatoB();
                tracer.trace(resta);
                yield new OperationResponseDTO(resta);
            }
        };
    }
}
