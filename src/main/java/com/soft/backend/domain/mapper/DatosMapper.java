package com.soft.backend.domain.mapper;


import com.soft.backend.business.dto.EmpresaDTO;
import com.soft.backend.business.dto.TransferenciaDTO;
import com.soft.backend.domain.model.Empresa;
import com.soft.backend.domain.model.Transferencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface DatosMapper {


    DatosMapper INSTANCE = Mappers.getMapper(DatosMapper.class);

    @Mapping(source = "id", target = "id")
    Empresa empresaDTOaEmpresa(EmpresaDTO empresaDTO);

    @Mapping(source = "id", target = "id")
    Transferencia transferenciaDTOaTransferencia(TransferenciaDTO transferenciaDTO);


    @Mapping(source = "id", target = "id")
    EmpresaDTO empresaAempresaDTO(Empresa empresa);


    @Mapping(source = "id", target = "id")
    Transferencia transferenciaAtransferenciaDTO(TransferenciaDTO transferencia);
}