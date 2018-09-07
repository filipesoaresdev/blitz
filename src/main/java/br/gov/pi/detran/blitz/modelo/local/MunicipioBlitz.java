/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.modelo.local;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jonny
 */
@Entity
@Table(name = "municipio")
public class MunicipioBlitz implements Serializable {

    
    @Id
    private Integer id;
    
    private String descricao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private EstadoBlitz estadoBlitz;

    public MunicipioBlitz() {
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

    public EstadoBlitz getEstadoBlitz() {
        return estadoBlitz;
    }

    public void setEstadoBlitz(EstadoBlitz estadoBlitz) {
        this.estadoBlitz = estadoBlitz;
    }

}