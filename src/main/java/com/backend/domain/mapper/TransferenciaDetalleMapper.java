package com.backend.domain.mapper;

import com.backend.domain.casouso.dto.TrasferenciaDetalleDto;
import com.backend.domain.model.TransferenciaDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TransferenciaDetalleMapper {

    TransferenciaDetalleMapper INSTANCE = Mappers.getMapper(TransferenciaDetalleMapper.class);

    @Mapping(source = "id", target = "id")
    TrasferenciaDetalleDto transferenciaDetalleTotransferenciaDetalleDto(TransferenciaDetalle transferenciaDetalle);

    @Mapping(source = "id", target = "id")
    TransferenciaDetalle transferenciaDetalleDtoTotransferenciaDetalle(TrasferenciaDetalleDto transferenciaDetalleDto);
}
