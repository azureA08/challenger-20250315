package com.backend.domain.mapper;

import com.backend.domain.casouso.dto.TrasferenciaDetalleDto;
import com.backend.domain.model.TransferenciaDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TransferenciaDetalleMapper {

    TransferenciaDetalleMapper INSTANCE = Mappers.getMapper(TransferenciaDetalleMapper.class);

    TrasferenciaDetalleDto transferenciaDetalleTotransferenciaDetalleDto(TransferenciaDetalle transferenciaDetalle);

    TransferenciaDetalle transferenciaDetalleDtoTotransferenciaDetalle(TrasferenciaDetalleDto transferenciaDetalleDto);
}
