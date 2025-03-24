package com.soft.backend.business.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Calendar;

@Data
public class EmpresaDTO {

    @NotBlank(message = "El Cuit es obligatorio")
    private String cuit;
    @NotBlank(message = "La Razon Social obligatorio")
    private String razonSocial;
    @NotBlank(message = "La fecha de adhesion obligatorio")
    private int fechaAdhesion;
}
