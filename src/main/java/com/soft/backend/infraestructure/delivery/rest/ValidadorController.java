package com.soft.backend.infraestructure.delivery.rest;

import com.soft.backend.business.casouso.empresa.EmpresaService;
import com.soft.backend.business.casouso.transferencia.TransferenciaService;
import com.soft.backend.business.dto.EmpresaDTO;
import com.soft.backend.business.dto.TransferenciaDTO;
import com.soft.backend.domain.mapper.DatosMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/validacion/")
public class ValidadorController {

    private DatosMapper datosMapper;
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private TransferenciaService transferenciaService;

    public ValidadorController(DatosMapper datosMapper) {
        this.datosMapper = datosMapper;
    }

    @PostMapping("/empresas")
    public ResponseEntity<String> crearEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) {
        //TODO Lógica para crear la empresa
        empresaService.save(datosMapper.empresaDTOaEmpresa(empresaDTO));
        return ResponseEntity.ok("Empresa creada con éxito");
    }

    @PostMapping("/transferencias")
    public ResponseEntity<String> crearTransferencia(@Valid @RequestBody TransferenciaDTO transferenciaDTO) {
        //TODO Lógica para crear la transferencia
        transferenciaService.save(datosMapper.transferenciaAtransferenciaDTO(transferenciaDTO));
        return ResponseEntity.ok("Transferencia creada con éxito");
    }


}