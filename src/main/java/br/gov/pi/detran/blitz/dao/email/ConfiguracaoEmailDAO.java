package br.gov.pi.detran.blitz.dao.email;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.ouvidoria.modelo.email.ConfiguracaoEmail;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface ConfiguracaoEmailDAO extends BaseDAO<ConfiguracaoEmail> {
    
}
