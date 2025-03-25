package com.backend.domain.casouso.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TrasferenciaDetalleDto {

    List<TransferenciaDto> transferencias;
    private EmpresaDto empresa;

}
