/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.enums;

/**
 *
 * @author jonny
 */
public enum Responsabilidade {
    
    CONDUTOR("CONDUTOR"), PESSOAFISICA("PESSOA FISICA"), PESSOAJURIDICA("PESSOA JURIDICA"), PROPRIETARIO("PROPRIETARIO");
    
    private String descricao;

    private Responsabilidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static Responsabilidade getResponsabilidade(String valor){
        
        if(valor.equals(CONDUTOR.getDescricao())){
            return CONDUTOR;
        }
        if(valor.equals(PESSOAFISICA.getDescricao())){
            return PESSOAFISICA;
        }
        if(valor.equals(PESSOAJURIDICA.getDescricao())){
            return PESSOAJURIDICA;
        }
        if(valor.equals(PROPRIETARIO.getDescricao())){
            return PROPRIETARIO;
        }
        return null;
    }
}
