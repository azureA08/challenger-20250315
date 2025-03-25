package com.soft.backend.business.dto.validacion;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DatosTransferenciaDto {

    @NotNull(message = "El importe no puede ser nulo")
    @Positive(message = "El importe debe ser positivo")
    private Double importe;

    @NotBlank(message = "El ID de la empresa no puede estar en blanco")
    private String idEmpresa;

    @NotBlank(message = "La cuenta de débito no puede estar en blanco")
    private String cuentaDebito;

    @NotBlank(message = "La cuenta de crédito no puede estar en blanco")
    private String cuentaCredito;


}
