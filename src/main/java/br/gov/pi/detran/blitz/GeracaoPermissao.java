package br.gov.pi.detran.blitz;

import br.gov.pi.detran.blitz.dao.controleacesso.PermissaoDAO;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.Permissao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Classe para geracao das permissoes iniciais do sistema
 *
 * @author Ayslan
 */
@Stateless
public class GeracaoPermissao {

    private static final Logger logger = Logger.getLogger(GeracaoPermissao.class.getName());
    @EJB
    private PermissaoDAO permissaoDAO;

    public void generate() {


        /**
         * Administracao Sistema
         */
        create(new Permissao("administracaoSistema", "Sistema", true), null);

        //Parametro
        create(new Permissao("parametro", "Parâmetro", true), "administracaoSistema");
        create(new Permissao("parametro.create", "Cadastro de Parâmetro", "/admin/view/parametro/createParametro.jsf", true), "parametro");
        create(new Permissao("parametro.list", "Consulta de Parâmetro", "/admin/view/parametro/listParametro.jsf", true), "parametro");
        create(new Permissao("parametro.audit", "Auditoria de Parâmetro"), "parametro");
        create(new Permissao("parametro.delete", "Exclusão de Parâmetro"), "parametro");


        /*
         * Controle de Acesso
         */
        create(new Permissao("controleAcesso", "Controle de Acesso", true), "administracaoSistema");

        //Permissao
        create(new Permissao("permissao", "Permissão", true), "controleAcesso");
        create(new Permissao("permissao.create", "Cadastro de Permissão", "/admin/view/controleAcesso/permissao/createPermissao.jsf", true), "permissao");
        create(new Permissao("permissao.list", "Consulta de Permissão", "/admin/view/controleAcesso/permissao/listPermissao.jsf", true), "permissao");
        create(new Permissao("permissao.audit", "Auditoria de Permissão"), "permissao");
        create(new Permissao("permissao.delete", "Exclusão de Permissão"), "permissao");

        //Usuario
        create(new Permissao("usuario", "Usuário", true), "controleAcesso");
        create(new Permissao("usuario.create", "Cadastro de Usuário", "/admin/view/controleAcesso/usuario/createUsuario.jsf", true), "usuario");
        create(new Permissao("usuario.list", "Consulta de Usuário", "/admin/view/controleAcesso/usuario/listUsuario.jsf", true), "usuario");
        create(new Permissao("usuario.audit", "Auditoria de Usuário"), "usuario");
        create(new Permissao("usuario.delete", "Exclusão de Usuário"), "usuario");

        //Perfil
        create(new Permissao("perfil", "Perfil", true), "controleAcesso");
        create(new Permissao("perfil.create", "Cadastro de Perfil", "/admin/view/controleAcesso/perfil/createPerfil.jsf", true), "perfil");
        create(new Permissao("perfil.list", "Consulta de Perfil", "/admin/view/controleAcesso/perfil/listPerfil.jsf", true), "perfil");
        create(new Permissao("perfil.audit", "Auditoria de Perfil"), "perfil");
        create(new Permissao("perfil.delete", "Exclusão de Perfil"), "perfil");

        //Acessos do Sistema
        create(new Permissao("acessoSistema.list", "Relatório de Acessos", "/admin/view/controleAcesso/acessoSistema/listAcessoSistema.jsf", true), "controleAcesso");

        //Solicitacao recuperacao senha
        create(new Permissao("solicitacaoRecuperacaoSenha", "Recuperação de Senha", true), "controleAcesso");
        create(new Permissao("solicitacaoRecuperacaoSenha.list", "Consulta Recuperação de Senha", "/admin/view/controleAcesso/solicitacaoRecuperacaoSenha/listSolicitacaoRecuperacaoSenha.jsf", true), "solicitacaoRecuperacaoSenha");
        create(new Permissao("solicitacaoRecuperacaoSenha.audit", "Auditoria de Recuperação de Senha"), "solicitacaoRecuperacaoSenha");


        /*
         * Email
         */
        create(new Permissao("email", "Email", true), "administracaoSistema");

        //Modelo email
        create(new Permissao("modeloEmail", "Modelo de Email", true), "email");
        create(new Permissao("modeloEmail.create", "Cadastro de Modelo de Email", "/admin/view/email/modeloEmail/createModeloEmail.jsf", true), "modeloEmail");
        create(new Permissao("modeloEmail.list", "Consulta de Modelo de Email", "/admin/view/email/modeloEmail/listModeloEmail.jsf", true), "modeloEmail");
        create(new Permissao("modeloEmail.audit", "Auditoria de Modelo de Email"), "modeloEmail");
        create(new Permissao("modeloEmail.delete", "Exclusão de Modelo de Email"), "modeloEmail");

        //Configuracao email
        create(new Permissao("configuracaoEmail", "Configuração de Email", true), "email");
        create(new Permissao("configuracaoEmail.create", "Cadastro de Configuração de Email", "/admin/view/email/configuracaoEmail/createConfiguracaoEmail.jsf", true), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.list", "Consulta de Configuração de Email", "/admin/view/email/configuracaoEmail/listConfiguracaoEmail.jsf", true), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.audit", "Auditoria de Configuração de Email"), "configuracaoEmail");
        create(new Permissao("configuracaoEmail.delete", "Exclusão de Configuração de Email"), "configuracaoEmail");

