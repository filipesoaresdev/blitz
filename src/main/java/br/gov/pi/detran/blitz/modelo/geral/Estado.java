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
@Table(name = "Estado")
public class Estado implements Serializable {

    
    @Column(name = "idEstado", columnDefinition = "numeric(19,0)")
    @Id
    private Integer id;
    @Column(name = "descricao", columnDefinition = "varchar(255)")
    private String descricao;
    @Column(name = "sigla", columnDefinition = "varchar(255)")
    private String sigla;

    public Estado() {
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    

}