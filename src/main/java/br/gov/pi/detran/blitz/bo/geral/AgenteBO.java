package br.gov.pi.detran.blitz.bo.geral;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.geral.AgenteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.geral.Agente;

/**
 *
 * @author filipesoares
 */
@Stateless
public class AgenteBO extends AbstractBusinessObject<Agente> {

    @EJB
    private AgenteDAO agenteDAO;
    
    @Override
    public AgenteDAO getDAO() {
        return agenteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Agente agente) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
