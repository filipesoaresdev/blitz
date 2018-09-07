package br.gov.pi.detran.blitz.mb.geral;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.geral.MarcaModeloBO;
import br.gov.pi.detran.blitz.modelo.geral.MarcaModelo;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class MarcaModeloMB extends AbstractBaseBean<MarcaModelo> implements Serializable {

    @EJB
    private MarcaModeloBO marcaModeloBO;

    @Override
    public MarcaModeloBO getBO() {
        return marcaModeloBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
