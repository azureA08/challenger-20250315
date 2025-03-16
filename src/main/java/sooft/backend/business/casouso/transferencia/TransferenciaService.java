package sooft.backend.business.casouso.transferencia;

import sooft.backend.domain.model.Transferencia;

import java.util.List;
import java.util.Optional;

public interface TransferenciaService {
    List<Transferencia> findAll();

    Transferencia save(Transferencia transferenciaAlta);

    Optional<Transferencia> findById(Long id);

    void deleteById(Long id);
}
