package br.gov.pi.detran.blitz;

import br.gov.pi.detran.blitz.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import br.gov.pi.detran.blitz.dao.controleacesso.PerfilDAO;
import br.gov.pi.detran.blitz.dao.controleacesso.PermissaoDAO;
import br.gov.pi.detran.blitz.dao.controleacesso.UsuarioDAO;
import br.gov.pi.detran.blitz.dao.email.ConfiguracaoEmailDAO;
import br.gov.pi.detran.blitz.dao.email.ModeloEmailDAO;
import br.gov.pi.detran.blitz.enums.Autuador;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.*;
import br.gov.pi.detran.ouvidoria.modelo.email.ConfiguracaoEmail;
import br.gov.pi.detran.ouvidoria.modelo.email.ModeloEmail;
import br.gov.pi.detran.ouvidoria.modelo.email.TipoAssuntoEmail;
import com.xpert.core.exception.StackException;
import com.xpert.core.exception.UniqueFieldException;
import com.xpert.i18n.I18N;
import com.xpert.persistence.query.Restriction;
import com.xpert.utils.Encryption;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Classe para geracao inicial dos dados do sistema, como perfil ADMINISTRADOR
 * usuario ADMIN, e outros
 *
 * @author Ayslan
 */
@Stateless
public class GeracaoDadosSistema {

    private static final Logger logger = Logger.getLogger(GeracaoDadosSistema.class.getName());
    @EJB
    private PerfilDAO perfilDAO;
    @EJB
    private PermissaoDAO permissaoDAO;
    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private ConfiguracaoEmailDAO configuracaoEmailDAO;
    @EJB
    private ModeloEmailDAO modeloEmailDAO;
    @EJB
    private HistoricoSituacaoUsuarioDAO historicoSituacaoUsuarioDAO;
    @EJB
    private GeracaoPermissao geracaoPermissao;
    @EJB
    private GeracaoModeloEmail geracaoModeloEmail;

    public List<Restriction> getRestrictions(Restriction... restrictions) {
        return Arrays.asList(restrictions);
    }

