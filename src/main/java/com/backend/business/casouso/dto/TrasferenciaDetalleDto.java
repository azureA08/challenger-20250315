package com.backend.business.casouso.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TrasferenciaDetalleDto {

    List<TransferenciaDto> transferencias;
    private EmpresaDto empresa;

}
