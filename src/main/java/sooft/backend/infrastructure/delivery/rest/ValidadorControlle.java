package sooft.backend.infrastructure.delivery.rest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sooft.backend.business.casouso.empresa.EmpresaService;
import sooft.backend.business.casouso.transferencia.TransferenciaService;
import sooft.backend.business.dto.EmpresaDTO;
import sooft.backend.business.dto.TransferenciaDTO;
import sooft.backend.business.dto.validacion.DatosTransferenciaDTO;
import sooft.backend.domain.mapper.DatosMapper;

@RestController
@RequestMapping("api/validacion/")
public class ValidadorControlle {

    private DatosMapper datosMapper;
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private TransferenciaService transferenciaService;

    public ValidadorControlle(DatosMapper datosMapper) {
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