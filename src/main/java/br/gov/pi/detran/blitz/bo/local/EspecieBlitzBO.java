package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.EspecieBlitzDAO;
import br.gov.pi.detran.blitz.modelo.geral.Especie;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.EspecieBlitz;

/**
 *
 * @author filipesoares
 */
@Stateless
public class EspecieBlitzBO extends AbstractBusinessObject<EspecieBlitz> {

    @EJB
    private EspecieBlitzDAO especieBlitzDAO;

    public void sincronizarEspecie(List<Especie> especies, double valorProgressAdd, double progress) {

        for (Especie especie : especies) {
            EspecieBlitz especieBlitz = new EspecieBlitz();
            especieBlitz.setId(especie.getId());
            especieBlitz.setDescricao(especie.getDescricao());
            getDAO().saveOrUpdate(especieBlitz);
            progress += valorProgressAdd;
        }
        getDAO().getSession().flush();
    }

    @Override
    public EspecieBlitzDAO getDAO() {
        return especieBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(EspecieBlitz especieBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
}
