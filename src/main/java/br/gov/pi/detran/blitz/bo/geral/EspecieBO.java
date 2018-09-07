package br.gov.pi.detran.blitz.bo.geral;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.geral.EspecieDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.geral.Especie;

/**
 *
 * @author filipesoares
 */
@Stateless
public class EspecieBO extends AbstractBusinessObject<Especie> {

    @EJB
    private EspecieDAO especieDAO;
    
    @Override
    public EspecieDAO getDAO() {
        return especieDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Especie especie) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
