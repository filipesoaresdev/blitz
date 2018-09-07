package br.gov.pi.detran.blitz.dao.geral;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.blitz.modelo.geral.Cor;
import javax.ejb.Local;

/**
 *
 * @author arnaldo
 */
@Local
public interface AcionamentoDAO extends BaseDAO<Cor> {
    
    public Long getNextProtocolo();
    
}
