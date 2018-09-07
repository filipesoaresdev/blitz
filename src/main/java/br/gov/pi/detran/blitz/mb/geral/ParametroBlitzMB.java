package br.gov.pi.detran.blitz.mb.geral;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.local.ParametroBlitzBO;
import br.gov.pi.detran.blitz.modelo.local.ParametroBlitz;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class ParametroBlitzMB extends AbstractBaseBean<ParametroBlitz> implements Serializable {

    @EJB
    private ParametroBlitzBO parametroBlitzBO;

    @Override
    public ParametroBlitzBO getBO() {
        return parametroBlitzBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
