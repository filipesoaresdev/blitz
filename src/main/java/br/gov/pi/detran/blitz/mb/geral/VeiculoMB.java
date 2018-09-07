package br.gov.pi.detran.blitz.mb.geral;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.geral.VeiculoBO;
import br.gov.pi.detran.blitz.modelo.geral.Veiculo;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class VeiculoMB extends AbstractBaseBean<Veiculo> implements Serializable {

    @EJB
    private VeiculoBO veiculoBO;

    @Override
    public VeiculoBO getBO() {
        return veiculoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "chassi";
    }
}
