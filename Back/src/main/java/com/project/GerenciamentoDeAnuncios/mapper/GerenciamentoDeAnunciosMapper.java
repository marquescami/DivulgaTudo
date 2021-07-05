package com.project.GerenciamentoDeAnuncios.mapper;

import com.project.GerenciamentoDeAnuncios.model.GerenciamentoDeAnuncios;
import com.project.GerenciamentoDeAnuncios.model.dto.GerenciamentoDeAnunciosDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GerenciamentoDeAnunciosMapper {
    public GerenciamentoDeAnuncios toEntity(GerenciamentoDeAnunciosDTO dto) {
        GerenciamentoDeAnuncios gerenciamentoDeAnuncios = new GerenciamentoDeAnuncios();
        gerenciamentoDeAnuncios.setId(dto.getId());
        gerenciamentoDeAnuncios.setNomeDoAnuncio(dto.getNomeDoAnuncio());
        gerenciamentoDeAnuncios.setCliente(dto.getCliente());
        gerenciamentoDeAnuncios.setDataDeInicio(dto.getDataDeInicio());
        gerenciamentoDeAnuncios.setDataDeTermino(dto.getDataDeTermino());
        gerenciamentoDeAnuncios.setInvestimentoPorDia(dto.getInvestimentoPorDia());
        return gerenciamentoDeAnuncios;
    }

    public GerenciamentoDeAnunciosDTO toDto(GerenciamentoDeAnuncios gerenciamentoDeAnuncios) {
        GerenciamentoDeAnunciosDTO dto = new GerenciamentoDeAnunciosDTO();
        dto.setId(gerenciamentoDeAnuncios.getId());
        dto.setNomeDoAnuncio(gerenciamentoDeAnuncios.getNomeDoAnuncio());
        dto.setCliente(gerenciamentoDeAnuncios.getCliente());
        dto.setDataDeInicio(gerenciamentoDeAnuncios.getDataDeInicio());
        dto.setDataDeTermino(gerenciamentoDeAnuncios.getDataDeTermino());
        dto.setInvestimentoPorDia(gerenciamentoDeAnuncios.getInvestimentoPorDia());
        return dto;
    }
    public List<GerenciamentoDeAnunciosDTO> toDto (List<GerenciamentoDeAnuncios> listGerenciamentoDeAnuncios){
        return listGerenciamentoDeAnuncios.stream().map(this::toDto).collect(Collectors.toList());
    }
}
