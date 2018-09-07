package br.gov.pi.detran.blitz.mb.geral;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.local.VeiculoExternoBlitzBO;
import br.gov.pi.detran.blitz.modelo.local.VeiculoExternoBlitz;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class VeiculoExternoBlitzMB extends AbstractBaseBean<VeiculoExternoBlitz> implements Serializable {

    @EJB
    private VeiculoExternoBlitzBO veiculoExternoBlitzBO;

    @Override
    public VeiculoExternoBlitzBO getBO() {
        return veiculoExternoBlitzBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
