package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.local.ParametroBlitzDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.ParametroBlitz;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author filipesoares
 */
@Stateless
public class ParametroBlitzBO extends AbstractBusinessObject<ParametroBlitz> {

    @EJB
    private ParametroBlitzDAO parametroBlitzDAO;
    
    public void atualizaDataUltimaSincroniaVeiculo(ParametroBlitz parametro){
        
        Date data = Calendar.getInstance().getTime();
        parametro.setDataUltimaAtualizacaoVeiculos(data);
        getDAO().saveOrUpdate(parametro);
        
    }
    
    public ParametroBlitz consultaParametro(ParametroBlitz parametro){
        
        List<ParametroBlitz> parametroBlitzs = getDAO().listAll();

        if(parametroBlitzs == null || parametroBlitzs.isEmpty()){
            parametro = new ParametroBlitz();
            getDAO().save(parametro);
        }else{
            parametro = parametroBlitzs.get(0);
        }
        return parametro;
    }
    
    @Override
    public ParametroBlitzDAO getDAO() {
        return parametroBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ParametroBlitz parametroBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
