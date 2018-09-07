package br.gov.pi.detran.blitz.mb.padrao;

import br.gov.pi.detran.blitz.modelo.geral.Agente;
import br.gov.pi.detran.blitz.modelo.geral.Categoria;
import br.gov.pi.detran.blitz.modelo.geral.Cor;
import br.gov.pi.detran.blitz.modelo.geral.Especie;
import br.gov.pi.detran.blitz.modelo.geral.Estado;
import br.gov.pi.detran.blitz.modelo.geral.MarcaModelo;
import br.gov.pi.detran.blitz.modelo.geral.Municipio;
import br.gov.pi.detran.blitz.modelo.geral.TipoVeiculo;
import br.gov.pi.detran.blitz.modelo.geral.Veiculo;
import br.gov.pi.detran.blitz.modelo.local.AgenteBlitz;
import br.gov.pi.detran.blitz.modelo.local.CategoriaBlitz;
import br.gov.pi.detran.blitz.modelo.local.CorBlitz;
import br.gov.pi.detran.blitz.modelo.local.EspecieBlitz;
import br.gov.pi.detran.blitz.modelo.local.InfracaoBlitz;
import br.gov.pi.detran.blitz.modelo.local.MarcaModeloBlitz;
import br.gov.pi.detran.blitz.modelo.local.MunicipioBlitz;
import br.gov.pi.detran.blitz.modelo.local.TipoVeiculoBlitz;
import br.gov.pi.detran.blitz.modelo.local.VeiculoBlitz;
import br.gov.pi.detran.blitz.modelo.local.VeiculoExternoBlitz;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.Permissao;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.Usuario;
import br.gov.pi.detran.ouvidoria.modelo.configuracao.ErroSistema;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.SituacaoUsuario;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.AcessoSistema;
import br.gov.pi.detran.ouvidoria.modelo.email.ConfiguracaoEmail;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.Perfil;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.HistoricoSituacaoUsuario;
import br.gov.pi.detran.ouvidoria.modelo.email.ModeloEmail;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import br.gov.pi.detran.ouvidoria.modelo.email.TipoAssuntoEmail;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.TipoRecuperacaoSenha;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClassMB {

    public Class getAcessoSistema() {
        return AcessoSistema.class;
    }

    public Class getErroSistema() {
        return ErroSistema.class;
    }

    public Class getHistoricoSituacaoUsuario() {
        return HistoricoSituacaoUsuario.class;
    }

    public Class getPerfil() {
        return Perfil.class;
    }

    public Class getPermissao() {
        return Permissao.class;
    }

    public Class getSituacaoUsuario() {
        return SituacaoUsuario.class;
    }

    public Class getUsuario() {
        return Usuario.class;
    }

    public Class getTipoAssuntoEmail() {
        return TipoAssuntoEmail.class;
    }

    public Class getModeloEmail() {
        return ModeloEmail.class;
    }

    public Class getSolicitacaoRecuperacaoSenha() {
        return SolicitacaoRecuperacaoSenha.class;
    }

    public Class getTipoRecuperacaoSenha() {
        return TipoRecuperacaoSenha.class;
    }

    public Class getConfiguracaoEmail() {
        return ConfiguracaoEmail.class;
    }

    public Class getMunicipio() {
        return Municipio.class;
    }

    public Class getEspecie() {
        return Especie.class;
    }

    public Class getAgente() {
        return Agente.class;
    }

    public Class getMarcaModelo() {
        return MarcaModelo.class;
    }

    public Class getCategoria() {
        return Categoria.class;
    }

    public Class getCor() {
        return Cor.class;
    }

    public Class getVeiculo() {
        return Veiculo.class;
    }

    public Class getAgenteBlitz() {
        return AgenteBlitz.class;
    }

    public Class getMunicipioBlitz() {
        return MunicipioBlitz.class;
    }

    public Class getCategoriaBlitz() {
        return CategoriaBlitz.class;
    }

    public Class getMarcaModeloBlitz() {
        return MarcaModeloBlitz.class;
    }

    public Class getCorBlitz() {
        return CorBlitz.class;
    }

    public Class getVeiculoBlitz() {
        return VeiculoBlitz.class;
    }

    public Class getEspecieBlitz() {
        return EspecieBlitz.class;
    }

    public Class getEstado() {
        return Estado.class;
    }
     public Class getTipoVeiculo() {
        return TipoVeiculo.class;
    }
   public Class getTipoVeiculoBlitz() {
        return TipoVeiculoBlitz.class;
    }
   public Class getInfracaoBlitz() {
        return InfracaoBlitz.class;
    }
 public Class getVeiculoExternoBlitz() {
        return VeiculoExternoBlitz.class;
    }



}