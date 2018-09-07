package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.AgenteBlitzDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.AgenteBlitz;

/**
 *
 * @author filipesoares
 */
@Stateless
public class AgenteBlitzBO extends AbstractBusinessObject<AgenteBlitz> {

    @EJB
    private AgenteBlitzDAO agenteBlitzDAO;
    
    @Override
    public AgenteBlitzDAO getDAO() {
        return agenteBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(AgenteBlitz agenteBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
