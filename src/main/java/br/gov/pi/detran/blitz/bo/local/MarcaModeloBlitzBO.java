package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.MarcaModeloBlitzDAO;
import br.gov.pi.detran.blitz.modelo.geral.MarcaModelo;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.MarcaModeloBlitz;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author filipesoares
 */
@Stateless
public class MarcaModeloBlitzBO extends AbstractBusinessObject<MarcaModeloBlitz> {

    @EJB
    private MarcaModeloBlitzDAO marcaModeloBlitzDAO;

    @Override
    public MarcaModeloBlitzDAO getDAO() {
        return marcaModeloBlitzDAO;
    }

    public void sincronizarMarcaModelo(List<MarcaModelo> marcaModelos, double valorProgressAdd, double progress) {
        Long count = getDAO().count();
        int contador = 0;
        for (MarcaModelo mm : marcaModelos) {
            MarcaModeloBlitz marcaMBlitz = new MarcaModeloBlitz();
            marcaMBlitz.setId(mm.getId());
            marcaMBlitz.setDescricao(mm.getDescricao());
            if (count == 0) {
                getDAO().save(marcaMBlitz,false);
            } else {
                getDAO().saveOrMerge(marcaMBlitz,false);
            }
            contador++;
            if (contador == 100) {
                getDAO().getSession().flush();
                getDAO().getSession().clear();
                System.out.println("-----COMITADO----");
                contador = 0;
            }
            progress += valorProgressAdd;
        }
        getDAO().getSession().flush();
        getDAO().getSession().clear();
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MarcaModeloBlitz marcaModeloBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
}
