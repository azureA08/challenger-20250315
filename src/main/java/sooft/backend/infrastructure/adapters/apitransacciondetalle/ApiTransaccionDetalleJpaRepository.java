package sooft.backend.infrastructure.adapters.apitransacciondetalle;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sooft.backend.domain.model.ApiTransaccionDetalle;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ApiTransaccionDetalleJpaRepository extends JpaRepository<ApiTransaccionDetalle, Long> {

    @Query("SELECT p FROM ApiTransaccionDetalle p WHERE p.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    List<ApiTransaccionDetalle> findByFechaCreacionBetween(
            @Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin
    );
}