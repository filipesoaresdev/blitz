/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.modelo.local;

import br.gov.pi.detran.blitz.enums.Competencia;
import br.gov.pi.detran.blitz.enums.Gravidade;
import br.gov.pi.detran.blitz.enums.Responsabilidade;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 *
 * @author jonny
 */
@Entity
public class InfracaoBlitz implements Serializable {
    
    @Id
    private Integer codInfracao;
    private Integer numFinal;
    
    @Column(columnDefinition = "Text")
    private String descricao;
    private String enquadramento;
    private Integer pontos;
    private Double valor;
    private Double valorDesconto;
    
    @Enumerated(EnumType.STRING)
    private Gravidade gravidade;
    @Enumerated(EnumType.STRING)
    private Responsabilidade responsabilidade;
    @Enumerated(EnumType.STRING)
    private Competencia competencia;

    public Integer getCodInfracao() {
        return codInfracao;
    }

    public void setCodInfracao(Integer codInfracao) {
        this.codInfracao = codInfracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEnquadramento() {
        return enquadramento;
    }

    public void setEnquadramento(String enquadramento) {
        this.enquadramento = enquadramento;
    }


    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Gravidade getGravidade() {
        return gravidade;
    }

    public void setGravidade(Gravidade gravidade) {
        this.gravidade = gravidade;
    }

    public Responsabilidade getResponsabilidade() {
        return responsabilidade;
    }

    public void setResponsabilidade(Responsabilidade responsabilidade) {
        this.responsabilidade = responsabilidade;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public Integer getNumFinal() {
        return numFinal;
    }

    public void setNumFinal(Integer numFinal) {
        this.numFinal = numFinal;
    }
    
    
}