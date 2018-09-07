package br.gov.pi.detran.blitz.bo.local;

import br.gov.pi.detran.blitz.bo.geral.VeiculoBO;
import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.VeiculoBlitzDAO;
import br.gov.pi.detran.blitz.modelo.geral.Categoria;
import br.gov.pi.detran.blitz.modelo.geral.Veiculo;
import br.gov.pi.detran.blitz.modelo.local.CategoriaBlitz;
import br.gov.pi.detran.blitz.modelo.local.CorBlitz;
import br.gov.pi.detran.blitz.modelo.local.EspecieBlitz;
import br.gov.pi.detran.blitz.modelo.local.MarcaModeloBlitz;
import br.gov.pi.detran.blitz.modelo.local.MunicipioBlitz;
import br.gov.pi.detran.blitz.modelo.local.ParametroBlitz;
import br.gov.pi.detran.blitz.modelo.local.TipoVeiculoBlitz;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.VeiculoBlitz;
import br.gov.pi.detran.blitz.thread.SalvarVeiculoBlitz;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author filipesoares
 */
@Stateless
public class VeiculoBlitzBO extends AbstractBusinessObject<VeiculoBlitz> {

    @EJB
    private VeiculoBlitzDAO veiculoBlitzDAO;
    @EJB
    private ParametroBlitzBO parametroBlitzBO;
    @EJB
    private VeiculoBO veiculoBO;
    private List<VeiculoBlitz> veiculosBlitzsSalvar;

    public void sincronizarVeiculo(List<Veiculo> veiculos, List<CategoriaBlitz> categoriasBlitzs,
            List<CorBlitz> corBlitzs, List<MarcaModeloBlitz> marcaModeloBlitzs, List<MunicipioBlitz> municipioBlitzs, 
            List<EspecieBlitz> especieBlitzs, List<TipoVeiculoBlitz> tipoVeiculoBlitzs,SalvarVeiculoBlitz salvarVeiculoBlitz) {


        veiculosBlitzsSalvar = new LinkedList<VeiculoBlitz>();

        for (Veiculo veiculo : veiculos) {
            VeiculoBlitz veiculoBlitz = new VeiculoBlitz();

            for (CategoriaBlitz categoriaBlitz : categoriasBlitzs) {
                if (categoriaBlitz.getId() == veiculo.getCategoria().getId()) {
                    veiculoBlitz.setCategoria(categoriaBlitz);
                }
            }
            for (CorBlitz corBlitz : corBlitzs) {
                if (corBlitz.getId() == veiculo.getCor().getId()) {
                    veiculoBlitz.setCor(corBlitz);
                }
            }
            for (MarcaModeloBlitz marcaModeloBlitz : marcaModeloBlitzs) {
                if (marcaModeloBlitz.getId().equals(veiculo.getMarcaModelo().getId())) {
                    veiculoBlitz.setMarcaModelo(marcaModeloBlitz);
                }
            }
            for (MunicipioBlitz municipioBlitz : municipioBlitzs) {
                if (municipioBlitz.getId().equals(veiculo.getMunicipioEmplacamento().getId())) {
                    veiculoBlitz.setMunicipioBlitz(municipioBlitz);
                }
            }
            for (MunicipioBlitz municipioBlitz : municipioBlitzs) {
                if (municipioBlitz.getId().equals(veiculo.getMunicipioProprietario().getId())) {
                    veiculoBlitz.setMunicipioProprietario(municipioBlitz);
                }
            }
            for (EspecieBlitz especieBlitz : especieBlitzs) {
                if (especieBlitz.getId().equals(veiculo.getEspecie().getId())) {
                    veiculoBlitz.setEspecie(especieBlitz);
                }
            }
            for (TipoVeiculoBlitz tipoVeiculoBlitz : tipoVeiculoBlitzs) {
                if (tipoVeiculoBlitz.getId().equals(veiculo.getTipoVeiculo().getId())) {
                    veiculoBlitz.setTipoVeiculoBlitz(tipoVeiculoBlitz);
                }
            }

            veiculoBlitz.setId(veiculo.getId().longValue());
            veiculoBlitz.setAnoExercicio(veiculo.getAnoExercicio());
            veiculoBlitz.setAnoFabricacao(veiculo.getAnoFabricacao());

            veiculoBlitz.setChassi(veiculo.getChassi());
            veiculoBlitz.setPlaca(veiculo.getPlaca());
            veiculoBlitz.setRenavam(veiculo.getRenavam());
            
            veiculoBlitz.setCpf(veiculo.getCpf_cnpj());
            veiculoBlitz.setNomeProprietario(veiculo.getNomeProprietario());
            veiculoBlitz.setBairroProprietario(veiculo.getBairroProprietario());
            veiculoBlitz.setCepProprietario(veiculo.getCepProprietario());
            veiculoBlitz.setComplementoProprietario(veiculo.getComplementoProprietario());
            veiculoBlitz.setNumeroImovelProprietario(veiculo.getNumeroImovelProprietario());
            veiculoBlitz.setRgProprietario(veiculo.getRgProprietario());

            veiculosBlitzsSalvar.add(veiculoBlitz);
            // getDAO().saveOrUpdate(veiculoBlitz,false);
        }
        salvarVeiculoBlitz.setVeiculos(veiculosBlitzsSalvar);
      

    }

    public VeiculoBlitz consultaVeiculoPorPlaca(String placa) throws BusinessException {

        VeiculoBlitz veiculoBlitz = getDAO().unique("placa", placa.replace("-", ""));

        if (veiculoBlitz == null) {
            throw new BusinessException("Veículo não encontrado");
        }
        veiculoBlitz.setMarcaModelo(getDAO().getInitialized(veiculoBlitz.getMarcaModelo()));
        veiculoBlitz.setMunicipioBlitz(getDAO().getInitialized(veiculoBlitz.getMunicipioBlitz()));
        veiculoBlitz.getMunicipioBlitz().setEstadoBlitz(getDAO().getInitialized(veiculoBlitz.getMunicipioBlitz().getEstadoBlitz()));
        veiculoBlitz.setEspecie(getDAO().getInitialized(veiculoBlitz.getEspecie()));
        veiculoBlitz.setTipoVeiculoBlitz(getDAO().getInitialized(veiculoBlitz.getTipoVeiculoBlitz()));
        veiculoBlitz.setCor(getDAO().getInitialized(veiculoBlitz.getCor()));

        return veiculoBlitz;
    }

    @Override
    public VeiculoBlitzDAO getDAO() {
        return veiculoBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(VeiculoBlitz veiculoBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
}
