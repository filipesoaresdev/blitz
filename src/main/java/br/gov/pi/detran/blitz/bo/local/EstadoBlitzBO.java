package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.local.EstadoBlitzDAO;
import br.gov.pi.detran.blitz.modelo.geral.Estado;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.EstadoBlitz;

/**
 *
 * @author filipesoares
 */
@Stateless
public class EstadoBlitzBO extends AbstractBusinessObject<EstadoBlitz> {

    @EJB
    private EstadoBlitzDAO estadoBlitzDAO;
    
    public void sincronizarEstado(List<Estado> estados, double valorProgressAdd, double progress) {

        for (Estado estado : estados) {
            EstadoBlitz estadoBlitz = new EstadoBlitz();
            estadoBlitz.setId(estado.getId());
            estadoBlitz.setDescricao(estado.getDescricao());
            estadoBlitz.setSigla(estado.getSigla());
            getDAO().saveOrUpdate(estadoBlitz,false);
            progress += valorProgressAdd;
        }
        getDAO().getSession().flush();
    }
    
    @Override
    public EstadoBlitzDAO getDAO() {
        return estadoBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(EstadoBlitz estadoBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
