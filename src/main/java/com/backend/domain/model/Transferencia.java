package com.backend.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/***
 * Informacion del transferencia
 */
@Table(name = "transferencia")
@Data
@NoArgsConstructor
@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private BigDecimal importe;
    @Column
    private String cuentaDebito;
    @Column
    private String cuentaCredito;
    @Column
    private String idEmpresa;
    @Column
    private LocalDate fechaTransferencia;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;


}