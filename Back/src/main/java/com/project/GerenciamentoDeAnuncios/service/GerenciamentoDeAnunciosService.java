package com.project.GerenciamentoDeAnuncios.service;

import com.project.GerenciamentoDeAnuncios.exceptions.NotFoundException;
import com.project.GerenciamentoDeAnuncios.mapper.GerenciamentoDeAnunciosMapper;
import com.project.GerenciamentoDeAnuncios.model.GerenciamentoDeAnuncios;
import com.project.GerenciamentoDeAnuncios.model.dto.GerenciamentoDeAnunciosDTO;
import com.project.GerenciamentoDeAnuncios.repository.GerenciamentoDeAnunciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class GerenciamentoDeAnunciosService {

    @Autowired
    private GerenciamentoDeAnunciosRepository repository;
    
    @Autowired
    private GerenciamentoDeAnunciosMapper mapper;

    @Transactional
    public GerenciamentoDeAnunciosDTO save(GerenciamentoDeAnunciosDTO dto) {
        GerenciamentoDeAnuncios gerenciamentoDeAnuncios = mapper.toEntity(dto);
        gerenciamentoDeAnuncios.calculaProjecao();
        repository.save(gerenciamentoDeAnuncios);
        return mapper.toDto(gerenciamentoDeAnuncios);
    }

    @Transactional
    public GerenciamentoDeAnunciosDTO update(GerenciamentoDeAnunciosDTO dto) {
        GerenciamentoDeAnuncios gerenciamentoDeAnuncios = mapper.toEntity(dto);
        repository.save(gerenciamentoDeAnuncios);
        return mapper.toDto(gerenciamentoDeAnuncios);
    }
    @Transactional
    public List<GerenciamentoDeAnuncios> findAll() {
        List<GerenciamentoDeAnuncios> list = repository.findAll();
        return list;
    }

    @Transactional
    public GerenciamentoDeAnuncios findById(Long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public List<GerenciamentoDeAnuncios> findByDataDeInicioAndDataDeterminoAndCliente(LocalDate dataDeInicio, LocalDate dataDeTermino, String cliente) {
        return repository.findByDataAndCliente(dataDeInicio, dataDeTermino, cliente).orElseThrow(NotFoundException::new);
    }
}
