package sooft.backend.infrastructure.delivery.rest;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sooft.backend.business.casouso.transferencia.TransferenciaService;
import sooft.backend.domain.model.Transferencia;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transferencia")
@RequiredArgsConstructor
public class TransferenciaController {


    @Autowired
    private TransferenciaService transferenciaService;

    // insert a Transferencia into database
    @ApiOperation(value = "Alta de Transferencia", notes = "Adhesion de Transferencia")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<Transferencia> saveTransferencia(@RequestBody Transferencia transferencia) {
        transferencia.setId(0L);
        Transferencia savedTransferencia = transferenciaService.save(transferencia);
        return new ResponseEntity<>(savedTransferencia, HttpStatus.CREATED);
    }

    //get a single Transferencia by its id
    @ApiOperation(value = "Buscar de Transferencia por Id ", notes = "Buscar de Transferencia por Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<Transferencia> getTransferencia(@RequestParam(name = "id") long id) {
        Optional<Transferencia> transferencia = transferenciaService.findById(id);
        return new ResponseEntity<Transferencia>(transferencia.orElse(null), HttpStatus.OK);
    }

    //get all the Transferencia in the table in our database
    @ApiOperation(value = "Buscar de toda la Transferencia . ", notes = "Buscar toda la Transferencia")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "Transferencias", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public List<Transferencia> getTransferencias() {
        return transferenciaService.findAll();
    }


    // delete an existing Transferencia in the database
    @ApiOperation(value = "Borrar  Transferencia por Id . ", notes = "Borrar Transferencia por Id . ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @DeleteMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )

    public ResponseEntity<Transferencia> deleteTransferencia(@RequestParam(name = "id") long id) {
        Transferencia deleteduser = transferenciaService.findById(id).orElse(null);
        transferenciaService.deleteById(id);
        return new ResponseEntity<>(deleteduser, HttpStatus.OK);
    }
}
