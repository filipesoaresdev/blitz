package br.gov.pi.detran.blitz.dao.controleacesso.impl;

import br.gov.pi.detran.blitz.application.BaseDAOBlitzImpl;
import br.gov.pi.detran.blitz.dao.controleacesso.UsuarioDAO;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.Usuario;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author #Author
 */
@Stateless
public class UsuarioDAOImpl extends BaseDAOBlitzImpl<Usuario> implements UsuarioDAO {

    @Override
    public List<Usuario> getUsuariosAtivos() {
        return list("situacaoUsuario", SituacaoUsuario.ATIVO, "nome");
    }
}
