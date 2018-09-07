/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.pi.detran.blitz.enums;

/**
 *
 * @author jonny
 */
public enum Competencia {
    
    ESTADUAL("ESTADUAL"), MUNICIPAL("MUNICIPAL"), MUNICIPALESTADUAL("MUNICIPAL/ESTADUAL");
    
    private String descricao;

    private Competencia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static Competencia getCompetencia(String valor){
        
        if(valor.equals(ESTADUAL.getDescricao())){
            return ESTADUAL;
        }
        if(valor.equals(MUNICIPAL.getDescricao())){
            return MUNICIPAL;
        }
        if(valor.equals(MUNICIPALESTADUAL.getDescricao())){
            return MUNICIPALESTADUAL;
        }
        return null;
    }
    
}
