package br.gov.pi.detran.blitz.dao;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.blitz.modelo.local.AgenteBlitz;
import javax.ejb.Local;

/**
 *
 * @author filipesoares
 */
@Local
public interface AgenteBlitzDAO extends BaseDAO<AgenteBlitz> {
    
}
