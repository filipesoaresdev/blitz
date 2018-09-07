package br.gov.pi.detran.blitz.mb.geral;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.geral.AgenteBO;
import br.gov.pi.detran.blitz.modelo.geral.Agente;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class AgenteMB extends AbstractBaseBean<Agente> implements Serializable {

    @EJB
    private AgenteBO agenteBO;

    @Override
    public AgenteBO getBO() {
        return agenteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
