package sooft.backend.infrastructure.adapters.transferecia;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sooft.backend.domain.model.Transferencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaJpaRepository extends JpaRepository<Transferencia, Long> {


    @Query("SELECT t FROM Transferencia t WHERE t.importe > :importeMinimo")
    List<Transferencia> buscarPorImporteMayorQue(@Param("importeMinimo") BigDecimal importeMinimo);

    @Query("SELECT t FROM Transferencia t WHERE t.fechaTransaccion < :fechaLimite")
    List<Transferencia> buscarPorFechaAnterior(@Param("fechaLimite") LocalDateTime fechaLimite);


}