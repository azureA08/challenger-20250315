package com.backend.domain.mapper;

import com.backend.domain.casouso.dto.TrasferenciaDetalleDto;
import com.backend.domain.model.Transferencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TransfereciaMapper {

    TransfereciaMapper INSTANCE = Mappers.getMapper(TransfereciaMapper.class);

    @Mapping(source = "id", target = "id")
    TrasferenciaDetalleDto docunetToTransferenciaDto(Transferencia transferencia);

    @Mapping(source = "id", target = "id")
    Transferencia TransferenciaDtoToTransferencia(TrasferenciaDetalleDto trasferenciaDetalleDto);
}
