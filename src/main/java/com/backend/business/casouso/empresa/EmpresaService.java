package com.backend.business.casouso.empresa;

import com.backend.domain.model.Empresa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    List<Empresa> findAll();

    Empresa save(String razonSocial, String cuit, LocalDate fechaCreacion);

    Empresa upLocalDateEmpresa(long id, Empresa empresa);

    Empresa save(Empresa empresa);

    Optional<Empresa> findById(Long id);

    void deleteById(Long id);

    //Punto 1 Uno que traiga las empresas que hicieron transferencias el último mes
    List<Empresa> findEmpresasConTransferenciasUltimoMes();

    //2. Otro que traiga las empresas que se adhirieron el último mes.
    List<Empresa> obtenerEmpresasAdheridasUltimoMes();

    //Para el punto 3 de adherir una empresa
    Empresa adherirEmpresa(Empresa empresa);

}
