package com.demo.demosopra;

import com.demo.demosopra.dto.OperationRequestDTO;
import com.demo.demosopra.dto.OperationResponseDTO;
import com.demo.demosopra.exception.OperationErrorException;
import com.demo.demosopra.service.OperationServiceImpl;
import com.demo.demosopra.util.EnumOperaciones;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Mock
    private OperationServiceImpl operationServiceImpl;

    @InjectMocks
    private OperationServiceImpl operationServiceImpl1;

    @Test
    void operacionSumaSuccess() throws OperationErrorException {

        OperationRequestDTO operationRequestDTO = mock(OperationRequestDTO.class);

        OperationResponseDTO operationResponseDTO = new OperationResponseDTO(4);

        lenient().when(operationServiceImpl.operacionMatematica(operationRequestDTO)).thenReturn(operationResponseDTO);

        OperationResponseDTO resultDTO = operationServiceImpl1.operacionMatematica(
                new OperationRequestDTO(1,3,EnumOperaciones.SUMA));

        assertEquals(4, resultDTO.getResultado(), "Unexpected result");
    }

    @Test
    void operacionSumaFail() throws OperationErrorException {

        OperationRequestDTO operationRequestDTO = mock(OperationRequestDTO.class);

        OperationResponseDTO operationResponseDTO = new OperationResponseDTO(4);

        lenient().when(operationServiceImpl.operacionMatematica(operationRequestDTO)).thenReturn(operationResponseDTO);

        OperationResponseDTO resultDTO = operationServiceImpl1.operacionMatematica(
                new OperationRequestDTO(1,3,EnumOperaciones.SUMA));

        assertNotEquals(5, resultDTO.getResultado(), "Unexpected result");
    }

    @Test
    void operacionRestaSuccess() throws OperationErrorException {

        OperationRequestDTO operationRequestDTO = mock(OperationRequestDTO.class);

        OperationResponseDTO operationResponseDTO = new OperationResponseDTO(4);

        lenient().when(operationServiceImpl.operacionMatematica(operationRequestDTO)).thenReturn(operationResponseDTO);

        OperationResponseDTO resultDTO = operationServiceImpl1.operacionMatematica(
                new OperationRequestDTO(2,1,EnumOperaciones.RESTA));

        assertEquals(1, resultDTO.getResultado(), "Unexpected result");
    }

    @Test
    void operacionRestaFail() throws OperationErrorException {

        OperationRequestDTO operationRequestDTO = mock(OperationRequestDTO.class);

        OperationResponseDTO operationResponseDTO = new OperationResponseDTO(4);

        lenient().when(operationServiceImpl.operacionMatematica(operationRequestDTO)).thenReturn(operationResponseDTO);

        OperationErrorException resultDTO = assertThrows(OperationErrorException.class, () -> {
            operationServiceImpl1.operacionMatematica(
                    new OperationRequestDTO(1,2,EnumOperaciones.RESTA));
        });

        String mensajeError = "Error, datoA tiene que ser superior al datoB";

        assertTrue(resultDTO.getMessage().contains(mensajeError));
    }
}
