package br.gov.pi.detran.blitz.dao.controleacesso;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.HistoricoSituacaoUsuario;
import javax.ejb.Local;

/**
 *
 * @author ayslan
 */
@Local
public interface HistoricoSituacaoUsuarioDAO extends BaseDAO<HistoricoSituacaoUsuario> {
    
}
