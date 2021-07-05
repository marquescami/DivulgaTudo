package com.project.GerenciamentoDeAnuncios.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "tb_anuncio")
public class GerenciamentoDeAnuncios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "nomeDoAnuncio")
    private String nomeDoAnuncio;

    @Column(name = "dataDeInicio")
    private LocalDate dataDeInicio;

    @Column(name = "dataDeTermino")
    private LocalDate dataDeTermino;

    @Column(name = "investimentoPorDia")
    private Double investimentoPorDia;

    @Column(name = "valorTotalInvestido")
    private Double valorTotalInvestido;

    @Column(name = "quantidadeMaximaDeVisualizacoes")
    private Integer quantidadeMaximaDeVisualizacoes;

    @Column(name = "quantidadeMaximaDeCliques")
    private Integer quantidadeMaximaDeCliques;

    @Column(name = "quantidadeMaximaDeCompartilhamentos")
    private Integer quantidadeMaximaDeCompartilhamentos;

    static final int VISUALIZACAO_POR_REAL_INVESTIDO = 30;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNomeDoAnuncio() {
        return nomeDoAnuncio;
    }

    public void setNomeDoAnuncio(String nomeDoAnuncio) {
        this.nomeDoAnuncio = nomeDoAnuncio;
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

    public Double getInvestimentoPorDia() {
        return investimentoPorDia;
    }

    public void setInvestimentoPorDia(Double investimentoPorDia) {
        this.investimentoPorDia = investimentoPorDia;
    }

    public Double getValorTotalInvestido() {
        return valorTotalInvestido;
    }

    public void setValorTotalInvestido(Double valorTotalInvestido) {
        this.valorTotalInvestido = valorTotalInvestido;
    }

    public Integer getQuantidadeMaximaDeVisualizacoes() {
        return quantidadeMaximaDeVisualizacoes;
    }

    public void setQuantidadeMaximaDeVisualizacoes(Integer quantidadeMaximaDeVisualizacoes) {
        this.quantidadeMaximaDeVisualizacoes = quantidadeMaximaDeVisualizacoes;
    }

    public Integer getQuantidadeMaximaDeCliques() {
        return quantidadeMaximaDeCliques;
    }

    public void setQuantidadeMaximaDeCliques(Integer quantidadeMaximaDeCliques) {
        this.quantidadeMaximaDeCliques = quantidadeMaximaDeCliques;
    }

    public Integer getQuantidadeMaximaDeCompartilhamentos() {
        return quantidadeMaximaDeCompartilhamentos;
    }

    public void setQuantidadeMaximaDeCompartilhamentos(Integer quantidadeMaximaDeCompartilhamentos) {
        this.quantidadeMaximaDeCompartilhamentos = quantidadeMaximaDeCompartilhamentos;
    }

    public void calculaProjecao() {

        //diferenca de dias
        long dias = dataDeInicio.until( dataDeTermino, ChronoUnit.DAYS );
        this.valorTotalInvestido = this.investimentoPorDia * dias;


        // Calcula visualização sem compartilhamento
        double visualizacaoSemCompartilhamento = valorTotalInvestido * VISUALIZACAO_POR_REAL_INVESTIDO;

        // Primeiro compartilhamento
        double cliques1Compartilhamento = calculaCliques(visualizacaoSemCompartilhamento);
        double compatilhamentos1Compartilhamento = calculaCompartilhamentos(cliques1Compartilhamento);
        double visualizacao1Compartilhamento = calculaVisualizacoes(compatilhamentos1Compartilhamento);

        // Segundo compartilhamento
        double cliques2Compartilhamento = calculaCliques(visualizacao1Compartilhamento);
        double compatilhamentos2Compartilhamento = calculaCompartilhamentos(cliques2Compartilhamento);
        double visualizacao2Compartilhamento = calculaVisualizacoes(compatilhamentos2Compartilhamento);

        // Terceiro compartilhamento
        double cliques3Compartilhamento = calculaCliques(visualizacao2Compartilhamento);
        double compatilhamentos3Compartilhamento = calculaCompartilhamentos(cliques3Compartilhamento);
        double visualizacao3Compartilhamento = calculaVisualizacoes(compatilhamentos3Compartilhamento);

        this.quantidadeMaximaDeCliques = calculaQuantidadeMaximaDeCliques(cliques1Compartilhamento,
                cliques2Compartilhamento, cliques3Compartilhamento);
        this.quantidadeMaximaDeCompartilhamentos = calculaQuantidadeMaximaDeCompartilhamentos(
                compatilhamentos1Compartilhamento, compatilhamentos2Compartilhamento,
                compatilhamentos3Compartilhamento);
        this.quantidadeMaximaDeVisualizacoes = calculaQuantidadeMaximaDeVisualizacoes(visualizacaoSemCompartilhamento,
                visualizacao1Compartilhamento, visualizacao2Compartilhamento, visualizacao3Compartilhamento);
    }

    public double calculaCliques(double visualizacoes) {

        // calcula cliques
        double cliques = (visualizacoes * 0.12);
        // calculavisualizacaoPosCompartilhamento(cliques);
        return cliques;
    }

    public double calculaCompartilhamentos(double cliques) {

        // calcula Compartilhamento
        double compartilhamento = (cliques * 0.15);
        return compartilhamento;
    }

    public double calculaVisualizacoes(double compartilhamento) {
        // calcula Visualizacoes;
        double visualizacaoPosCompartilhamento = (compartilhamento * 40);
        return visualizacaoPosCompartilhamento;
    }

    public int calculaQuantidadeMaximaDeCliques(double cliques1Compartilhamento, double cliques2Compartilhamento,
                                                double cliques3Compartilhamento) {
        this.quantidadeMaximaDeCliques = (int) (cliques1Compartilhamento + cliques2Compartilhamento
                + cliques3Compartilhamento);
        return quantidadeMaximaDeCliques;
    }

    public int calculaQuantidadeMaximaDeCompartilhamentos(double compatilhamentos1Compartilhamento,
                                                          double compatilhamentos2Compartilhamento, double compatilhamentos3Compartilhamento) {
        this.quantidadeMaximaDeCompartilhamentos = (int) (compatilhamentos1Compartilhamento
                + compatilhamentos2Compartilhamento + compatilhamentos3Compartilhamento);
        return quantidadeMaximaDeCompartilhamentos;
    }

    public int calculaQuantidadeMaximaDeVisualizacoes(double visualizacaoSemCompartilhamento,
                                                      double visualizacao1Compartilhamento, double visualizacao2Compartilhamento,
                                                      double visualizacao3Compartilhamento) {
        this.quantidadeMaximaDeVisualizacoes = (int) (visualizacaoSemCompartilhamento + visualizacao1Compartilhamento
                + visualizacao2Compartilhamento + visualizacao3Compartilhamento);
        return quantidadeMaximaDeVisualizacoes;
    }

}