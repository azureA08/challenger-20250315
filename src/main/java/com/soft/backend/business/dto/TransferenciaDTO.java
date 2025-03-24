package com.soft.backend.business.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;

@Data
public class TransferenciaDTO {

    @NotNull(message = "El importe es obligatorio")
    private BigDecimal importe;
    @NotBlank(message = "El idEmpresa / CUIT es obligatorio")
    private String idEmpresa;
    @NotBlank(message = "El Numero de cuenta debito es obligatorio")
    private String cuentaDebito;
    @NotBlank(message = "El numero de cuenta de credito es obligatorio")
    private String cuentaCredito;
    @NotNull(message = "El fecha es obligatorio")
    private Calendar fechaTransaccion;

}
