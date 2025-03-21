package com.soft.backend.business.casouso.apitransaccion;


import com.soft.backend.domain.model.ApiTransaccionDetalle;
import com.soft.backend.infraestructure.adapters.apitransacciondetalle.ApiTransaccionDetalleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ApiTransaccionDetalleServiceImpl implements ApiTransaccionDetalleService {


    @Autowired
    private ApiTransaccionDetalleJpaRepository apiTransaccionDetalleRepository;

    @Override
    public List<ApiTransaccionDetalle> findAll() {
        return apiTransaccionDetalleRepository.findAll();
    }


    @Override
    public Optional<ApiTransaccionDetalle> findById(Long id) {
        return apiTransaccionDetalleRepository.findById(id);
    }


    @Override
    public ApiTransaccionDetalle save(ApiTransaccionDetalle ApiTransaccionDetalle) {
        return apiTransaccionDetalleRepository.save(ApiTransaccionDetalle);
    }

    @Override
    public void deleteById(Long id) {
        apiTransaccionDetalleRepository.deleteById(id);
    }

    @Override
    public List<ApiTransaccionDetalle> findByFechaCreacionBetween(LocalDateTime start, LocalDateTime end) {
        return apiTransaccionDetalleRepository.findByFechaCreacionBetween(start, end);
    }


}