package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.local.TipoVeiculoBlitzDAO;
import br.gov.pi.detran.blitz.modelo.geral.TipoVeiculo;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.TipoVeiculoBlitz;

/**
 *
 * @author filipesoares
 */
@Stateless
public class TipoVeiculoBlitzBO extends AbstractBusinessObject<TipoVeiculoBlitz> {

    @EJB
    private TipoVeiculoBlitzDAO tipoVeiculoBlitzDAO;
    
    public void sincronizarTipoVeiculos(List<TipoVeiculo> tipoVeiculos, double valorProgressAdd, double progress) {

        for (TipoVeiculo tipoVeiculo : tipoVeiculos) {
            TipoVeiculoBlitz tipoVeiculoBlitz = new TipoVeiculoBlitz();
            tipoVeiculoBlitz.setId(tipoVeiculo.getId());
            tipoVeiculoBlitz.setDescricao(tipoVeiculo.getDescricao());
            tipoVeiculoBlitz.setAbreviatura(tipoVeiculo.getAbreviatura());
            getDAO().saveOrUpdate(tipoVeiculoBlitz,false);
            progress += valorProgressAdd;
        }
        getDAO().getSession().flush();
    }
    
    @Override
    public TipoVeiculoBlitzDAO getDAO() {
        return tipoVeiculoBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TipoVeiculoBlitz tipoVeiculoBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
