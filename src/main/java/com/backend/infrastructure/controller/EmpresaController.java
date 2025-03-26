package com.backend.infrastructure.controller;


import com.backend.domain.casouso.empresa.EmpresaService;
import com.backend.domain.model.Empresa;
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
@RequestMapping("api/empresa/")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // insert a empresa into database
    @ApiOperation(value = "Alta de empresa", notes = "Alta de empresa")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody Empresa empresa) {
        empresa.setId(0L);
        Empresa savedEmpresa = empresaService.save(empresa);
        return new ResponseEntity<>(savedEmpresa, HttpStatus.CREATED);
    }

    //get a single empresa by its id
    @ApiOperation(value = "Buscar de empresa por Id ", notes = "Buscar de empresa por Id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public ResponseEntity<Empresa> getEmpresa(@RequestParam(name = "id") long id) {
        Optional<Empresa> Empresa = empresaService.findById(id);
        return new ResponseEntity<Empresa>(Empresa.orElse(null), HttpStatus.OK);
    }

    //get all the products in the table in our database
    @ApiOperation(value = "Buscar de los Empresas . ", notes = "Buscar todos los Empresas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @GetMapping(path = "Empresas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )
    public List<Empresa> getEmpresas() {
        return empresaService.findAll();
    }

    //upLocalDate an existing empresa in the database
    @ApiOperation(value = "Actualizar empresa por Id . ", notes = "Actualizar empresa por Id . ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @PatchMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
    public ResponseEntity<Empresa> upLocalDateEmpresa(@RequestParam(name = "id") long id, @RequestBody Empresa empresa) {
        empresa.setId(id);
        empresaService.upLocalDateEmpresa(id, empresa);
        return new ResponseEntity<>(empresa, HttpStatus.ACCEPTED);
    }


    // delete an existing empresa in the database
    @ApiOperation(value = "Borrar  empresa por Id . ", notes = "Borrar empresa por Id . ")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "la operación se ejecutó correctamente"),
            @ApiResponse(code = 400, message = "Algun parametro no cumple con el formato o es requerido y no esta presente"),
            @ApiResponse(code = 500, message = "Error interno de servidor")})
    @DeleteMapping(path = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE}
    )

    public ResponseEntity<Empresa> deleteEmpresa(@RequestParam(name = "id") long id) {
        Empresa deletedEmpresa = empresaService.findById(id).orElse(null);
        empresaService.deleteById(id);
        return new ResponseEntity<>(deletedEmpresa, HttpStatus.OK);
    }


}