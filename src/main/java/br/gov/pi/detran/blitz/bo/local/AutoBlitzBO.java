package br.gov.pi.detran.blitz.bo.local;

import br.gov.pi.detran.blitz.constante.Constantes;
import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.local.AutoBlitzDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.AutoBlitz;
import br.gov.pi.detran.blitz.modelo.local.VeiculoExternoBlitz;
import com.xpert.faces.utils.FacesJasper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 *
 * @author filipesoares
 */
@Stateless
public class AutoBlitzBO extends AbstractBusinessObject<AutoBlitz> {

    @EJB
    private AutoBlitzDAO autoBlitzDAO;
    @EJB
    private VeiculoExternoBlitzBO veiculoExternoBlitzBO;

    public void gerarAutoImpresso(AutoBlitz autoBlitz) {

        Map parametros = new HashMap();

        parametros.put("logoDetran",
                FacesContext.getCurrentInstance().
                getExternalContext().getRealPath("/images/logo_detran.png"));

        parametros.put("logoGoverno",
                FacesContext.getCurrentInstance().
                getExternalContext().getRealPath("/images/logo_estado.png"));

        List<AutoBlitz> listaAutos = new ArrayList<AutoBlitz>();
        listaAutos.add(autoBlitz);

        FacesJasper.createJasperReport(listaAutos, parametros,
                "/WEB-INF/report/Relatorios/AutoDeInfracaoDeTransito-AIT.jasper",
                "Auto de Infração de Trânsito - AIT", null);

    }

    @Override
    public AutoBlitzDAO getDAO() {
        return autoBlitzDAO;
    }

    @Override
    public void save(AutoBlitz autoBlitz) throws BusinessException {

        if (autoBlitz.getNumAuto() == null) {
            Long numAuto = getDAO().maxNumAuto();
            numAuto++;
            autoBlitz.setNumAuto(numAuto);
            autoBlitz.setLetraNumAuto(Constantes.LETRA_NUMERO_AUTO);
        }

        super.save(autoBlitz);
    }

    public void salvarVeiculoExterno(AutoBlitz autoBlitz) {

        if (autoBlitz.getVeiculoBlitz().getId() == null) {

            VeiculoExternoBlitz veiculoExternoBlitz = new VeiculoExternoBlitz();

            veiculoExternoBlitz.setAnoExercicio(autoBlitz.getVeiculoBlitz().getAnoExercicio());
            veiculoExternoBlitz.setAnoFabricacao(autoBlitz.getVeiculoBlitz().getAnoFabricacao());
            veiculoExternoBlitz.setCategoria(autoBlitz.getVeiculoBlitz().getCategoria());
            veiculoExternoBlitz.setChassi(autoBlitz.getVeiculoBlitz().getChassi());
            veiculoExternoBlitz.setCor(autoBlitz.getVeiculoBlitz().getCor());
            veiculoExternoBlitz.setEspecie(autoBlitz.getVeiculoBlitz().getEspecie());
            veiculoExternoBlitz.setMarcaModelo(autoBlitz.getVeiculoBlitz().getMarcaModelo());
            veiculoExternoBlitz.setMunicipioBlitz(autoBlitz.getVeiculoBlitz().getMunicipioBlitz());
            veiculoExternoBlitz.setPlaca(autoBlitz.getVeiculoBlitz().getPlaca());
            veiculoExternoBlitz.setRenavam(autoBlitz.getVeiculoBlitz().getRenavam());
            veiculoExternoBlitz.setTipoVeiculoBlitz(autoBlitz.getVeiculoBlitz().getTipoVeiculoBlitz());
            veiculoExternoBlitz.setUfPlaca(autoBlitz.getVeiculoBlitz().getUfPlaca());

            veiculoExternoBlitz.setNomeProprietario(autoBlitz.getVeiculoBlitz().getNomeProprietario());
            veiculoExternoBlitz.setCpf(autoBlitz.getVeiculoBlitz().getCpf());
            veiculoExternoBlitz.setBairroProprietario(autoBlitz.getVeiculoBlitz().getBairroProprietario());
            veiculoExternoBlitz.setCepProprietario(autoBlitz.getVeiculoBlitz().getCepProprietario());
            veiculoExternoBlitz.setComplementoProprietario(autoBlitz.getVeiculoBlitz().getComplementoProprietario());
            veiculoExternoBlitz.setNumeroImovelProprietario(autoBlitz.getVeiculoBlitz().getNumeroImovelProprietario());
            veiculoExternoBlitz.setMunicipioProprietario(autoBlitz.getVeiculoBlitz().getMunicipioProprietario());
            veiculoExternoBlitz.setRgProprietario(autoBlitz.getVeiculoBlitz().getRgProprietario());

            veiculoExternoBlitzBO.getDAO().saveOrUpdate(veiculoExternoBlitz);

            autoBlitz.setVeiculoExternoBlitz(veiculoExternoBlitz);
            autoBlitz.setVeiculoBlitz(null);
        }
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(AutoBlitz autoBlitz) throws BusinessException {
        
        BusinessException be = new BusinessException();
        if((autoBlitz.getVeiculoBlitz() == null || autoBlitz.getVeiculoBlitz().getId() == null) && 
                (autoBlitz.getVeiculoExternoBlitz() == null || autoBlitz.getVeiculoExternoBlitz().getId() == null)){
            be.add("Veículo não cadastrado.");
        }
        if(autoBlitz.getInfracaoBlitz() == null || autoBlitz.getInfracaoBlitz().getCodInfracao() == null){
            be.add("Infração não cadastrada.");
        }
        if(autoBlitz.getMunicipioInfracao()== null || autoBlitz.getMunicipioInfracao().getId() == null){
            be.add("Local não cadastrado.");
        }
        if(autoBlitz.getAgente()== null || autoBlitz.getAgente().getId() == null){
            be.add("Agente não cadastrado.");
        }
        
        be.check();
        
    }

    @Override
    public boolean isAudit() {
        return true;
    }
}
