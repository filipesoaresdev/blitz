package br.gov.pi.detran.blitz.dao;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.blitz.modelo.local.CorBlitz;
import javax.ejb.Local;

/**
 *
 * @author filipesoares
 */
@Local
public interface CorBlitzDAO extends BaseDAO<CorBlitz> {

    public Long maxCodigo();
    
}
