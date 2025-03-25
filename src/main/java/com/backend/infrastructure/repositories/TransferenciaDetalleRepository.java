package com.backend.infrastructure.repositories;

import com.backend.domain.model.TransferenciaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferenciaDetalleRepository extends JpaRepository<TransferenciaDetalle, Long> {

    @Query("SELECT p FROM TransferenciaDetalle p WHERE p.fechaAdhesion BETWEEN :fechaInicio AND :fechaFin")
    List<TransferenciaDetalle> findByFechaCreacionBetween(
            @Param("fechaInicio") int fechaInicio,
            @Param("fechaFin") int fechaFin
    );


}
