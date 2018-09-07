package br.gov.pi.detran.blitz.mb.geral;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.geral.MunicipioBO;
import br.gov.pi.detran.blitz.modelo.geral.Municipio;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class MunicipioMB extends AbstractBaseBean<Municipio> implements Serializable {

    @EJB
    private MunicipioBO municipioBO;

    @Override
    public MunicipioBO getBO() {
        return municipioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
