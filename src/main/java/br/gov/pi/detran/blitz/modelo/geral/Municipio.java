/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.modelo.geral;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jonny
 */
@Entity
@Table(name = "Municipio")
public class Municipio implements Serializable {

    
    @Column(name = "idMunicipio", columnDefinition = "int")
    @Id
    private Integer id;
    @Column(name = "descricao", columnDefinition = "char(50)")
    private String descricao;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="Estado_idEstado", columnDefinition="int", referencedColumnName = "idEstado")
    private Estado estado;

    public Municipio() {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
}