package br.gov.pi.detran.blitz.dao.geral;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.blitz.modelo.geral.Especie;
import javax.ejb.Local;

/**
 *
 * @author filipesoares
 */
@Local
public interface EspecieDAO extends BaseDAO<Especie> {
    
}
