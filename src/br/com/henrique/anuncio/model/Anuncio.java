package br.com.henrique.anuncio.model;

import java.time.LocalDate;

/***
 * <h1>Anuncio para ser cadastrado</h1>
 * 
 * <p>Anuncio para ser cadastrado no banco</p> 
 */
public class Anuncio {
    private String nome;
    private String cliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double investimentoDia;

    /**
     * <h1>Retorna o nome da classe {@link Anuncio}</h1>
     * 
     * @return nome, referente ao nome.
     * 
     * @see {@link Anuncio}
     */
    public String getNome() {
        return nome;
    }
    
    /***
     * <h1>Salva o nome na classe {@link Anuncio}</h1>
     * 
     * @param nome String, referente ao nome informado. 
     * 
     * @see Anuncio
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * <h1>Retorna o clinete da classe {@link Anuncio}</h1>
     * 
     * @return cliente, referente ao cliente.
     * 
     * @see {@link Anuncio}
     */
    public String getCliente() {
        return cliente;
    }
    
    /***
     * <h1>Salva o clinete na classe {@link Anuncio}</h1>
     * 
     * @param cliente String, referente ao cliente informado. 
     * 
     * @see Anuncio
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    /**
     * <h1>Retorna a data de inicio da classe {@link Anuncio}</h1>
     * 
     * 
     * @see {@link Anuncio}
     */
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    
    /***
     * <h1>Salva a data de inico da classe {@link Anuncio}</h1>
     * 
     * @param dataInicio LocalDate, referente a data informada. 
     * 
     * @see Anuncio
     */
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    /**
     * <h1>Retorna a data de fim da classe {@link Anuncio}</h1>
     * 
     * @return dataFim, referente a data de fim.
     * 
     * @see {@link Anuncio}
     */
    public LocalDate getDataFim() {
        return dataFim;
    }

    /***
     * <h1>Salva a data de fim da classe {@link Anuncio}</h1>
     * 
     * @param dataFim LocalDate, referente a data informada. 
     * 
     * @see Anuncio
     */
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    
    /**
     * <h1>Retorna o investimento da classe {@link Anuncio}</h1>
     * 
     * @return investimentoDia, referente ao investimento do dia.
     * 
     * @see {@link Anuncio}
     */
    public Double getInvestimentoDia() {
        return investimentoDia;
    }

    /***
     * <h1>Salva o investimento da classe {@link Anuncio}</h1>
     * 
     * @param investimentoDia Double, referente ao valor informado. 
     * 
     * @see Anuncio
     */
    public void setInvestimentoDia(Double investimentoDia) {
        this.investimentoDia = investimentoDia;
    }   
}
