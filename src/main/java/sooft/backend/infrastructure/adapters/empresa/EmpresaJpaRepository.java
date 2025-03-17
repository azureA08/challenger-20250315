package sooft.backend.infrastructure.adapters.empresa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sooft.backend.domain.model.Empresa;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmpresaJpaRepository extends JpaRepository<Empresa, Long> {
    @Query(value = "SELECT DISTINCT e.* FROM Empresa e " +
            "JOIN ApiTransaccionDetalle t ON e.cuit = t.cuitEmpresa " +
            "WHERE t.fechaTransaccion >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)",
            nativeQuery = true)
    List<Empresa> findEmpresasConTransferenciasUltimoMes();

    @Query("SELECT e FROM Empresa e WHERE e.fechaAdhesion >= :fechaInicioMesAnterior")
    List<Empresa> findEmpresasAdheridasUltimoMes(@Param("fechaInicioMesAnterior") LocalDate fechaInicioMesAnterior);
    @Query(value = "SELECT DISTINCT e.* FROM Empresa e " +
            "JOIN ApiTransaccionDetalle t ON e.cuit = t.cuitEmpresa " +
            "WHERE t.fechaTransaccion >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)",
            nativeQuery = true)
    List<Empresa> obtenerEmpresasAdheridasUltimoMes();


    Empresa adherirEmpresa(Empresa empresa);
}