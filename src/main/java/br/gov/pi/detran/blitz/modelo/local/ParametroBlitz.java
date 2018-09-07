/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.modelo.local;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jonny
 */
@Entity
public class ParametroBlitz implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date dataUltimaAtualizacaoVeiculos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataUltimaAtualizacaoVeiculos() {
        return dataUltimaAtualizacaoVeiculos;
    }

    public void setDataUltimaAtualizacaoVeiculos(Date dataUltimaAtualizacaoVeiculos) {
        this.dataUltimaAtualizacaoVeiculos = dataUltimaAtualizacaoVeiculos;
    }
    
    
}