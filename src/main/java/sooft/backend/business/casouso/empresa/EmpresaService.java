package sooft.backend.business.casouso.empresa;

import sooft.application.StateOperacionEnum;
import sooft.backend.business.dto.EmpresaDTO;
import sooft.backend.domain.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    List<Empresa> findAll();

    Empresa save(Empresa empresaAlta);

    Optional<Empresa> findById(Long id);

    void deleteById(Long id);
    //Punto 1 Uno que traiga las empresas que hicieron transferencias el último mes
    List<Empresa> findEmpresasConTransferenciasUltimoMes();
    //2. Otro que traiga las empresas que se adhirieron el último mes.
    List<Empresa> obtenerEmpresasAdheridasUltimoMes();
    //Para el punto 3 de adherir una empresa
    StateOperacionEnum adhesionEmpreresa(EmpresaDTO empresaDTO);
}
