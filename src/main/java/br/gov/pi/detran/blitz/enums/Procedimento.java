/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.enums;

/**
 *
 * @author filipe
 */
public enum Procedimento {
    
    RECOLHIMENTOCNH("Recolhimento da CNH"), RECOLHIMENTOCRLV("Recolhimento do CRLV"),
    REMOCAOVEICULO("Remoção do Veículo"), APREENSAOVEICULO("Apreensão do Veículo"), RETENCAOVEICULO("Retenção do Veículo"),
    OUTROS("Outros");
    
    private String descricao;

    private Procedimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
