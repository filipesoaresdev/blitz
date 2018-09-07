package br.gov.pi.detran.blitz.mb.geral;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.geral.CategoriaBO;
import br.gov.pi.detran.blitz.modelo.geral.Categoria;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class CategoriaMB extends AbstractBaseBean<Categoria> implements Serializable {

    @EJB
    private CategoriaBO categoriaBO;

    @Override
    public CategoriaBO getBO() {
        return categoriaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
