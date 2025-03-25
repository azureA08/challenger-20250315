package com.backend.business.casouso.transferencia;

import com.backend.domain.model.Transferencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransferenciaService {

    List<Transferencia> findAll();

    Transferencia save(Transferencia transferenciaAlta);

    Optional<Transferencia> findById(Long id);

    void deleteById(Long id);

    Transferencia upLocalDateTransferenia(long id, Transferencia transferencia);

    List<Transferencia> buscarPorImporteMayorQue(BigDecimal importe);

    List<Transferencia> buscarPorFechaAnterior(LocalDateTime fecha);
}
