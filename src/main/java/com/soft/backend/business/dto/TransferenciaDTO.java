package com.soft.backend.business.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;

@Data
public class TransferenciaDTO {

    private BigDecimal importe;
    private String idEmpresa;
    private String cuentaDebito;
    private String cuentaCredito;
    private Calendar fechaTransaccion;

}
