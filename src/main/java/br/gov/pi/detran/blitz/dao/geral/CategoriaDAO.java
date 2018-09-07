package br.gov.pi.detran.blitz.dao.geral;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.blitz.modelo.geral.Categoria;
import javax.ejb.Local;

/**
 *
 * @author filipesoares
 */
@Local
public interface CategoriaDAO extends BaseDAO<Categoria> {
    
}
