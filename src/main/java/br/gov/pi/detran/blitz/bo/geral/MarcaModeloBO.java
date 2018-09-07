package br.gov.pi.detran.blitz.bo.geral;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.geral.MarcaModeloDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.geral.MarcaModelo;

/**
 *
 * @author filipesoares
 */
@Stateless
public class MarcaModeloBO extends AbstractBusinessObject<MarcaModelo> {

    @EJB
    private MarcaModeloDAO marcaModeloDAO;
    
    @Override
    public MarcaModeloDAO getDAO() {
        return marcaModeloDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MarcaModelo marcaModelo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
