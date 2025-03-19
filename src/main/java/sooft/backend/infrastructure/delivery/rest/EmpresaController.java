package sooft.backend.infrastructure.delivery.rest;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sooft.backend.business.casouso.empresa.EmpresaService;
import sooft.backend.domain.model.Empresa;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/empresa/")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // insert a empresa into database
    @ApiOperation(value = "Adhesion de empresa", notes = "Adhesion de empresa")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<Empresa> saveempresa(@RequestBody Empresa empresa) {
        empresa.setId(0L);
        Empresa savedempresa = empresaService.save(empresa);
        return new ResponseEntity<>(savedempresa, HttpStatus.CREATED);
    }

    //get a single empresa by its id
    @ApiOperation(value = "Buscar de empresa por Id ", notes = "Buscar de empresa por Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<Empresa> getempresa(@RequestParam(name = "id") long id) {
        Optional<Empresa> empresa = empresaService.findById(id);
        return new ResponseEntity<Empresa>(empresa.orElse(null), HttpStatus.OK);
    }

    //get all the empresa in the table in our database
    @ApiOperation(value = "Buscar de toda la empresa . ", notes = "Buscar toda la empresa")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "empresas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public List<Empresa> getempresas() {
        return empresaService.findAll();
    }

    // delete an existing empresa in the database
    @ApiOperation(value = "Borrar  empresa por Id . ", notes = "Borrar empresa por Id . ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @DeleteMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )

    public ResponseEntity<Empresa> deleteempresa(@RequestParam(name = "id") long id) {
        Empresa deleteduser = empresaService.findById(id).orElse(null);
        empresaService.deleteById(id);
        return new ResponseEntity<>(deleteduser, HttpStatus.OK);
    }

    // 1-get Trealas empresas que hicieron transferencias el último mes
    @GetMapping("/findEmpresasConTransferenciasUltimoMes")
    public List<Empresa> findEmpresasConTransferenciasUltimoMes() {
        return empresaService.findEmpresasConTransferenciasUltimoMes();
    }

    //2. Otro que traiga las empresas que se adhirieron el último mes.
    @GetMapping("/adheridas-ultimo-mes")
    public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
        return empresaService.obtenerEmpresasAdheridasUltimoMes();
    }

    //3 Metodao para adherir una empresa
    @PostMapping("/adherir")
    public ResponseEntity<Empresa> adherirEmpresa(@Valid @RequestBody Empresa empresa) {
        Empresa empresaAdherida = empresaService.adherirEmpresa(empresa);
        return new ResponseEntity<>(empresaAdherida, HttpStatus.CREATED);
    }
}
