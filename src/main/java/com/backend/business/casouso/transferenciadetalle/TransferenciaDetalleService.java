package com.backend.business.casouso.transferenciadetalle;

import com.backend.domain.model.TransferenciaDetalle;

import java.util.List;
import java.util.Optional;

public interface TransferenciaDetalleService {

    List<TransferenciaDetalle> findAll();

    TransferenciaDetalle save(TransferenciaDetalle transferenciaDetalleAlta);

    Optional<TransferenciaDetalle> findById(Long id);

    void deleteById(Long id);

    TransferenciaDetalle upLocalDateInfo(long infoID, TransferenciaDetalle transferenciaDetalle);

    List<TransferenciaDetalle> findByFechaCreacionBetween(int start, int end);
}
