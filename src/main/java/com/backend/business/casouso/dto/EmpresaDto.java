package com.backend.business.casouso.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmpresaDto {

    @NotBlank(message = "La razón social no puede estar en blanco")
    @Size(min = 3, max = 100, message = "La razón social debe tener entre 3 y 100 caracteres")
    private String razonSocial;
    @NotBlank(message = "El CUIT no puede estar en blanco")
    @Size(min = 11, max = 11, message = "El CUIT debe tener 11 dígitos")
    private String cuit;
    @NotNull(message = "La fecha de adhesión no puede ser nula")
    @PastOrPresent(message = "La fecha de adhesión debe ser pasada o presente")
    private LocalDate fechaAdhesion;
}
