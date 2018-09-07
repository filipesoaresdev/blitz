package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.MunicipioBlitzDAO;
import br.gov.pi.detran.blitz.modelo.geral.Municipio;
import br.gov.pi.detran.blitz.modelo.local.EstadoBlitz;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.MunicipioBlitz;

/**
 *
 * @author filipesoares
 */
@Stateless
public class MunicipioBlitzBO extends AbstractBusinessObject<MunicipioBlitz> {

    @EJB
    private MunicipioBlitzDAO municipioBlitzDAO;
    @EJB
    private EstadoBlitzBO estadoBlitzBO;
    
    public List<MunicipioBlitz>  consultaMunicipios(){
        
        List<MunicipioBlitz> municipios = getDAO().listAll();
        for (MunicipioBlitz municipioBlitz : municipios) {
            municipioBlitz.setEstadoBlitz(getDAO().getInitialized(municipioBlitz.getEstadoBlitz()));
        }
        return municipios;
        
    }
    
    public void sincronizarMunicipios(List<Municipio> municipios, double valorProgressAdd, double progress) throws BusinessException {

        List<EstadoBlitz> estadoBlitzs = estadoBlitzBO.getDAO().listAll();
        
        if(estadoBlitzs.isEmpty()){
            throw new BusinessException("Estados não sincronizados");
        }
        
        for (Municipio municipio : municipios) {
            MunicipioBlitz municipioBlitz  = new MunicipioBlitz();
            municipioBlitz.setId(municipio.getId());
            municipioBlitz.setDescricao(municipio.getDescricao());
            
            for (EstadoBlitz estadoBlitz : estadoBlitzs) {
                if(estadoBlitz.getId() == municipio.getEstado().getId()){
                    municipioBlitz.setEstadoBlitz(estadoBlitz);
                    break;
                }
            }
            getDAO().saveOrUpdate(municipioBlitz,false);
            progress += valorProgressAdd;
        }
        getDAO().getSession().flush();
    }
    
    @Override
    public MunicipioBlitzDAO getDAO() {
        return municipioBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MunicipioBlitz municipioBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
