package com.soft.backend.business.casouso.transferencia;


import com.soft.backend.domain.model.Transferencia;
import com.soft.backend.infraestructure.adapters.transferecia.TransferenciaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    @Autowired
    private TransferenciaJpaRepository transferenciaRepository;

    @Override
    public List<Transferencia> findAll() {
        return transferenciaRepository.findAll();
    }

    @Override
    public Transferencia save(Transferencia transferenciaAlta) {
        return transferenciaRepository.save(transferenciaAlta);
    }

    @Override
    public Optional<Transferencia> findById(Long id) {
        return transferenciaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        transferenciaRepository.deleteById(id);
    }

    @Override
    public List<Transferencia> buscarPorImporteMayorQue(BigDecimal importe) {
        return transferenciaRepository.buscarPorImporteMayorQue(importe);
    }

    @Override
    public List<Transferencia> buscarPorFechaAnterior(LocalDateTime fecha) {
        return transferenciaRepository.buscarPorFechaAnterior(fecha);
    }

}