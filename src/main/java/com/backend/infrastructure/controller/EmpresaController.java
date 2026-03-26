package com.backend.infrastructure.controller;


import com.backend.domain.casouso.empresa.EmpresaService;
import com.backend.domain.model.Empresa;
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
@RequestMapping("api/empresa/")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // insert a empresa into database
    @Operation(summary = "Alta de empresa", description = "Alta de empresa")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "la operacion se ejecuto correctamente"),
            @ApiResponse(responseCode = "400", description = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")})
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody Empresa empresa) {
        empresa.setId(0L);
        Empresa savedEmpresa = empresaService.save(empresa);
        return new ResponseEntity<>(savedEmpresa, HttpStatus.CREATED);
    }

    //get a single empresa by its id
    @Operation(summary = "Buscar de empresa por Id", description = "Buscar de empresa por Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "la operacion se ejecuto correctamente"),
            @ApiResponse(responseCode = "400", description = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")})
    @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<Empresa> getEmpresa(@PathVariable("id") long id) {
        Optional<Empresa> empresa = empresaService.findById(id);
        return new ResponseEntity<>(empresa.orElse(null), HttpStatus.OK);
    }

    //get all the empresas in the table in our database
    @Operation(summary = "Buscar de los Empresas", description = "Buscar todos los Empresas")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "la operacion se ejecuto correctamente"),
            @ApiResponse(responseCode = "400", description = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")})
    @GetMapping(path = "Empresas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public List<Empresa> getEmpresas() {
        return empresaService.findAll();
    }

    //update an existing empresa in the database
    @Operation(summary = "Actualizar empresa por Id", description = "Actualizar empresa por Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "202", description = "la operacion se ejecuto correctamente"),
            @ApiResponse(responseCode = "400", description = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")})
    @PatchMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable("id") long id, @RequestBody Empresa empresa) {
        empresa.setId(id);
        empresaService.upLocalDateEmpresa(id, empresa);
        return new ResponseEntity<>(empresa, HttpStatus.ACCEPTED);
    }


    // delete an existing empresa in the database
    @Operation(summary = "Borrar empresa por Id", description = "Borrar empresa por Id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "la operacion se ejecuto correctamente"),
            @ApiResponse(responseCode = "400", description = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(responseCode = "500", description = "Error interno de servidor")})
    @DeleteMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )

    public ResponseEntity<Empresa> deleteEmpresa(@PathVariable("id") long id) {
        Empresa deletedEmpresa = empresaService.findById(id).orElse(null);
        empresaService.deleteById(id);
        return new ResponseEntity<>(deletedEmpresa, HttpStatus.OK);
    }


}