    public void generate() {

        try {
            //gerar modelos de email
            //geracaoModeloEmail.generate();
            //gerar permissões
            geracaoPermissao.generate();


            //adicionar todas as permissoes para o admin
            Perfil perfil = perfilDAO.unique("descricao", "ADMINISTRADOR");
            if (perfil == null) {
                perfil = new Perfil();
                perfil.setDescricao("ADMINISTRADOR");
                perfil.setAtivo(true);
            }
            perfil.setPermissoes(permissaoDAO.listAll());
            if (perfil.getId() == null) {
                List<Permissao> atalhos = new ArrayList<Permissao>();
                atalhos.add((Permissao) permissaoDAO.unique("key", "usuario.list"));
                atalhos.add((Permissao) permissaoDAO.unique("key", "usuario.create"));
                atalhos.add((Permissao) permissaoDAO.unique("key", "acessoSistema.list"));
                atalhos.add((Permissao) permissaoDAO.unique("key", "usuario.alterarSenha"));
                atalhos.add((Permissao) permissaoDAO.unique("key", "erroSistema.list"));
                atalhos.add((Permissao) permissaoDAO.unique("key", "perfil.list"));
                perfil.setPermissoesAtalho(atalhos);
            }
            perfil = perfilDAO.merge(perfil, false);


            Usuario usuario = usuarioDAO.unique("userLogin", "ADMIN");
            if (usuario == null) {


                //usuario
                usuario = new Usuario();
                usuario.setSituacaoUsuario(SituacaoUsuario.ATIVO);
                usuario.setMatricula("123");
                usuario.setRg("123");
                usuario.setCpf("12345678909");
                usuario.setEmail("admin@xpertsistemas.com.br");
                usuario.setNome("ADMINISTRADOR DO SISTEMA");
                usuario.setAutuador(Autuador.DETRAN);
                List<Perfil> perfis = new ArrayList<Perfil>();
                perfis.add(perfil);
                usuario.setPerfis(perfis);
                usuario.setUserLogin("ADMIN");
                try {
                    usuario.setUserPassword(Encryption.getSHA256("1"));
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
                usuario.setSuperUsuario(true);
                usuario = usuarioDAO.merge(usuario, false);

                //historico como ativo
                HistoricoSituacaoUsuario historicoSituacaoUsuario = new HistoricoSituacaoUsuario();
                historicoSituacaoUsuario.setDataSituacao(new Date());
                historicoSituacaoUsuario.setSituacaoUsuario(SituacaoUsuario.ATIVO);
                historicoSituacaoUsuario.setUsuario(usuario);
                historicoSituacaoUsuario = historicoSituacaoUsuarioDAO.merge(historicoSituacaoUsuario, false);

            }


            ConfiguracaoEmail configuracaoEmail = configuracaoEmailDAO.unique("email", "detran.ping@gmail.com");
            if (configuracaoEmail == null) {

                configuracaoEmail = new ConfiguracaoEmail();
                configuracaoEmail.setNome("DETRAN-PI");
                configuracaoEmail.setEmail("detran.ping@gmail.com");
                configuracaoEmail.setSenha("agx@tc3Y%H");
                configuracaoEmail.setHostName("smtp.gmail.com");
                configuracaoEmail.setSsl(true);
                configuracaoEmail.setTls(true);
                configuracaoEmail.setSmtpPort(465);

                configuracaoEmail = configuracaoEmailDAO.merge(configuracaoEmail, false);
            }

            ModeloEmail modeloEmailNovoFuncionario = modeloEmailDAO.unique("tipoAssuntoEmail", TipoAssuntoEmail.NOVO_USUARIO_SISTEMA);
            if (modeloEmailNovoFuncionario == null) {
                modeloEmailNovoFuncionario = new ModeloEmail();
                modeloEmailNovoFuncionario.setAssunto("Cadastro de Funcionario - Trans-Inf | DETRAN-PI");
                modeloEmailNovoFuncionario.setConfiguracaoEmail(configuracaoEmail);
                modeloEmailNovoFuncionario.setTipoAssuntoEmail(TipoAssuntoEmail.NOVO_USUARIO_SISTEMA);

                StringBuilder layoutEmail = new StringBuilder();
                layoutEmail.append("Olá <b>${solicitacaoRecuperacaoSenha.funcionario.nome}</b>,");
                layoutEmail.append("<br/>");
                layoutEmail.append("<br/>");
                layoutEmail.append("Seu funcionario foi criado com sucesso.");
                layoutEmail.append("<br/>");
                layoutEmail.append("Seu login: <b>${solicitacaoRecuperacaoSenha.funcionario.userLogin}</b>");
                layoutEmail.append("<br/>");
                layoutEmail.append("<br/>");
                layoutEmail.append("Clique no link abaixo para cadastrar uma senha no sistema:");
                layoutEmail.append("<br/>");
                layoutEmail.append("<br/>");
                layoutEmail.append("<a href=\"${solicitacaoRecuperacaoSenha.urlRecuperacaoSenha}\">${solicitacaoRecuperacaoSenha.urlRecuperacaoSenha}</a>");

                modeloEmailNovoFuncionario.setLayout(layoutEmail.toString());

                modeloEmailNovoFuncionario = modeloEmailDAO.merge(modeloEmailNovoFuncionario, false);
            }

            ModeloEmail modeloEmailEsqueciSenha = modeloEmailDAO.unique("tipoAssuntoEmail", TipoAssuntoEmail.RECUPERACAO_SENHA);
            if (modeloEmailEsqueciSenha == null) {
                modeloEmailEsqueciSenha = new ModeloEmail();
                modeloEmailEsqueciSenha.setAssunto("Recuperacao de Senha - Trans-Inf | DETRAN-PI");
                modeloEmailEsqueciSenha.setConfiguracaoEmail(configuracaoEmail);
                modeloEmailEsqueciSenha.setTipoAssuntoEmail(TipoAssuntoEmail.RECUPERACAO_SENHA);

                StringBuilder layoutEmail = new StringBuilder();
                layoutEmail.append("Olá <b>${solicitacaoRecuperacaoSenha.funcionario.nome}</b>,");
                layoutEmail.append("<br/>");
                layoutEmail.append("Clique no link abaixo para recuperar sua senha no sistema:");
                layoutEmail.append("<br/>");
                layoutEmail.append("<br/>");
                layoutEmail.append("<a href=\"${solicitacaoRecuperacaoSenha.urlRecuperacaoSenha}\">${solicitacaoRecuperacaoSenha.urlRecuperacaoSenha}</a>");
                layoutEmail.append("<br/>");
                layoutEmail.append("<br/>");
                layoutEmail.append("Lembrando que esta solicitacao tem validade ate ${solicitacaoRecuperacaoSenha.dataValidadeFormatada}.");
                layoutEmail.append("<br/>");
                layoutEmail.append("Caso nao tenha solicitado a recuperacao da senha, desconsidere esse email.");

                modeloEmailEsqueciSenha.setLayout(layoutEmail.toString());

                modeloEmailEsqueciSenha = modeloEmailDAO.merge(modeloEmailEsqueciSenha, false);
            }

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static void log(StackException stackException) {
        boolean i18n = true;

        if (stackException instanceof UniqueFieldException) {
            if (((UniqueFieldException) stackException).isI18n() == false) {
                i18n = false;
            }
        }

        if (stackException.getExceptions() == null || stackException.getExceptions().isEmpty()) {
            logger.log(Level.INFO, I18N.get(stackException.getMessage(), stackException.getParametros()));
        } else {
            for (StackException re : stackException.getExceptions()) {
                logger.log(Level.INFO, I18N.get(re.getMessage(), re.getParametros()));
            }
        }
    }
}
