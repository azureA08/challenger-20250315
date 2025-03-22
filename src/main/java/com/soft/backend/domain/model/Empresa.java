package com.soft.backend.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/*****
 * Informacion de la empresa
 */

@Table(name = "empresa")
@Entity
@Data
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cuit;
    @Column
    private String razonSocial;
    @Column
    private LocalDate fechaAdhesion;

    public Empresa() {

    }

    public Empresa(String cuit, String razonSocial, LocalDate fechaAdhesion) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.fechaAdhesion = fechaAdhesion;
    }


}