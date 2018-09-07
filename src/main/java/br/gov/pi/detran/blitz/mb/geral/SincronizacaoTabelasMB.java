package br.gov.pi.detran.blitz.mb.geral;

import br.gov.pi.detran.blitz.bo.geral.CategoriaBO;
import br.gov.pi.detran.blitz.bo.geral.CorBO;
import br.gov.pi.detran.blitz.bo.geral.EspecieBO;
import br.gov.pi.detran.blitz.bo.geral.EstadoBO;
import br.gov.pi.detran.blitz.bo.geral.InfracaoBO;
import br.gov.pi.detran.blitz.bo.geral.MarcaModeloBO;
import br.gov.pi.detran.blitz.bo.geral.MunicipioBO;
import br.gov.pi.detran.blitz.bo.geral.TipoVeiculoBO;
import br.gov.pi.detran.blitz.bo.geral.VeiculoBO;
import br.gov.pi.detran.blitz.bo.local.CategoriaBlitzBO;
import br.gov.pi.detran.blitz.bo.local.CorBlitzBO;
import br.gov.pi.detran.blitz.bo.local.EspecieBlitzBO;
import br.gov.pi.detran.blitz.bo.local.EstadoBlitzBO;
import br.gov.pi.detran.blitz.bo.local.InfracaoBlitzBO;
import br.gov.pi.detran.blitz.bo.local.MarcaModeloBlitzBO;
import br.gov.pi.detran.blitz.bo.local.MunicipioBlitzBO;
import br.gov.pi.detran.blitz.bo.local.ParametroBlitzBO;
import br.gov.pi.detran.blitz.bo.local.TipoVeiculoBlitzBO;
import br.gov.pi.detran.blitz.bo.local.VeiculoBlitzBO;
import br.gov.pi.detran.blitz.constante.Constantes;
import br.gov.pi.detran.blitz.mb.controleacesso.SessaoUsuarioMB;
import br.gov.pi.detran.blitz.modelo.geral.Categoria;
import br.gov.pi.detran.blitz.modelo.geral.Cor;
import br.gov.pi.detran.blitz.modelo.geral.Especie;
import br.gov.pi.detran.blitz.modelo.geral.Estado;
import br.gov.pi.detran.blitz.modelo.geral.Infracao;
import br.gov.pi.detran.blitz.modelo.geral.MarcaModelo;
import br.gov.pi.detran.blitz.modelo.geral.Municipio;
import br.gov.pi.detran.blitz.modelo.geral.TipoVeiculo;
import br.gov.pi.detran.blitz.modelo.geral.Veiculo;
import br.gov.pi.detran.blitz.modelo.local.CategoriaBlitz;
import br.gov.pi.detran.blitz.modelo.local.CorBlitz;
import br.gov.pi.detran.blitz.modelo.local.EspecieBlitz;
import br.gov.pi.detran.blitz.modelo.local.MarcaModeloBlitz;
import br.gov.pi.detran.blitz.modelo.local.MunicipioBlitz;
import br.gov.pi.detran.blitz.modelo.local.ParametroBlitz;
import br.gov.pi.detran.blitz.modelo.local.TipoVeiculoBlitz;
import br.gov.pi.detran.blitz.thread.SalvarVeiculoBlitz;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author filipesoares
 */
@ManagedBean
@ViewScoped
public class SincronizacaoTabelasMB  extends HttpServlet implements Serializable {

