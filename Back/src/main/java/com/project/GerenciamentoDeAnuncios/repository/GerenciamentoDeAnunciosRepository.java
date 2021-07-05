package com.project.GerenciamentoDeAnuncios.repository;

import com.project.GerenciamentoDeAnuncios.model.GerenciamentoDeAnuncios;
import com.project.GerenciamentoDeAnuncios.model.dto.GerenciamentoDeAnunciosDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface GerenciamentoDeAnunciosRepository extends JpaRepository<GerenciamentoDeAnuncios, Long> {

    @Query("select gerenciamentoDeAnuncios from GerenciamentoDeAnuncios gerenciamentoDeAnuncios where gerenciamentoDeAnuncios.dataDeInicio>=?1 and gerenciamentoDeAnuncios.dataDeTermino<=?2 and gerenciamentoDeAnuncios.cliente=?3 order by gerenciamentoDeAnuncios.dataDeInicio")
    Optional<List<GerenciamentoDeAnuncios>> findByDataAndCliente(LocalDate dataDeInicio, LocalDate dataDeTermino, String cliente);
}
