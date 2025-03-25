package com.backend.domain.casouso.empresa;

import com.backend.domain.model.Empresa;
import com.backend.infrastructure.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa save(String razonSocial, String cuit, LocalDate fechaCreacion) {
        Empresa empresaAlta = new Empresa();

        empresaAlta.setRazonSocial(razonSocial);
        empresaAlta.setCuit(cuit);
        empresaAlta.setFechaAdhesion(fechaCreacion);
        return empresaRepository.save(empresaAlta);
    }

    @Override
    public Empresa upLocalDateEmpresa(long id, Empresa empresa) {
        empresa.setId(id);
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
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