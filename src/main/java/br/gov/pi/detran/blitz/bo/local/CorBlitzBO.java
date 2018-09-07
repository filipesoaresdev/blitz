package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.CorBlitzDAO;
import br.gov.pi.detran.blitz.modelo.geral.Cor;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.CorBlitz;
import java.util.ArrayList;

/**
 *
 * @author filipesoares
 */
@Stateless
public class CorBlitzBO extends AbstractBusinessObject<CorBlitz> {

    @EJB
    private CorBlitzDAO corBlitzDAO;


    public void sincronizarCor(List<Cor> cores, double valorProgressAdd, double progress) {

        for (Cor cor : cores) {
            CorBlitz corBlitz = new CorBlitz();
            corBlitz.setId(cor.getId());
            corBlitz.setDescricao(cor.getDescricao());
            getDAO().saveOrUpdate(corBlitz,false);
            progress += valorProgressAdd;
        }

    }

    @Override
    public CorBlitzDAO getDAO() {
        return corBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(CorBlitz corBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
}
