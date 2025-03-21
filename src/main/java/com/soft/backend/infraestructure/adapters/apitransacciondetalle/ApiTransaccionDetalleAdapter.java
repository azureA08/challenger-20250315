package com.soft.backend.infraestructure.adapters.apitransacciondetalle;


import com.soft.backend.business.casouso.apitransaccion.ApiTransaccionDetalleService;
import com.soft.backend.domain.model.ApiTransaccionDetalle;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ApiTransaccionDetalleAdapter implements ApiTransaccionDetalleService {

    @Autowired
    private ApiTransaccionDetalleJpaRepository apiTransaccionDetalleRepository;


    @Override
    public List<ApiTransaccionDetalle> findAll() {
        return apiTransaccionDetalleRepository.findAll();
    }


    @Override
    public ApiTransaccionDetalle save(ApiTransaccionDetalle apiTransaccionDetalle) {
        return apiTransaccionDetalleRepository.save(apiTransaccionDetalle);
    }

    @Override
    public Optional<ApiTransaccionDetalle> findById(Long id) {
        return apiTransaccionDetalleRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        apiTransaccionDetalleRepository.deleteById(id);

    }

    public List<ApiTransaccionDetalle> findByFechaCreacionBetween(LocalDateTime start, LocalDateTime end) {
        return apiTransaccionDetalleRepository.findByFechaCreacionBetween(start, end);
    }
}