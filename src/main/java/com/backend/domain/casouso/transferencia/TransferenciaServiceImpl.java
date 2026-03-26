package com.backend.domain.casouso.transferencia;

import com.backend.domain.model.Transferencia;
import com.backend.infrastructure.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Override
    public List<Transferencia> findAll() {
        return transferenciaRepository.findAll();
    }


    @Override
    public Transferencia upLocalDateTransferenia(long transferenciaId, Transferencia transferencia) {
        Transferencia transferenciaDB = this.findById(transferenciaId).orElse(null);
        if (transferenciaDB == null) {
            return this.save(transferencia);
        }
        transferencia.setId(transferenciaId);
        return this.save(transferencia);
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
    public List<Transferencia> buscarPorFechaAnterior(LocalDate fecha) {
        return transferenciaRepository.buscarPorFechaAnterior(fecha);
    }


}
