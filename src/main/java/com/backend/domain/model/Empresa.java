package com.backend.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Table(name = "empresa")
@Data
@NoArgsConstructor
@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String razonSocial;
    @Column(unique = true)
    private String cuit;
    @Column
    private LocalDate fechaAdhesion;

    @OneToMany(mappedBy = "empresa")
    private List<Transferencia> transferencias;


}
