package br.gov.pi.detran.blitz.dao.local;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.blitz.modelo.local.InfracaoBlitz;
import javax.ejb.Local;

/**
 *
 * @author filipesoares
 */
@Local
public interface InfracaoBlitzDAO extends BaseDAO<InfracaoBlitz> {
    
}
