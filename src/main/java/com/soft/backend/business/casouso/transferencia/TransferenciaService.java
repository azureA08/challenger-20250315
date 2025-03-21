package com.soft.backend.business.casouso.transferencia;


import com.soft.backend.domain.model.Transferencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransferenciaService {
    List<Transferencia> findAll();

    Transferencia save(Transferencia transferencia);

    Optional<Transferencia> findById(Long id);

    void deleteById(Long id);

    List<Transferencia> buscarPorImporteMayorQue(BigDecimal importe);

    List<Transferencia> buscarPorFechaAnterior(LocalDateTime fecha);
}
