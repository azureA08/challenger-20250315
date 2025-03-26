package com.backend.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/***
 * Contexto o TransferenciaDetallermacion de cada transferencia
 * que integra un grupo
 */

@Table(name = "transferencia-detalle")
@Data
@NoArgsConstructor
@Entity
public class TransferenciaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TransferenciaDetallermacion de la empresa

    @Column
    private String cuit;
    @Column
    private String razonSocial;
    //private Calendar fechaAdhesion;
    //Fecha int yyyyMMDDDhhmmss  para facilitar ordenamiento,
    // comparaciones y extraccion de TransferenciaDetalle que expone la Api
    @Column
    private int fechaAdhesion;

    //TransferenciaDetallermacion de la transaccion asociada a una empresa
    @Column
    private BigDecimal importe;
    @Column
    private String cuentaDebito;
    @Column
    private String cuentaCredito;
    //private Calendar fechaTransferencia;
    //Fecha int yyyyMMDDDhhmmss  para facilitar ordenamiento,
    // comparaciones y extraccion de TransferenciaDetalle que expone la Api
    @Column
    private int fechaTransferencia;

}