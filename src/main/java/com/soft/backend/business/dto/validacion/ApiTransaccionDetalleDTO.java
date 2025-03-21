package com.soft.backend.business.dto.validacion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ApiTransaccionDetalleDTO {

    @NotBlank(message = "El CUIT no puede estar en blanco")
    @Pattern(regexp = "\\d{2}-\\d{8}-\\d{1}", message = "Formato de CUIT inválido")
    private String cuit;

    @NotBlank(message = "La razón social no puede estar en blanco")
    private String razonSocial;

    @NotNull(message = "La fecha de adhesión no puede ser nula")
    private LocalDate fechaAdhesion;

    @NotNull(message = "El importe no puede ser nulo")
    @Positive(message = "El importe debe ser positivo")
    private Double importe;

    @NotBlank(message = "El ID de la empresa no puede estar en blanco")
    private String idEmpresa;

    @NotBlank(message = "La cuenta de débito no puede estar en blanco")
    private String cuentaDebito;

    @NotBlank(message = "La cuenta de crédito no puede estar en blanco")
    private String cuentaCredito;

    @NotNull(message = "La fecha de transacción no puede ser nula")
    private LocalDate fechaTransaccion;

}
