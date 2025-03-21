package com.soft.backend.business.dto;

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
    private String cuit;
    private String razonSocial;
    //private LocalDate fechaAdhesion;
    //Fecha int yyyyMMDDDhhmmss  para facilitar ordenamiento,
    // comparaciones y extraccion de info que expone la Api
    private int fechaAdhesion;

    //Informacion de la transaccion asociada a una empresa
    private BigDecimal importe;
    private String cuentaDebito;
    private String cuentaCredito;
    //private LocalDate fechaTransaccion;
    //Fecha int yyyyMMDDDhhmmss  para facilitar ordenamiento,
    // comparaciones y extraccion de info que expone la Api
    private int fechaTransaccion;


}
