package br.gov.pi.detran.blitz.dao.geral;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.blitz.modelo.geral.Veiculo;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author filipesoares
 */
@Local
public interface VeiculoDAO extends BaseDAO<Veiculo> {

    public List<Veiculo> consultaVeiculosData(Date data);

    public Long contaVeiculosData(Date data);
    
}