    @EJB
    private CorBO corBO;
    @EJB
    private MarcaModeloBO marcaModeloBO;
    @EJB
    private EspecieBO especieBO;
    @EJB
    private CategoriaBO categoriaBO;
    @EJB
    private VeiculoBO veiculoBO;
    @EJB
    private EstadoBO estadoBO;
    @EJB
    private MunicipioBO municipioBO;
    @EJB
    private CorBlitzBO corBlitzBO;
    @EJB
    private TipoVeiculoBO tipoVeiculoBO;
    @EJB
    private InfracaoBO infracaoBO;
    @EJB
    private MarcaModeloBlitzBO marcaModeloBlitzBO;
    @EJB
    private EspecieBlitzBO especieBlitzBO;
    @EJB
    private CategoriaBlitzBO categoriaBlitzBO;
    @EJB
    private EstadoBlitzBO estadoBlitzBO;
    @EJB
    private VeiculoBlitzBO veiculoBlitzBO;
    @EJB
    private MunicipioBlitzBO municipioBlitzBO;
    @EJB
    private ParametroBlitzBO parametroBlitzBO;
    @EJB
    private TipoVeiculoBlitzBO tipoVeiculoBlitzBO;
    @EJB
    private InfracaoBlitzBO infracaoBlitzBO;
    private Double progress = 0.0;
    private Double quantiTotal = 0.0;
    private Double valorProgressoAdd = 0.0;
    private List<Cor> cores;
    private List<MarcaModelo> marcaModelos;
    private List<Especie> especies;
    private List<Categoria> categorias;
    private List<Veiculo> veiculos;
    private List<Estado> estados;
    private List<Municipio> municipios;
    private List<TipoVeiculo> tipoVeiculos;
    private List<Infracao> infracoes;
    private ParametroBlitz parametro;
    private List<SalvarVeiculoBlitz> salvarVeiculoBlitz;
    @ManagedProperty(value = "#{sessaoUsuarioMB}")
    private SessaoUsuarioMB sessaoUsuarioMB;

    @PostConstruct
    private void carregarDados() {
        if (sessaoUsuarioMB.getMarcaModeloBlitzs() == null || sessaoUsuarioMB.getMarcaModeloBlitzs().isEmpty()) {
            sessaoUsuarioMB.carregarModelos();
        }
    }

