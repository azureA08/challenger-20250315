package sooft.backend.business.casouso.transferencia;

import sooft.backend.domain.model.Transferencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransferenciaService {
    List<Transferencia> findAll();

    Transferencia save(Transferencia transferenciaAlta);

    Optional<Transferencia> findById(Long id);

    void deleteById(Long id);

    List<Transferencia> buscarPorImporteMayorQue(BigDecimal importe);

    List<Transferencia> buscarPorImporteMayorQue(LocalDateTime fecha);

    List<Transferencia> buscarPorFechaAnterior(LocalDateTime fecha);
}
