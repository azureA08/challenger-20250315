package com.backend.infrastructure.controller;


import com.backend.domain.casouso.transferenciadetalle.TransferenciaDetalleService;
import com.backend.domain.model.TransferenciaDetalle;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Alta de transferenciaDetalle", description = "Alta de transferenciaDetalle")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "la operacion se ejecuto correctamente"),
            @ApiResponse(responseCode = "400", description = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")})
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<TransferenciaDetalle> saveTransferenciaDetalle(@RequestBody TransferenciaDetalle transferenciaDetalle) {
        transferenciaDetalle.setId(0L);
        TransferenciaDetalle savedTransferenciaDetalle = transferenciaDetalleService.save(transferenciaDetalle);
        return new ResponseEntity<>(savedTransferenciaDetalle, HttpStatus.CREATED);
    }

    //get a single TransferenciaDetalle by its id
    @Operation(summary = "Buscar de TransferenciaDetalle por Id", description = "Buscar de TransferenciaDetalle por Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "la operacion se ejecuto correctamente"),
            @ApiResponse(responseCode = "400", description = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")})
    @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<TransferenciaDetalle> getTransferenciaDetalle(@PathVariable("id") long id) {
        Optional<TransferenciaDetalle> transferenciaDetalle = transferenciaDetalleService.findById(id);
        return new ResponseEntity<>(transferenciaDetalle.orElse(null), HttpStatus.OK);
    }

    //get all the TransferenciaDetalle in the table in our database
    @Operation(summary = "Buscar toda la TransferenciaDetalle", description = "Buscar toda la TransferenciaDetalle")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "la operacion se ejecuto correctamente"),
            @ApiResponse(responseCode = "400", description = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")})
    @GetMapping(path = "TransferenciaDetalles", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public List<TransferenciaDetalle> getTransferenciaDetalles() {
        return transferenciaDetalleService.findAll();
    }

    //update an existing transferenciaDetalle in the database
    @Operation(summary = "Actualizar transferenciaDetalle por Id", description = "Actualizar transferenciaDetalle por Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "202", description = "la operacion se ejecuto correctamente"),
            @ApiResponse(responseCode = "400", description = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")})
    @PatchMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
    public ResponseEntity<TransferenciaDetalle> updateTransferenciaDetalle(@PathVariable("id") long id, @RequestBody TransferenciaDetalle transferenciaDetalle) {
        transferenciaDetalle.setId(id);
        transferenciaDetalleService.upLocalDateTransferenciaDetalle(id, transferenciaDetalle);
        return new ResponseEntity<>(transferenciaDetalle, HttpStatus.ACCEPTED);
    }


    // delete an existing TransferenciaDetalle in the database
    @Operation(summary = "Borrar TransferenciaDetalle por Id", description = "Borrar TransferenciaDetalle por Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "la operacion se ejecuto correctamente"),
            @ApiResponse(responseCode = "400", description = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")})
    @DeleteMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )

    public ResponseEntity<TransferenciaDetalle> deleteTransferenciaDetalle(@PathVariable("id") long id) {
        TransferenciaDetalle deleteduser = transferenciaDetalleService.findById(id).orElse(null);
        transferenciaDetalleService.deleteById(id);
        return new ResponseEntity<>(deleteduser, HttpStatus.OK);
    }


}
