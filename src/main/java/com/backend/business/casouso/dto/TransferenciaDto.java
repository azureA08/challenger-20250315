package com.backend.business.casouso.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/***
 * DTTO del Contexto o informacion de un transferencia
 */
@Data
@Builder
public class TransferenciaDto {

    @NotNull(message = "El importe no puede ser nulo")
    @DecimalMin(value = "0.01", message = "El importe debe ser mayor que 0")
    private BigDecimal importe;

    @NotBlank(message = "La cuenta de débito no puede estar en blanco")
    @Size(min = 10, max = 20, message = "La cuenta de débito debe tener entre 10 y 20 caracteres")
    private String cuentaDebito;

    @NotBlank(message = "La cuenta de crédito no puede estar en blanco")
    @Size(min = 10, max = 20, message = "La cuenta de crédito debe tener entre 10 y 20 caracteres")
    private String cuentaCredito;

    @NotNull(message = "La fecha de transferencia no puede ser nula")
    @PastOrPresent(message = "La fecha de transferencia debe ser pasada o presente")
    private LocalDate fechaTransferencia;

}