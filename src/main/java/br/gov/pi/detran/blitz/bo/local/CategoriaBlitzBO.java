package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.CategoriaBlitzDAO;
import br.gov.pi.detran.blitz.modelo.geral.Categoria;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.CategoriaBlitz;

/**
 *
 * @author filipesoares
 */
@Stateless
public class CategoriaBlitzBO extends AbstractBusinessObject<CategoriaBlitz> {

    @EJB
    private CategoriaBlitzDAO categoriaBlitzDAO;

    public void sincronizarCategoria(List<Categoria> categorias, double valorProgressAdd, double progress) {

        for (Categoria categoria : categorias) {
            CategoriaBlitz categoriaBlitz = new CategoriaBlitz();
            categoriaBlitz.setId(categoria.getId());
            categoriaBlitz.setDescricao(categoria.getDescricao());
            getDAO().saveOrUpdate(categoriaBlitz,false);
            progress += valorProgressAdd;
        }
        getDAO().getSession().flush();
    }

    @Override
    public CategoriaBlitzDAO getDAO() {
        return categoriaBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(CategoriaBlitz categoriaBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
}
