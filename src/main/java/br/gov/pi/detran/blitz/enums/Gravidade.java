/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.enums;

/**
 *
 * @author jonny
 */
public enum Gravidade {
    
    LEVE("LEVE"), MEDIA("MEDIA"), GRAVE("GRAVE"), GRAVISSIMA("GRAVISSIMA");
    
    private String descricao;

    private Gravidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
