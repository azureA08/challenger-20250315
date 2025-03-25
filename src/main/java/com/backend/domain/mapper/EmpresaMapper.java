package com.backend.domain.mapper;

import com.backend.business.casouso.dto.EmpresaDto;
import com.backend.domain.model.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface EmpresaMapper {

    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    @Mapping(source = "id", target = "id")
    EmpresaDto userTouserDto(Empresa empresa);

    @Mapping(source = "id", target = "id")
    Empresa userDtoTouser(EmpresaDto userDto);
}
