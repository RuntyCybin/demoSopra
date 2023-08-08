package com.demo.demosopra.service;

import com.demo.demosopra.dto.OperationRequestDTO;
import com.demo.demosopra.dto.OperationResponseDTO;
import com.demo.demosopra.exception.OperationErrorException;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.demo.demosopra.util.Constantes.MENSAJE_ERROR_RESTA;

@Service
public class OperationServiceImpl implements OperationService {

    private TracerImpl tracer;

    @Autowired
    public OperationServiceImpl() {
        tracer = new TracerImpl();
    }

    public OperationResponseDTO operacionMatematica(OperationRequestDTO dto) throws OperationErrorException {

        return switch (dto.getOperacion()) {
            case SUMA -> {
                var suma = dto.getDatoA() + dto.getDatoB();
                tracer.trace(suma);
                yield new OperationResponseDTO(suma);
            }
            case RESTA -> {
                if (dto.getDatoB() > dto.getDatoA()) {
                    tracer.trace("ERROR RESTA: " + MENSAJE_ERROR_RESTA);
                    throw new OperationErrorException(MENSAJE_ERROR_RESTA);
                }
                var resta = dto.getDatoA() - dto.getDatoB();
                tracer.trace(resta);
                yield new OperationResponseDTO(resta);
            }
        };
    }
}
