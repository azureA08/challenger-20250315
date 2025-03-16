package sooft.backend.infrastructure.adapters.empresa;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sooft.backend.business.casouso.empresa.EmpresaService;
import sooft.backend.domain.model.Empresa;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmpresaJpaAdapter implements EmpresaService {

    @Autowired
    private EmpresaJpaRepository empresaJpaRepository;


    @Override
    public List<Empresa> findAll() {
        return empresaJpaRepository.findAll();
    }

    @Override
    public Empresa save(Empresa empresaAlta) {
        return empresaJpaRepository.save(empresaAlta);
    }

    @Override
    public Optional<Empresa> findById(Long id) {
        return empresaJpaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        empresaJpaRepository.deleteById(id);

    }
}