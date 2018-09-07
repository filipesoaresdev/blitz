package br.gov.pi.detran.blitz.bo.geral;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.geral.InfracaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.geral.Infracao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author filipesoares
 */
@Stateless
public class InfracaoBO extends AbstractBusinessObject<Infracao> {

    @EJB
    private InfracaoDAO infracaoDAO;

    public void atualizarInfracao(FileReader arq)   throws FileNotFoundException, IOException, BusinessException {
        
        
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine();
        while (linha != null ) {
            Infracao infracao = new Infracao();
            linha = lerArq.readLine();
            if(linha.length() < 5){
                break;
            }
            infracao.setCodInfracao(Integer.valueOf(linha.substring(0, 5).trim()));
            infracao.setDescricao(linha.substring(5, 105).trim());
            infracao.setEnquadramento(linha.substring(105, 125).trim());
            infracao.setGravidade(linha.substring(125, 133).trim());
            if(infracao.getGravidade().equals("GRAVISS")){
                infracao.setGravidade("GRAVISSIMA");
            }
            infracao.setResponsabilidade(linha.substring(135, 155).trim());
            infracao.setCompetencia(linha.substring(155, 175).trim());
            infracao.setValor(linha.substring(189, 197).trim());
            
            save(infracao);
            
        }
        
    }

    @Override
    public InfracaoDAO getDAO() {
        return infracaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Infracao infracao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
}