        /*
         * Configuracao
         */
        create(new Permissao("configuracaoSistema", "Configuração", true), "administracaoSistema");

        //Erro sistema
        create(new Permissao("erroSistema.list", "Relatório de Erros", "/admin/view/configuracao/erroSistema/listErroSistema.jsf", true), "configuracaoSistema");

        /**
         * Permissoes Globais
         */
        //Alterar Senha
        createGlobal(new Permissao("usuario.alterarSenha", "Alterar Senha", "/admin/view/controleAcesso/password/alterPassword.jsf", true), "controleAcesso");
        createGlobal(new Permissao("usuario.ultimosAcessos", "Últimos Acessos", "/admin/view/controleAcesso/acessoSistema/ultimosAcessoSistema.jsf", true), "controleAcesso");

        create(new Permissao("sincronizacao", "Sincronização", true), null);
        create(new Permissao("sincronizarDados", "Sincronizar Dados", "/view/sincronizacao/sincronizaDadosBanco.jsf", true), "sincronizacao");

        //Auto Blitz
        create(new Permissao("autoBlitz", "Auto Blitz", true), null);
        create(new Permissao("autoBlitz.create", "Cadastro de Auto Blitz", "/view/cadastrarAuto/createAutoBlitz.jsf", true), "autoBlitz");
        create(new Permissao("autoBlitz.list", "Consulta de Auto Blitz", "/view/cadastrarAuto/listAutoBlitz.jsf", true), "autoBlitz");
        create(new Permissao("autoBlitz.audit", "Auditoria de Auto Blitz"), "autoBlitz");
        create(new Permissao("autoBlitz.delete", "Exclusão de Auto Blitz"), "autoBlitz");
//
//
//        //Agente
//        create(new Permissao("agente", "Agente", true), null);
//        create(new Permissao("agente.create", "Cadastro de Agente", "/agente/createAgente.jsf", true), "agente");
//        create(new Permissao("agente.list", "Consulta de Agente", "/agente/listAgente.jsf", true), "agente");
//        create(new Permissao("agente.audit", "Auditoria de Agente"), "agente");
//        create(new Permissao("agente.delete", "Exclusão de Agente"), "agente");
//
////Categoria
//        create(new Permissao("categoria", "Categoria", true), null);
//        create(new Permissao("categoria.create", "Cadastro de Categoria", "/categoria/createCategoria.jsf", true), "categoria");
//        create(new Permissao("categoria.list", "Consulta de Categoria", "/categoria/listCategoria.jsf", true), "categoria");
//        create(new Permissao("categoria.audit", "Auditoria de Categoria"), "categoria");
//        create(new Permissao("categoria.delete", "Exclusão de Categoria"), "categoria");
//
////Cor
//        create(new Permissao("cor", "Cor", true), null);
//        create(new Permissao("cor.create", "Cadastro de Cor", "/cor/createCor.jsf", true), "cor");
//        create(new Permissao("cor.list", "Consulta de Cor", "/cor/listCor.jsf", true), "cor");
//        create(new Permissao("cor.audit", "Auditoria de Cor"), "cor");
//        create(new Permissao("cor.delete", "Exclusão de Cor"), "cor");
//
////Especie
//        create(new Permissao("especie", "Especie", true), null);
//        create(new Permissao("especie.create", "Cadastro de Especie", "/especie/createEspecie.jsf", true), "especie");
//        create(new Permissao("especie.list", "Consulta de Especie", "/especie/listEspecie.jsf", true), "especie");
//        create(new Permissao("especie.audit", "Auditoria de Especie"), "especie");
//        create(new Permissao("especie.delete", "Exclusão de Especie"), "especie");
//
////Marca Modelo
//        create(new Permissao("marcaModelo", "Marca Modelo", true), null);
//        create(new Permissao("marcaModelo.create", "Cadastro de Marca Modelo", "/marcaModelo/createMarcaModelo.jsf", true), "marcaModelo");
//        create(new Permissao("marcaModelo.list", "Consulta de Marca Modelo", "/marcaModelo/listMarcaModelo.jsf", true), "marcaModelo");
//        create(new Permissao("marcaModelo.audit", "Auditoria de Marca Modelo"), "marcaModelo");
//        create(new Permissao("marcaModelo.delete", "Exclusão de Marca Modelo"), "marcaModelo");
//
////Municipio
//        create(new Permissao("municipio", "Municipio", true), null);
//        create(new Permissao("municipio.create", "Cadastro de Municipio", "/municipio/createMunicipio.jsf", true), "municipio");
//        create(new Permissao("municipio.list", "Consulta de Municipio", "/municipio/listMunicipio.jsf", true), "municipio");
//        create(new Permissao("municipio.audit", "Auditoria de Municipio"), "municipio");
//        create(new Permissao("municipio.delete", "Exclusão de Municipio"), "municipio");
//
////Veiculo
//        create(new Permissao("veiculo", "Veiculo", true), null);
//        create(new Permissao("veiculo.create", "Cadastro de Veiculo", "/veiculo/createVeiculo.jsf", true), "veiculo");
//        create(new Permissao("veiculo.list", "Consulta de Veiculo", "/veiculo/listVeiculo.jsf", true), "veiculo");
//        create(new Permissao("veiculo.audit", "Auditoria de Veiculo"), "veiculo");
//        create(new Permissao("veiculo.delete", "Exclusão de Veiculo"), "veiculo");

//        //Agente Blitz
//create(new Permissao("agenteBlitz", "Agente Blitz", true), null);
//create(new Permissao("agenteBlitz.create", "Cadastro de Agente Blitz", "/agenteBlitz/createAgenteBlitz.jsf", true), "agenteBlitz");
//create(new Permissao("agenteBlitz.list", "Consulta de Agente Blitz", "/agenteBlitz/listAgenteBlitz.jsf", true), "agenteBlitz");
//create(new Permissao("agenteBlitz.audit", "Auditoria de Agente Blitz"), "agenteBlitz");
//create(new Permissao("agenteBlitz.delete", "Exclusão de Agente Blitz"), "agenteBlitz");
//
////Categoria Blitz
//create(new Permissao("categoriaBlitz", "Categoria Blitz", true), null);
//create(new Permissao("categoriaBlitz.create", "Cadastro de Categoria Blitz", "/categoriaBlitz/createCategoriaBlitz.jsf", true), "categoriaBlitz");
//create(new Permissao("categoriaBlitz.list", "Consulta de Categoria Blitz", "/categoriaBlitz/listCategoriaBlitz.jsf", true), "categoriaBlitz");
//create(new Permissao("categoriaBlitz.audit", "Auditoria de Categoria Blitz"), "categoriaBlitz");
//create(new Permissao("categoriaBlitz.delete", "Exclusão de Categoria Blitz"), "categoriaBlitz");
//
////Cor Blitz
//create(new Permissao("corBlitz", "Cor Blitz", true), null);
//create(new Permissao("corBlitz.create", "Cadastro de Cor Blitz", "/corBlitz/createCorBlitz.jsf", true), "corBlitz");
//create(new Permissao("corBlitz.list", "Consulta de Cor Blitz", "/corBlitz/listCorBlitz.jsf", true), "corBlitz");
//create(new Permissao("corBlitz.audit", "Auditoria de Cor Blitz"), "corBlitz");
//create(new Permissao("corBlitz.delete", "Exclusão de Cor Blitz"), "corBlitz");
//
////Especie Blitz
//create(new Permissao("especieBlitz", "Especie Blitz", true), null);
//create(new Permissao("especieBlitz.create", "Cadastro de Especie Blitz", "/especieBlitz/createEspecieBlitz.jsf", true), "especieBlitz");
//create(new Permissao("especieBlitz.list", "Consulta de Especie Blitz", "/especieBlitz/listEspecieBlitz.jsf", true), "especieBlitz");
//create(new Permissao("especieBlitz.audit", "Auditoria de Especie Blitz"), "especieBlitz");
//create(new Permissao("especieBlitz.delete", "Exclusão de Especie Blitz"), "especieBlitz");
//
////Marca Modelo Blitz
//create(new Permissao("marcaModeloBlitz", "Marca Modelo Blitz", true), null);
//create(new Permissao("marcaModeloBlitz.create", "Cadastro de Marca Modelo Blitz", "/marcaModeloBlitz/createMarcaModeloBlitz.jsf", true), "marcaModeloBlitz");
//create(new Permissao("marcaModeloBlitz.list", "Consulta de Marca Modelo Blitz", "/marcaModeloBlitz/listMarcaModeloBlitz.jsf", true), "marcaModeloBlitz");
//create(new Permissao("marcaModeloBlitz.audit", "Auditoria de Marca Modelo Blitz"), "marcaModeloBlitz");
//create(new Permissao("marcaModeloBlitz.delete", "Exclusão de Marca Modelo Blitz"), "marcaModeloBlitz");
//
////Municipio Blitz
//create(new Permissao("municipioBlitz", "Municipio Blitz", true), null);
//create(new Permissao("municipioBlitz.create", "Cadastro de Municipio Blitz", "/municipioBlitz/createMunicipioBlitz.jsf", true), "municipioBlitz");
//create(new Permissao("municipioBlitz.list", "Consulta de Municipio Blitz", "/municipioBlitz/listMunicipioBlitz.jsf", true), "municipioBlitz");
//create(new Permissao("municipioBlitz.audit", "Auditoria de Municipio Blitz"), "municipioBlitz");
//create(new Permissao("municipioBlitz.delete", "Exclusão de Municipio Blitz"), "municipioBlitz");
//
////Veiculo Blitz
//create(new Permissao("veiculoBlitz", "Veiculo Blitz", true), null);
//create(new Permissao("veiculoBlitz.create", "Cadastro de Veiculo Blitz", "/veiculoBlitz/createVeiculoBlitz.jsf", true), "veiculoBlitz");
//create(new Permissao("veiculoBlitz.list", "Consulta de Veiculo Blitz", "/veiculoBlitz/listVeiculoBlitz.jsf", true), "veiculoBlitz");
//create(new Permissao("veiculoBlitz.audit", "Auditoria de Veiculo Blitz"), "veiculoBlitz");
//create(new Permissao("veiculoBlitz.delete", "Exclusão de Veiculo Blitz"), "veiculoBlitz");
        
