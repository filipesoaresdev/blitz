package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.local.VeiculoExternoBlitzDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.VeiculoExternoBlitz;

/**
 *
 * @author filipesoares
 */
@Stateless
public class VeiculoExternoBlitzBO extends AbstractBusinessObject<VeiculoExternoBlitz> {

    @EJB
    private VeiculoExternoBlitzDAO veiculoExternoBlitzDAO;
    
    @Override
    public VeiculoExternoBlitzDAO getDAO() {
        return veiculoExternoBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(VeiculoExternoBlitz veiculoExternoBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
