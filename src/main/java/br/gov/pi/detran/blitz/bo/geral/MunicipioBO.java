package br.gov.pi.detran.blitz.bo.geral;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.geral.MunicipioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.geral.Municipio;

/**
 *
 * @author filipesoares
 */
@Stateless
public class MunicipioBO extends AbstractBusinessObject<Municipio> {

    @EJB
    private MunicipioDAO municipioDAO;
    
    @Override
    public MunicipioDAO getDAO() {
        return municipioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Municipio municipio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
