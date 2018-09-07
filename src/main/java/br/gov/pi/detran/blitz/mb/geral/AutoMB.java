package br.gov.pi.detran.blitz.mb.geral;

import br.gov.pi.detran.blitz.bo.controleacesso.UsuarioBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.detran.blitz.bo.local.AutoBlitzBO;
import br.gov.pi.detran.blitz.bo.local.CorBlitzBO;
import br.gov.pi.detran.blitz.bo.local.EspecieBlitzBO;
import br.gov.pi.detran.blitz.bo.local.EstadoBlitzBO;
import br.gov.pi.detran.blitz.bo.local.InfracaoBlitzBO;
import br.gov.pi.detran.blitz.bo.local.MarcaModeloBlitzBO;
import br.gov.pi.detran.blitz.bo.local.MunicipioBlitzBO;
import br.gov.pi.detran.blitz.bo.local.TipoVeiculoBlitzBO;
import br.gov.pi.detran.blitz.bo.local.VeiculoBlitzBO;
import br.gov.pi.detran.blitz.bo.local.VeiculoExternoBlitzBO;
import br.gov.pi.detran.blitz.constante.Constantes;
import br.gov.pi.detran.blitz.enums.Autuador;
import br.gov.pi.detran.blitz.mb.controleacesso.SessaoUsuarioMB;
import br.gov.pi.detran.blitz.modelo.local.AutoBlitz;
import br.gov.pi.detran.blitz.modelo.local.CorBlitz;
import br.gov.pi.detran.blitz.modelo.local.EspecieBlitz;
import br.gov.pi.detran.blitz.modelo.local.EstadoBlitz;
import br.gov.pi.detran.blitz.modelo.local.InfracaoBlitz;
import br.gov.pi.detran.blitz.modelo.local.MarcaModeloBlitz;
import br.gov.pi.detran.blitz.modelo.local.MunicipioBlitz;
import br.gov.pi.detran.blitz.modelo.local.TipoVeiculoBlitz;
import br.gov.pi.detran.blitz.modelo.local.VeiculoBlitz;
import br.gov.pi.detran.blitz.modelo.local.VeiculoExternoBlitz;
import br.gov.pi.detran.ouvidoria.modelo.controleacesso.Usuario;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class AutoMB extends AbstractBaseBean<AutoBlitz> implements Serializable {

    @EJB
    private AutoBlitzBO autoBlitzBO;
    @EJB
    private VeiculoExternoBlitzBO veiculoExternoBlitzBO;
    @EJB
    private VeiculoBlitzBO veiculoBlitzBO;
    @EJB
    private EspecieBlitzBO especieBlitzBO;
    @EJB
    private TipoVeiculoBlitzBO tipoVeiculoBlitzBO;
    @EJB
    private CorBlitzBO corBlitzBO;
    @EJB
    private EstadoBlitzBO estadoBlitzBO;
    @EJB
    private MunicipioBlitzBO municipioBlitzBO;
    @EJB
    private InfracaoBlitzBO infracaoBlitzBO;
    @EJB
    private UsuarioBO usuarioBO;
    private String placaConsulta;
    private String codInfracao;
    private String matricula;
    private List<EspecieBlitz> especieBlitzs;
    private List<TipoVeiculoBlitz> tipoVeiculoBlitzs;
    private List<CorBlitz> corBlitzs;
    private List<MunicipioBlitz> municipios;
    private List<EstadoBlitz> estados;
    private Integer cpfCnpj;
    @ManagedProperty(value = "#{sessaoUsuarioMB}")
    private SessaoUsuarioMB sessaoUsuarioMB;
    private Integer numeroVeiculoMudar;

    @Override
    public void init() {
        super.init();
        especieBlitzs = especieBlitzBO.getDAO().listAll("descricao");
        tipoVeiculoBlitzs = tipoVeiculoBlitzBO.getDAO().listAll("descricao");
        corBlitzs = corBlitzBO.getDAO().listAll("descricao");
        municipios = municipioBlitzBO.getDAO().listAll("descricao");
        estados = estadoBlitzBO.getDAO().listAll("descricao");
    }

    @Override
    public void postConstruct() {
        super.postConstruct(); //To change body of generated methods, choose Tools | Templates.
        if (getEntity().getId() == null) {
            inicializarVeiculoBlitz();
            numeroVeiculoMudar = getNumeroVeiculo();
        } else {
            getEntity().setAgente(getDAO().getInitialized(getEntity().getAgente()));
            getEntity().setInfracaoBlitz(getDAO().getInitialized(getEntity().getInfracaoBlitz()));
            if (getEntity().getVeiculoBlitz() != null) {
                getEntity().setVeiculoBlitz(getDAO().getInitialized(getEntity().getVeiculoBlitz()));
                getEntity().getVeiculoBlitz().setMarcaModelo((getDAO().getInitialized(getEntity().getVeiculoBlitz().getMarcaModelo())));
            }
            if (getEntity().getVeiculoExternoBlitz() != null) {
                getEntity().setVeiculoExternoBlitz(getDAO().getInitialized(getEntity().getVeiculoExternoBlitz()));
                getEntity().getVeiculoExternoBlitz().setMarcaModelo((getDAO().getInitialized(getEntity().getVeiculoBlitz().getMarcaModelo())));
            }
            matricula = getEntity().getAgente().getMatricula();
            codInfracao = String.valueOf(getEntity().getInfracaoBlitz().getCodInfracao());
            if (getEntity().getVeiculoBlitz() != null) {

                placaConsulta = getEntity().getVeiculoBlitz().getPlaca();
                numeroVeiculoMudar = getNumeroVeiculo();
            } else if (getEntity().getVeiculoExternoBlitz() != null) {

                placaConsulta = getEntity().getVeiculoExternoBlitz().getPlaca();
                numeroVeiculoMudar = getNumeroVeiculoExterno();
            }
        }
    }

    public void inicializarVeiculoBlitz() {
        if (getEntity() != null) {
            getEntity().setVeiculoBlitz(new VeiculoBlitz());
            getEntity().getVeiculoBlitz().setMunicipioBlitz(new MunicipioBlitz());
            getEntity().getVeiculoBlitz().getMunicipioBlitz().setEstadoBlitz(new EstadoBlitz());
            getEntity().getVeiculoBlitz().setMarcaModelo(new MarcaModeloBlitz());
            getEntity().setInfracaoBlitz(new InfracaoBlitz());
            getEntity().setAgente(new Usuario());
            getEntity().setCodOrgaoAutuador(Constantes.COD_ORGAO_AUTUADOR);
        }
    }

    public void inicializarVeiculoExternoBlitz() {
        if (getEntity() != null) {
            getEntity().setVeiculoExternoBlitz(new VeiculoExternoBlitz());
            getEntity().getVeiculoExternoBlitz().setMunicipioBlitz(new MunicipioBlitz());
            getEntity().getVeiculoExternoBlitz().getMunicipioBlitz().setEstadoBlitz(new EstadoBlitz());
            getEntity().getVeiculoExternoBlitz().setMarcaModelo(new MarcaModeloBlitz());
            getEntity().setInfracaoBlitz(new InfracaoBlitz());
            getEntity().setAgente(new Usuario());
            getEntity().setCodOrgaoAutuador(Constantes.COD_ORGAO_AUTUADOR);
        }
    }

    public List<MarcaModeloBlitz> completeMarcaModelo(String query) {
        if (query != null && !query.isEmpty()) {
            List<MarcaModeloBlitz> results = new ArrayList<MarcaModeloBlitz>();
            for (MarcaModeloBlitz mmb : getSessaoUsuarioMB().getMarcaModeloBlitzs()) {
                if (mmb.getDescricao().contains(query.toUpperCase())) {
                    results.add(mmb);
                }
            }

            return results;
        } else {
            return null;
        }
    }

    public void consultaVeiculo() {
        try {
            getEntity().setVeiculoBlitz(veiculoBlitzBO.consultaVeiculoPorPlaca(placaConsulta));
            getEntity().setDataInfracao(Calendar.getInstance().getTime());
        } catch (BusinessException ex) {
            getEntity().getVeiculoBlitz().setPlaca(placaConsulta);
            FacesMessageUtils.error(ex);
        }
    }

    public void consultaInfracao() {
        try {
            getEntity().setInfracaoBlitz(infracaoBlitzBO.consultaInfracao(codInfracao));

        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    public void consultaAgente() {
        try {
            getEntity().setAgente(usuarioBO.consultaUsuario(matricula));

        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    public void gerarRelatorio() {
        autoBlitzBO.gerarAutoImpresso(getEntity());
    }

    public void salvarVeiculoExterno() {
        try {
            if (getEntity() != null && getEntity().getVeiculoExternoBlitz() != null) {

                veiculoExternoBlitzBO.save(getEntity().getVeiculoExternoBlitz());

            }
        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    @Override
    public void preSave() {
        super.preSave();
        if (getEntity().getVeiculoExternoBlitz() != null) {
            salvarVeiculoExterno();

        }
    }

    public void mudarVeiculo() {

        if (getEntity() != null) {
            if (numeroVeiculoMudar == getNumeroVeiculoExterno()) {
                getEntity().setVeiculoBlitz(null);
                inicializarVeiculoExternoBlitz();
                numeroVeiculoMudar = getNumeroVeiculoExterno();
            } else {
                if (numeroVeiculoMudar == getNumeroVeiculo()) {
                    inicializarVeiculoBlitz();
                    getEntity().setVeiculoExternoBlitz(null);
                    numeroVeiculoMudar = getNumeroVeiculo();
                }
            }
        }

    }

    public Integer getNumeroVeiculo() {
        return 1;
    }

    public Integer getNumeroVeiculoExterno() {
        return 2;
    }

    public void limpar() {
        placaConsulta = "";
        codInfracao = "";
        matricula = "";
        setEntity(new AutoBlitz());
        this.postConstruct();
    }

    public Integer getNumeroVeiculoMudar() {
        return numeroVeiculoMudar;
    }

    public void setNumeroVeiculoMudar(Integer numeroVeiculoMudar) {
        this.numeroVeiculoMudar = numeroVeiculoMudar;
    }

    public String getCodInfracao() {
        return codInfracao;
    }

    public void setCodInfracao(String codInfracao) {
        this.codInfracao = codInfracao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<MunicipioBlitz> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<MunicipioBlitz> municipios) {
        this.municipios = municipios;
    }

    public List<EstadoBlitz> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadoBlitz> estados) {
        this.estados = estados;
    }

    public Integer getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(Integer cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Integer getCpfNumero() {
        return 1;
    }

    public Integer getCnpjNumero() {
        return 2;
    }

    public SessaoUsuarioMB getSessaoUsuarioMB() {
        return sessaoUsuarioMB;
    }

    public void setSessaoUsuarioMB(SessaoUsuarioMB sessaoUsuarioMB) {
        this.sessaoUsuarioMB = sessaoUsuarioMB;
    }

    public List<EspecieBlitz> getEspecieBlitzs() {
        return especieBlitzs;
    }

    public void setEspecieBlitzs(List<EspecieBlitz> especieBlitzs) {
        this.especieBlitzs = especieBlitzs;
    }

    public List<TipoVeiculoBlitz> getTipoVeiculoBlitzs() {
        return tipoVeiculoBlitzs;
    }

    public void setTipoVeiculoBlitzs(List<TipoVeiculoBlitz> tipoVeiculoBlitzs) {
        this.tipoVeiculoBlitzs = tipoVeiculoBlitzs;
    }

    public List<CorBlitz> getCorBlitzs() {
        return corBlitzs;
    }

    public void setCorBlitzs(List<CorBlitz> corBlitzs) {
        this.corBlitzs = corBlitzs;
    }

    public String getPlacaConsulta() {
        return placaConsulta;
    }

    public void setPlacaConsulta(String placaConsulta) {
        this.placaConsulta = placaConsulta.toUpperCase();
    }

    public Autuador[] getAutuadores() {
        return Autuador.values();
    }

    @Override
    public AutoBlitzBO getBO() {
        return autoBlitzBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
