package br.gov.pi.detran.blitz.dao.controleacesso.impl;

import br.gov.pi.detran.blitz.application.BaseDAOBlitzImpl;
import br.gov.pi.detran.blitz.dao.controleacesso.PerfilDAO;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.Perfil;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author #Author
 */
@Stateless
public class PerfilDAOImpl extends BaseDAOBlitzImpl<Perfil> implements PerfilDAO {
    
     @Override
    public List<Perfil> getPerfis(Usuario usuario) {

        String queryString = "SELECT perfis FROM " + Usuario.class.getName() + " u WHERE u =?1 ";
        Query query = getEntityManager().createQuery(queryString);
        query.setParameter(1, usuario);

        return query.getResultList();

    }
}
