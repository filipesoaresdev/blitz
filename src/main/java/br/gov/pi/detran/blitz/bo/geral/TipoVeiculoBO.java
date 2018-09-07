package br.gov.pi.detran.blitz.bo.geral;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.geral.TipoVeiculoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.geral.TipoVeiculo;

/**
 *
 * @author filipesoares
 */
@Stateless
public class TipoVeiculoBO extends AbstractBusinessObject<TipoVeiculo> {

    @EJB
    private TipoVeiculoDAO tipoVeiculoDAO;
    
    @Override
    public TipoVeiculoDAO getDAO() {
        return tipoVeiculoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TipoVeiculo tipoVeiculo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
