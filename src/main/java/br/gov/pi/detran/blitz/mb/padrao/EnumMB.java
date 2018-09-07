package br.gov.pi.detran.blitz.mb.padrao;

import br.gov.pi.detran.blitz.enums.Autuador;
import br.gov.pi.detran.blitz.enums.Procedimento;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class EnumMB {

    public Autuador[] getAutuadores() {
        return Autuador.values();
    }
    
    public Procedimento[] getProcedimentos() {
        return Procedimento.values();
    }
}