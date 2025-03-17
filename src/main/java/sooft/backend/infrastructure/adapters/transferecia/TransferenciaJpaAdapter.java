package sooft.backend.infrastructure.adapters.transferecia;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sooft.backend.business.casouso.transferencia.TransferenciaService;
import sooft.backend.domain.model.Transferencia;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TransferenciaJpaAdapter implements TransferenciaService {

    @Autowired
    private TransferenciaJpaRepository transferenciaJpaRepository;


    @Override
    public List<Transferencia> findAll() {
        return transferenciaJpaRepository.findAll();
    }

    @Override
    public Transferencia save(Transferencia transferencia) {
        return transferenciaJpaRepository.save(transferencia);

    }

    @Override
    public Optional<Transferencia> findById(Long id) {
        return transferenciaJpaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        transferenciaJpaRepository.deleteById(id);

    }
    @Override
    public List<Transferencia> buscarPorImporteMayorQue(BigDecimal importe){
        return transferenciaJpaRepository.buscarPorImporteMayorQue(importe);
    }


    @Override
    public List<Transferencia> buscarPorFechaAnterior(LocalDateTime fecha){

        return transferenciaJpaRepository.buscarPorFechaAnterior(fecha);
    }

}