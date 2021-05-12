package br.com.henrique.anuncio.model;

import java.time.LocalDate;

/***
 * <h1>Anuncio para ser cadastrado</h1>
 * 
 * <p>Anuncio para ser cadastrado no banco</p>
 * 
 * @param nome String
 * @param cliente String
 * @param dataInicio LocalDate
 * @param dataFim LocalDate
 * @param investimentoDia Double
 */
public class Anuncio {
    private String nome;
    private String cliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double investimentoDia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Double getInvestimentoDia() {
        return investimentoDia;
    }

    public void setInvestimentoDia(Double investimentoDia) {
        this.investimentoDia = investimentoDia;
    }   
}
