package com.project.GerenciamentoDeAnuncios.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class GerenciamentoDeAnunciosDTO {
    @NotNull
    private String nomeDoAnuncio;

    @NotNull
    private String cliente;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataDeInicio;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataDeTermino;

    @NotNull
    @DecimalMin(value="0.00")
    @Digits(integer = 6, fraction = 2)
    private double investimentoPorDia;

    private Long id;
    private double valorTotalInvestido;
    private int quantidadeMaximaDeVisualizacoes;
    private int quantidadeMaximaDeCliques;
    private int quantidadeMaximaDeCompartilhamentos;
    static final int VISUALIZACAO_POR_REAL_INVESTIDO = 30;


    public String getNomeDoAnuncio() {
        return nomeDoAnuncio;
    }

    public void setNomeDoAnuncio(String nomeDoAnuncio) {
        this.nomeDoAnuncio = nomeDoAnuncio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(LocalDate dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(LocalDate dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
    }

    public double getInvestimentoPorDia() {
        return investimentoPorDia;
    }

    public void setInvestimentoPorDia(double investimentoPorDia) {
        this.investimentoPorDia = investimentoPorDia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
