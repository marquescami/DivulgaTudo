package com.project.GerenciamentoDeAnuncios.controller;

import com.project.GerenciamentoDeAnuncios.model.GerenciamentoDeAnuncios;
import com.project.GerenciamentoDeAnuncios.model.dto.GerenciamentoDeAnunciosDTO;
import com.project.GerenciamentoDeAnuncios.service.GerenciamentoDeAnunciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping (value = "/anuncios")

public class GerenciamentoDeAnunciosController {

    @Autowired
    private GerenciamentoDeAnunciosService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GerenciamentoDeAnunciosDTO> save(@Valid @RequestBody GerenciamentoDeAnunciosDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GerenciamentoDeAnunciosDTO> update(@Valid @RequestBody GerenciamentoDeAnunciosDTO dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GerenciamentoDeAnuncios>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GerenciamentoDeAnuncios> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/findByDataAndCliente/{dataDeInicio}/{dataDeTermino}/{cliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GerenciamentoDeAnuncios>> findByDataDeInicioAndDataDeterminoAndCliente(@RequestParam LocalDate dataDeInicio, @RequestParam LocalDate dataDeTermino, @RequestParam String cliente){
        return ResponseEntity.ok(service.findByDataDeInicioAndDataDeterminoAndCliente(dataDeInicio, dataDeTermino, cliente));
    }
}

