package br.gov.pi.detran.blitz.dao;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.blitz.modelo.local.EspecieBlitz;
import javax.ejb.Local;

/**
 *
 * @author filipesoares
 */
@Local
public interface EspecieBlitzDAO extends BaseDAO<EspecieBlitz> {
    
}
