package br.gov.pi.detran.blitz.mb.geral;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.geral.EspecieBO;
import br.gov.pi.detran.blitz.modelo.geral.Especie;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class EspecieMB extends AbstractBaseBean<Especie> implements Serializable {

    @EJB
    private EspecieBO especieBO;

    @Override
    public EspecieBO getBO() {
        return especieBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
