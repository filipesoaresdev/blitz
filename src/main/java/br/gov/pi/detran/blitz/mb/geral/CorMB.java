package br.gov.pi.detran.blitz.mb.geral;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.geral.CorBO;
import br.gov.pi.detran.blitz.modelo.geral.Cor;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class CorMB extends AbstractBaseBean<Cor> implements Serializable {

    @EJB
    private CorBO corBO;

    @Override
    public CorBO getBO() {
        return corBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
