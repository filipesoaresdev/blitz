/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.enums;

/**
 *
 * @author filipe
 */
public enum Autuador {
    
    DETRAN("DETRAN"), CIPTRAN("CIPTRAN"), BPRE("BPRE"), SETRANS("SETRANS"), OUTROS("OUTROS");
    
    private String descricao;

    private Autuador(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
