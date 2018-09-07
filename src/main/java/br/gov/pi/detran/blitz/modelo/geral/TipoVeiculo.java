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
@Table(name = "dttipos")
public class TipoVeiculo implements Serializable {

    
    @Column(name = "codigo", columnDefinition = "int")
    @Id
    private Integer id;
    @Column(name = "descricao", columnDefinition = "varchar(50)")
    private String descricao;
    @Column(name = "abreviatura", columnDefinition = "varchar(150)")
    private String abreviatura;

    public TipoVeiculo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

}