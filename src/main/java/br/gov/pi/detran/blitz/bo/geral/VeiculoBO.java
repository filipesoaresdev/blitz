package br.gov.pi.detran.blitz.bo.geral;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.geral.VeiculoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.geral.Veiculo;
import java.util.Date;

/**
 *
 * @author filipesoares
 */
@Stateless
public class VeiculoBO extends AbstractBusinessObject<Veiculo> {

    @EJB
    private VeiculoDAO veiculoDAO;
    
    public List<Veiculo> consultaVeiculos(Date data){
       
        List<Veiculo> veiculos = getDAO().consultaVeiculosData(data);
        
        return veiculos;
        
    }
    
    public Long contaVeiculos(Date data){
       
        return getDAO().contaVeiculosData(data);
        
    }
    
    @Override
    public VeiculoDAO getDAO() {
        return veiculoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Veiculo veiculo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
