package com.soft.backend.business.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

/****
 * DTO de la informacion transaccinal,
 * que expone la API Tranasacciones.
 * Al almacenar en una sola tabla le informacion,
 * incremanta el tiempo de respuesta de la api
 */
@Data
public class ApiTransaccionDetalleDTO {


    //Informacion de la empresa

    @NotBlank(message = "El Cuit es obligatorio")
    private String cuit;
    @NotBlank(message = "La Razon Social obligatorio")
    private String razonSocial;
    //private LocalDate fechaAdhesion;
    //Fecha int yyyyMMDDDhhmmss  para facilitar ordenamiento,
    // comparaciones y extraccion de info que expone la Api
    @NotNull(message = "El fecha es obligatorio")
    private int fechaAdhesion;

    //Informacion de la transaccion asociada a una empresa
    @NotNull(message = "El importe es obligatorio")
    private BigDecimal importe;
    @NotBlank(message = "El Numero de cuenta debito es obligatorio")
    private String cuentaDebito;
    @NotBlank(message = "El numero de cuenta de credito es obligatorio")
    private String cuentaCredito;
    //private LocalDate fechaTransaccion;
    //Fecha int yyyyMMDDDhhmmss  para facilitar ordenamiento,
    // comparaciones y extraccion de info que expone la Api
    @NotNull(message = "El fecha es obligatorio")
    private int fechaTransaccion;


}
