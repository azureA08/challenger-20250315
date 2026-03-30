package com.backend.domain.mapper;

import com.backend.domain.casouso.dto.EmpresaDto;
import com.backend.domain.model.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface EmpresaMapper {

    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    EmpresaDto empresaToEmpresaDto(Empresa empresa);

    Empresa empresaDtoToEmpresa(EmpresaDto empresaDto);
}
