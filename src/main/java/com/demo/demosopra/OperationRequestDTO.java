package com.demo.demosopra;

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
}
