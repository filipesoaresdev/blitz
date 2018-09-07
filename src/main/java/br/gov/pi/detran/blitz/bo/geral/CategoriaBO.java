package br.gov.pi.detran.blitz.bo.geral;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.geral.CategoriaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.geral.Categoria;

/**
 *
 * @author filipesoares
 */
@Stateless
public class CategoriaBO extends AbstractBusinessObject<Categoria> {

    @EJB
    private CategoriaDAO categoriaDAO;
    
    @Override
    public CategoriaDAO getDAO() {
        return categoriaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Categoria categoria) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
