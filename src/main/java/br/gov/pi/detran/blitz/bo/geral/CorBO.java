package br.gov.pi.detran.blitz.bo.geral;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.geral.CorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.geral.Cor;

/**
 *
 * @author filipesoares
 */
@Stateless
public class CorBO extends AbstractBusinessObject<Cor> {

    @EJB
    private CorDAO corDAO;
    
    @Override
    public CorDAO getDAO() {
        return corDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Cor cor) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
