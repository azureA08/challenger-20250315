package com.soft.backend.business.casouso.apitransaccion;


import com.soft.backend.domain.model.ApiTransaccionDetalle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ApiTransaccionDetalleService {

    List<ApiTransaccionDetalle> findAll();

    ApiTransaccionDetalle save(ApiTransaccionDetalle empresaAlta);

    Optional<ApiTransaccionDetalle> findById(Long id);

    void deleteById(Long id);

    List<ApiTransaccionDetalle> findByFechaCreacionBetween(LocalDateTime start, LocalDateTime end);

}
