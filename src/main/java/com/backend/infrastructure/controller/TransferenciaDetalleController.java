package com.backend.infrastructure.controller;


import com.backend.domain.casouso.transferenciadetalle.TransferenciaDetalleService;
import com.backend.domain.model.TransferenciaDetalle;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/TransferenciaDetalle/")
public class TransferenciaDetalleController {

    @Autowired
    private TransferenciaDetalleService transferenciaDetalleService;

    // insert a transferenciaDetalle into database
    @ApiOperation(value = "Alta de transferenciaDetalle", notes = "Alta de transferenciaDetalle")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<TransferenciaDetalle> saveTransferenciaDetalle(@RequestBody TransferenciaDetalle transferenciaDetalle) {
        transferenciaDetalle.setId(0L);
        TransferenciaDetalle savedTransferenciaDetalle = transferenciaDetalleService.save(transferenciaDetalle);
        return new ResponseEntity<>(savedTransferenciaDetalle, HttpStatus.CREATED);
    }

    //get a single TransferenciaDetalle by its id
    @ApiOperation(value = "Buscar de TransferenciaDetalle por Id ", notes = "Buscar de TransferenciaDetalle por Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<TransferenciaDetalle> getTransferenciaDetalle(@RequestParam(name = "id") long id) {
        Optional<TransferenciaDetalle> TransferenciaDetalle = transferenciaDetalleService.findById(id);
        return new ResponseEntity<TransferenciaDetalle>(TransferenciaDetalle.orElse(null), HttpStatus.OK);
    }

    //get all the TransferenciaDetalle in the table in our database
    @ApiOperation(value = "Buscar de toda la TransferenciaDetalle . ", notes = "Buscar toda la TransferenciaDetalle")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "TransferenciaDetalles", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public List<TransferenciaDetalle> getTransferenciaDetalles() {
        return transferenciaDetalleService.findAll();
    }

    //upLocalDate an existing transferenciaDetalle in the database
    @ApiOperation(value = "Actualizar transferenciaDetalle por Id . ", notes = "Actualizar transferenciaDetalle por Id . ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @PatchMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
    public ResponseEntity<TransferenciaDetalle> upLocalDateTransferenciaDetalle(@RequestParam(name = "id") long id, @RequestBody TransferenciaDetalle transferenciaDetalle) {
        transferenciaDetalle.setId(id);
        transferenciaDetalleService.upLocalDateTransferenciaDetalle(id, transferenciaDetalle);
        return new ResponseEntity<>(transferenciaDetalle, HttpStatus.ACCEPTED);
    }


    // delete an existing TransferenciaDetalle in the database
    @ApiOperation(value = "Borrar  TransferenciaDetalle por Id . ", notes = "Borrar TransferenciaDetalle por Id . ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @DeleteMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )

    public ResponseEntity<TransferenciaDetalle> deleteTransferenciaDetalle(@RequestParam(name = "id") long id) {
        TransferenciaDetalle deleteduser = transferenciaDetalleService.findById(id).orElse(null);
        transferenciaDetalleService.deleteById(id);
        return new ResponseEntity<>(deleteduser, HttpStatus.OK);
    }


}