package sooft.backend.business.casouso.transferencia;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sooft.backend.domain.model.Transferencia;
import sooft.backend.infrastructure.adapters.transferecia.TransferenciaJpaRepository;

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

}