    public void sincronizarTabelas() {
        try {
            prepararSincronizacaoCor();
            prepararSincronizacaoMarcaModelo();
            prepararSincronizacaoEspecies();
            prepararSincronizacaoCategorias();
            prepararSincronizacaoEstados();
            prepararSincronizacaoMunicipios();
            prepararSincronizacaoTipoVeiculos();

            if (quantiTotal > 0) {
                valorProgressoAdd = (100 / quantiTotal);
            } else {
                progress = 100.0;
            }

            corBlitzBO.sincronizarCor(cores, valorProgressoAdd, progress);

            marcaModeloBlitzBO.sincronizarMarcaModelo(marcaModelos, valorProgressoAdd, progress);

            especieBlitzBO.sincronizarEspecie(especies, valorProgressoAdd, progress);

            categoriaBlitzBO.sincronizarCategoria(categorias, valorProgressoAdd, progress);

            estadoBlitzBO.sincronizarEstado(estados, valorProgressoAdd, progress);

            municipioBlitzBO.sincronizarMunicipios(municipios, valorProgressoAdd, progress);

            tipoVeiculoBlitzBO.sincronizarTipoVeiculos(tipoVeiculos, valorProgressoAdd, progress);

            sincronizarVeiculos();
        } catch (BusinessException ex) {
            Logger.getLogger(SincronizacaoTabelasMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sincronizarCor() {
        prepararSincronizacaoCor();
        if (quantiTotal > 0) {
            valorProgressoAdd = (100 / quantiTotal);
        }
        corBlitzBO.sincronizarCor(cores, valorProgressoAdd, progress);
        FacesMessageUtils.sucess();
    }

    public void sincronizarMarcaModelos() {
        prepararSincronizacaoMarcaModelo();
        if (quantiTotal > 0) {
            valorProgressoAdd = (100 / quantiTotal);
        }
        marcaModeloBlitzBO.sincronizarMarcaModelo(marcaModelos, valorProgressoAdd, progress);
        FacesMessageUtils.sucess();
    }

    public void sincronizarEspecies() {
        prepararSincronizacaoEspecies();
        if (quantiTotal > 0) {
            valorProgressoAdd = (100 / quantiTotal);
        }
        especieBlitzBO.sincronizarEspecie(especies, valorProgressoAdd, progress);
        FacesMessageUtils.sucess();
    }

    public void sincronizarCategorias() {
        prepararSincronizacaoCategorias();
        if (quantiTotal > 0) {
            valorProgressoAdd = (100 / quantiTotal);
        }
        categoriaBlitzBO.sincronizarCategoria(categorias, valorProgressoAdd, progress);
        FacesMessageUtils.sucess();
    }

    public void sincronizarTipoVeiculos() {
        prepararSincronizacaoTipoVeiculos();
        if (quantiTotal > 0) {
            valorProgressoAdd = (100 / quantiTotal);
        }
        tipoVeiculoBlitzBO.sincronizarTipoVeiculos(tipoVeiculos, valorProgressoAdd, progress);
        FacesMessageUtils.sucess();
    }

    public void sincronizarInfracoes() {
        prepararSincronizacaoInfracoes();
        if (quantiTotal > 0) {
            valorProgressoAdd = (100 / quantiTotal);
        }
        infracaoBlitzBO.sincronizarInfracoes(infracoes, valorProgressoAdd, progress);
        FacesMessageUtils.sucess();
    }

    public void sincronizarEstadosMunicipios() {
        try {
            prepararSincronizacaoEstados();
            prepararSincronizacaoMunicipios();
            if (quantiTotal > 0) {
                valorProgressoAdd = (100 / quantiTotal);
            }
            estadoBlitzBO.sincronizarEstado(estados, valorProgressoAdd, progress);

            municipioBlitzBO.sincronizarMunicipios(municipios, valorProgressoAdd, progress);
            FacesMessageUtils.sucess();
        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    public void sincronizarVeiculos() {

        List<CategoriaBlitz> categoriasBlitzs = categoriaBlitzBO.getDAO().listAll();
        List<CorBlitz> corBlitzs = corBlitzBO.getDAO().listAll();
        List<MunicipioBlitz> municipioBlitzs = municipioBlitzBO.consultaMunicipios();
        List<EspecieBlitz> especieBlitzs = especieBlitzBO.getDAO().listAll();
        List<TipoVeiculoBlitz> tipoVeiculoBlitzs = tipoVeiculoBlitzBO.getDAO().listAll();

        parametro = parametroBlitzBO.consultaParametro(parametro);
        Calendar comeco = Calendar.getInstance();
        salvarVeiculoBlitz = new ArrayList<SalvarVeiculoBlitz>();
        do {
            veiculos = veiculoBO.consultaVeiculos(parametro.getDataUltimaAtualizacaoVeiculos());
            if (!veiculos.isEmpty() && veiculos.size() == Constantes.QUANTIDADE_VEICULOS_CONSULTA) {
                parametro.setDataUltimaAtualizacaoVeiculos(veiculos.get(veiculos.size() - 1).getDataUltimoProcessamento());
            } else {
                parametro.setDataUltimaAtualizacaoVeiculos(Calendar.getInstance().getTime());
            }
            int valorInicio = 0;

            for (int i = 0; i <= veiculos.size() - 1; i++) {

                if ((i == veiculos.size() - 1) || (i % Constantes.QUANTIDADE_VEICULOS_POR_THREAD == 0 && i != 0)) {
                    salvarVeiculoBlitz.add(new SalvarVeiculoBlitz());

                    while (true) {
                        if (Thread.activeCount() < Constantes.QUANTIDADE_THREADS_ATIVAS_MAX) {
                            break;
                        }
                    }

                    veiculoBlitzBO.sincronizarVeiculo(veiculos.subList(valorInicio, i), categoriasBlitzs, corBlitzs, sessaoUsuarioMB.getMarcaModeloBlitzs(),
                            municipioBlitzs, especieBlitzs, tipoVeiculoBlitzs, salvarVeiculoBlitz.get(salvarVeiculoBlitz.size() - 1));
                    salvarVeiculoBlitz.get(salvarVeiculoBlitz.size() - 1).start();
                    List<SalvarVeiculoBlitz> listaAux = new ArrayList<SalvarVeiculoBlitz>(salvarVeiculoBlitz);
                    for (SalvarVeiculoBlitz svb : listaAux) {
                        if (!svb.isAlive()) {

                            salvarVeiculoBlitz.remove(svb);

                        }
                    }
                    valorInicio = i + 1;
                }
            }
        } while (veiculos != null && !veiculos.isEmpty());
        Calendar fim = Calendar.getInstance();
        Long diferenca = fim.getTimeInMillis() - comeco.getTimeInMillis();
        System.out.println("DURAÇÃO DO PROCESSO - " + String.format("%03d:%02d", diferenca / 3600000, (diferenca / 60000) % 60));
        parametroBlitzBO.atualizaDataUltimaSincroniaVeiculo(parametro);
    }

    public void prepararSincronizacaoCor() {
        cores = corBO.getDAO().listAll();
        quantiTotal += cores.size();

    }

    public void prepararSincronizacaoMarcaModelo() {

        marcaModelos = marcaModeloBO.getDAO().listAll();
        quantiTotal += marcaModelos.size();
    }

    public void prepararSincronizacaoEspecies() {

        especies = especieBO.getDAO().listAll();
        quantiTotal += especies.size();

    }

    public void prepararSincronizacaoCategorias() {

        categorias = categoriaBO.getDAO().listAll();
        quantiTotal += categorias.size();

    }

    public void prepararSincronizacaoEstados() {

        estados = estadoBO.getDAO().listAll();
        quantiTotal += estados.size();

    }

    public void prepararSincronizacaoMunicipios() {

        municipios = municipioBO.getDAO().listAll();
        quantiTotal += municipios.size();

    }

    public void prepararSincronizacaoTipoVeiculos() {

        tipoVeiculos = tipoVeiculoBO.getDAO().listAll();
        quantiTotal += tipoVeiculos.size();

    }

    public void prepararSincronizacaoInfracoes() {

        infracoes = infracaoBO.getDAO().listAll();
        quantiTotal += infracoes.size();

    }

    public void importarInfracoes() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();  
  
ServletContext sc = (ServletContext) context.getExternalContext()  
                    .getContext();  
            FileReader arq = new FileReader(sc.getRealPath("/WEB-INF/arquivos/TABINFF.txt"));
            infracaoBO.atualizarInfracao(arq);
            arq.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SincronizacaoTabelasMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessageUtils.error(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(SincronizacaoTabelasMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessageUtils.error(ex.getMessage());
        } catch (BusinessException ex) {
            Logger.getLogger(SincronizacaoTabelasMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesMessageUtils.error(ex);
        } 

    }

    public Double getValorProgressoAdd() {
        return valorProgressoAdd;
    }

    public void setValorProgressoAdd(Double valorProgressoAdd) {
        this.valorProgressoAdd = valorProgressoAdd;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public Double getQuantiTotal() {
        return quantiTotal;
    }

    public void setQuantiTotal(Double quantiTotal) {
        this.quantiTotal = quantiTotal;
    }

    public List<Cor> getCores() {
        return cores;
    }

    public void setCores(List<Cor> cores) {
        this.cores = cores;
    }

    public List<MarcaModelo> getMarcaModelos() {
        return marcaModelos;
    }

    public void setMarcaModelos(List<MarcaModelo> marcaModelos) {
        this.marcaModelos = marcaModelos;
    }

    public List<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public ParametroBlitz getParametro() {
        return parametro;
    }

    public void setParametro(ParametroBlitz parametro) {
        this.parametro = parametro;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public SessaoUsuarioMB getSessaoUsuarioMB() {
        return sessaoUsuarioMB;
    }

    public void setSessaoUsuarioMB(SessaoUsuarioMB sessaoUsuarioMB) {
        this.sessaoUsuarioMB = sessaoUsuarioMB;
    }

    public void onComplete() {
        FacesMessageUtils.info("Operação concluída.");
    }
}
