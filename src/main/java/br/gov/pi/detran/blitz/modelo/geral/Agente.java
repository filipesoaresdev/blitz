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
@Table(name = "agente")
public class Agente implements Serializable {
    @Id
    private Long id;
    
    @Column(name = "matricula", columnDefinition = "char(11)")
    private String matricula;
    @Column(name = "nome", columnDefinition = "varchar(50)")
    private String nome;
    @Column(name = "cpf", columnDefinition = "char(11)")
    private String cpf;
    @Column(name = "orgao", columnDefinition = "int")
    private Integer orgao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getOrgao() {
        return orgao;
    }

    public void setOrgao(Integer orgao) {
        this.orgao = orgao;
    }
    
    
}