        //Veiculo Externo Blitz
//create(new Permissao("veiculoExternoBlitz", "Veiculo Externo Blitz", true), null);
//create(new Permissao("veiculoExternoBlitz.create", "Cadastro de Veiculo Externo Blitz", "/veiculoExternoBlitz/createVeiculoExternoBlitz.jsf", true), "veiculoExternoBlitz");
//create(new Permissao("veiculoExternoBlitz.list", "Consulta de Veiculo Externo Blitz", "/veiculoExternoBlitz/listVeiculoExternoBlitz.jsf", true), "veiculoExternoBlitz");
//create(new Permissao("veiculoExternoBlitz.audit", "Auditoria de Veiculo Externo Blitz"), "veiculoExternoBlitz");
//create(new Permissao("veiculoExternoBlitz.delete", "Exclusão de Veiculo Externo Blitz"), "veiculoExternoBlitz");

    }

    private void createGlobal(Permissao permissao, String pai) {
        permissao.setGlobal(true);
        create(permissao, pai);
    }

    private void create(Permissao permissao, String pai) {

        if (pai != null && pai.equals(permissao.getKey())) {
            logger.log(Level.WARNING, "Permissao ''{0}'' pai dela mesmo. Esta permissao nao sera salva.", permissao.getKey());
            return;
        }

        Permissao permissaoDB = permissaoDAO.unique("key", permissao.getKey());

        if (pai != null && !pai.isEmpty()) {
            Permissao permissaoPai = permissaoDAO.unique("key", pai);
            permissao.setPermissaoPai(permissaoPai);
        }

        if (permissaoDB != null) {
            permissaoDB.setUrl(permissao.getUrl());
            permissaoDB.setDescricao(permissao.getDescricao());
            permissaoDB.setPermissaoPai(permissao.getPermissaoPai());
            permissaoDB.setPossuiMenu(permissao.isPossuiMenu());
            permissaoDB.setGlobal(permissao.isGlobal());
            permissao = permissaoDB;
        }

        permissaoDAO.merge(permissao, false);
    }
}
