package com.backend.domain.casouso.transferenciadetalle;

import com.backend.domain.model.TransferenciaDetalle;
import com.backend.infrastructure.repositories.TransferenciaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaDetalleServiceImpl implements TransferenciaDetalleService {
    @Autowired
    private TransferenciaDetalleRepository transferenciaDetalleRepository;

    @Override
    public List<TransferenciaDetalle> findAll() {
        return transferenciaDetalleRepository.findAll();
    }


    @Override
    public TransferenciaDetalle upLocalDateTransferenciaDetalle(long TransferenciaDetalleID, TransferenciaDetalle TransferenciaDetalle) {
        TransferenciaDetalle transferenciaDetalleDB = this.findById(TransferenciaDetalleID).orElse(null);
        if (transferenciaDetalleDB.equals(null))
            this.save(TransferenciaDetalle);
        return TransferenciaDetalle;

    }

    @Override
    public TransferenciaDetalle save(TransferenciaDetalle transferenciaDetalleAlta) {
        return transferenciaDetalleRepository.save(transferenciaDetalleAlta);
    }

    @Override
    public Optional<TransferenciaDetalle> findById(Long id) {
        return transferenciaDetalleRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        transferenciaDetalleRepository.deleteById(id);
    }


    @Override
    public List<TransferenciaDetalle> findByFechaCreacionBetween(int start, int end) {
        return transferenciaDetalleRepository.findByFechaCreacionBetween(start, end);
    }

}