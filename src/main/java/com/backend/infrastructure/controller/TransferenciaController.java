package com.backend.infrastructure.controller;


import com.backend.domain.casouso.transferencia.TransferenciaService;
import com.backend.domain.model.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/transferencia/")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    // insert a transferencia into database
    @PostMapping
    public ResponseEntity<Transferencia> saveTransferencia(@RequestBody Transferencia transferencia) {
        transferencia.setId(0L);
        Transferencia savedTransferencia = transferenciaService.save(transferencia);
        return new ResponseEntity<>(savedTransferencia, HttpStatus.CREATED);
    }


    //get a single transferencia by its id
    @GetMapping("/{id}")
    public ResponseEntity<Transferencia> getTransferencia(@PathVariable("id") long id) {
        Optional<Transferencia> transferencia = transferenciaService.findById(id);
        return new ResponseEntity<>(transferencia.orElse(null), HttpStatus.OK);
    }


    //get all the transferencia in the table in our database
    @GetMapping("/Transferencias")
    public List<Transferencia> getTransferencias() {
        return transferenciaService.findAll();
    }


    //update an existing transferencia in the database
    @PatchMapping("/{id}")
    public ResponseEntity<Transferencia> updateTransferencia(@PathVariable("id") long id, @RequestBody Transferencia transferencia) {
        Transferencia updatedTransferencia = transferenciaService.upLocalDateTransferenia(id, transferencia);
        return new ResponseEntity<>(updatedTransferencia, HttpStatus.ACCEPTED);
    }


    // delete an existing transferencia in the database
    @DeleteMapping("/{id}")
    public ResponseEntity<Transferencia> deleteTransferencia(@PathVariable("id") long id) {
        Transferencia deletedTransferencia = transferenciaService.findById(id).orElse(null);
        transferenciaService.deleteById(id);
        return new ResponseEntity<>(deletedTransferencia, HttpStatus.OK);
    }


}
