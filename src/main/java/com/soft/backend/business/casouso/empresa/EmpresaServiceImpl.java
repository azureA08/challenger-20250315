package com.soft.backend.business.casouso.empresa;


import com.soft.backend.domain.model.Empresa;
import com.soft.backend.infraestructure.adapters.empresa.EmpresaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaJpaRepository empresaRepository;

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa save(Empresa empresaAlta) {
        return empresaRepository.save(empresaAlta);
    }

    @Override
    public Optional<Empresa> findById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        empresaRepository.deleteById(id);
    }

    // Punto 1 Uno que traiga las empresas que hicieron transferencias el último mes
    public List<Empresa> findEmpresasConTransferenciasUltimoMes() {
        return empresaRepository.findEmpresasConTransferenciasUltimoMes();
    }

    //2. Otro que traiga las empresas que se adhirieron el último mes.

    public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
        LocalDate fechaInicioMesAnterior = YearMonth.now().minusMonths(1).atDay(1);
        return empresaRepository.findEmpresasAdheridasUltimoMes(fechaInicioMesAnterior);
    }

    //3 Metodao para adherir una empresa
    public Empresa adherirEmpresa(Empresa empresa) {
        empresa.setFechaAdhesion(LocalDate.now());
        return empresaRepository.save(empresa);
    }


}