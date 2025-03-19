package sooft.backend.domain.mapper;


import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sooft.backend.business.dto.EmpresaDTO;
import sooft.backend.business.dto.TransferenciaDTO;
import sooft.backend.domain.model.Empresa;
import sooft.backend.domain.model.Transferencia;

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
    Transferencia transferenciaAtransferenciaDTO(@Valid TransferenciaDTO transferencia);
}