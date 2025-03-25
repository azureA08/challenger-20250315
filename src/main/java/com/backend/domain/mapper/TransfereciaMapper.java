package com.backend.domain.mapper;

import com.backend.business.casouso.dto.TrasferenciaDetalleDto;
import com.backend.domain.model.Transferencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TransfereciaMapper {

    TransfereciaMapper INSTANCE = Mappers.getMapper(TransfereciaMapper.class);

    @Mapping(source = "id", target = "id")
    TrasferenciaDetalleDto docunetToDocumentDto(Transferencia transferencia);

    @Mapping(source = "id", target = "id")
    Transferencia documentDtoToDocument(TrasferenciaDetalleDto trasferenciaDetalleDto);
}
