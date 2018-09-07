package br.gov.pi.detran.blitz.dao.local;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.blitz.modelo.local.EstadoBlitz;
import javax.ejb.Local;

/**
 *
 * @author filipesoares
 */
@Local
public interface EstadoBlitzDAO extends BaseDAO<EstadoBlitz> {
    
}
