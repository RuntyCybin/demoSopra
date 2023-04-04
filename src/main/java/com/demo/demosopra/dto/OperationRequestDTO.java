package com.demo.demosopra.dto;

import com.demo.demosopra.util.EnumOperaciones;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperationRequestDTO implements Serializable {

    private Integer datoA;
    private Integer datoB;
    private EnumOperaciones operacion;
}
