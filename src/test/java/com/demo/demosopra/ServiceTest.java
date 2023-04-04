package com.demo.demosopra;

import com.demo.demosopra.dto.OperationRequestDTO;
import com.demo.demosopra.dto.OperationResponseDTO;
import com.demo.demosopra.exception.OperationErrorException;
import com.demo.demosopra.service.OperationService;
import com.demo.demosopra.util.EnumOperaciones;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private OperationService operationService;

    @InjectMocks
    private OperationService operationService1;

    @Test
    public void operacionSumaSuccess() throws OperationErrorException {

        OperationRequestDTO operationRequestDTO = mock(OperationRequestDTO.class);

        OperationResponseDTO operationResponseDTO = new OperationResponseDTO(4);

        lenient().when(operationService.operacionMatematica(operationRequestDTO)).thenReturn(operationResponseDTO);

        OperationResponseDTO resultDTO = operationService1.operacionMatematica(
                new OperationRequestDTO(1,3,EnumOperaciones.SUMA));

        assertTrue(resultDTO.getResultado() == 4);
    }

    @Test
    public void operacionSumaFail() throws OperationErrorException {

        OperationRequestDTO operationRequestDTO = mock(OperationRequestDTO.class);

        OperationResponseDTO operationResponseDTO = new OperationResponseDTO(4);

        lenient().when(operationService.operacionMatematica(operationRequestDTO)).thenReturn(operationResponseDTO);

        OperationResponseDTO resultDTO = operationService1.operacionMatematica(
                new OperationRequestDTO(1,3,EnumOperaciones.SUMA));

        assertFalse(resultDTO.getResultado() == 5);
    }

    @Test
    public void operacionRestaSuccess() throws OperationErrorException {

        OperationRequestDTO operationRequestDTO = mock(OperationRequestDTO.class);

        OperationResponseDTO operationResponseDTO = new OperationResponseDTO(4);

        lenient().when(operationService.operacionMatematica(operationRequestDTO)).thenReturn(operationResponseDTO);

        OperationResponseDTO resultDTO = operationService1.operacionMatematica(
                new OperationRequestDTO(2,1,EnumOperaciones.RESTA));

        assertTrue(resultDTO.getResultado() == 1);
    }

    @Test
    public void operacionRestaFail() throws OperationErrorException {

        OperationRequestDTO operationRequestDTO = mock(OperationRequestDTO.class);

        OperationResponseDTO operationResponseDTO = new OperationResponseDTO(4);

        lenient().when(operationService.operacionMatematica(operationRequestDTO)).thenReturn(operationResponseDTO);

        OperationErrorException resultDTO = assertThrows(OperationErrorException.class, () -> {
            operationService1.operacionMatematica(
                    new OperationRequestDTO(1,2,EnumOperaciones.RESTA));
        });

        String mensajeError = "Error, datoA tiene que ser superior al datoB";

        assertTrue(resultDTO.getMessage().contains(mensajeError));
    }
}
