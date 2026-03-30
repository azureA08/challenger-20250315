package com.backend.infrastructure.repositories;

import com.backend.domain.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("SELECT DISTINCT e FROM Empresa e JOIN e.transferencias t " +
            "WHERE t.fechaTransferencia >= :fechaInicioMesAnterior")
    List<Empresa> findEmpresasConTransferenciasUltimoMes(@Param("fechaInicioMesAnterior") LocalDate fechaInicioMesAnterior);

    @Query("SELECT e FROM Empresa e WHERE e.fechaAdhesion >= :fechaInicioMesAnterior")
    List<Empresa> findEmpresasAdheridasUltimoMes(@Param("fechaInicioMesAnterior") LocalDate fechaInicioMesAnterior);


}
