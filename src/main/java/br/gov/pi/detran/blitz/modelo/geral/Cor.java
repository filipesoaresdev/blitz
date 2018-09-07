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
@Table(name = "cor")
public class Cor implements Serializable {

    
    @Column(name = "cod", columnDefinition = "int")
    @Id
    private Integer id;
    @Column(name = "descricao", columnDefinition = "varchar(50)")
    private String descricao;

    public Cor() {
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

}