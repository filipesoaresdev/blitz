package br.gov.pi.detran.blitz.mb.geral;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.local.AutoBlitzBO;
import br.gov.pi.detran.blitz.modelo.local.AutoBlitz;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class ConsultaAutoMB extends AbstractBaseBean<AutoBlitz> implements Serializable {

    @EJB
    private AutoBlitzBO autoBlitzBO;
    

    public void gerarRelatorio() {

        autoBlitzBO.gerarAutoImpresso(getEntity());

    }

    @Override
    public AutoBlitzBO getBO() {
        return autoBlitzBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
