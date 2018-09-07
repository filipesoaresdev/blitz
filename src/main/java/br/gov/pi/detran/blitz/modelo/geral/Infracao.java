/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.modelo.geral;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jonny
 */
@Entity
@Table(name = "infracaoNova")
public class Infracao implements Serializable {
    
    @Column(name = "codInfracao", columnDefinition = "int")
    @Id
    private Integer codInfracao;
    
    @Column(name = "descricao", columnDefinition = "varchar(500)")
    private String descricao;
    @Column(name = "lei", columnDefinition = "varchar(50)")
    private String enquadramento;
    @Column(name = "gravidade", columnDefinition = "varchar(50)")
    private String gravidade;
    @Column(name = "infrator", columnDefinition = "varchar(50)")
    private String responsabilidade;
    @Column(name = "competencia", columnDefinition = "varchar(50)")
    private String competencia;
    @Column(name = "valor", columnDefinition = "varchar(50)")
    private String valor;

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

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getResponsabilidade() {
        return responsabilidade;
    }

    public void setResponsabilidade(String responsabilidade) {
        this.responsabilidade = responsabilidade;
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    
}