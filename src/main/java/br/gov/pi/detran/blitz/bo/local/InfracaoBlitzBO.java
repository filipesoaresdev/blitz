package br.gov.pi.detran.blitz.bo.local;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.detran.blitz.dao.local.InfracaoBlitzDAO;
import br.gov.pi.detran.blitz.enums.Competencia;
import br.gov.pi.detran.blitz.enums.Gravidade;
import br.gov.pi.detran.blitz.enums.Responsabilidade;
import br.gov.pi.detran.blitz.modelo.geral.Infracao;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.detran.blitz.modelo.local.InfracaoBlitz;

/**
 *
 * @author filipesoares
 */
@Stateless
public class InfracaoBlitzBO extends AbstractBusinessObject<InfracaoBlitz> {

    @EJB
    private InfracaoBlitzDAO infracaoBlitzDAO;

    public InfracaoBlitz consultaInfracao(String codigoInfracao) throws BusinessException {

        InfracaoBlitz infracaoBlitz = getDAO().unique("codInfracao", Integer.valueOf(codigoInfracao.replace("-", "")));

        if (infracaoBlitz == null) {
            throw new BusinessException("Infração não encontrada");
        }


        return infracaoBlitz;
    }

    public void sincronizarInfracoes(List<Infracao> infracoes, double valorProgressAdd, double progress) {

        for (Infracao infracao : infracoes) {
            InfracaoBlitz infracaoBlitz = new InfracaoBlitz();
            infracaoBlitz.setCodInfracao(infracao.getCodInfracao());
            if (infracao.getCompetencia() != null && !infracao.getCompetencia().isEmpty()) {
                infracaoBlitz.setCompetencia(Competencia.getCompetencia(infracao.getCompetencia()));
            }

            if (infracao.getResponsabilidade() != null && !infracao.getResponsabilidade().isEmpty()) {
                infracaoBlitz.setResponsabilidade(Responsabilidade.getResponsabilidade(infracao.getResponsabilidade()));
            }

            if (infracao.getGravidade() != null && !infracao.getGravidade().isEmpty()) {
                infracaoBlitz.setGravidade(Gravidade.valueOf(infracao.getGravidade().replace("50%", "").trim()));
            }
            infracaoBlitz.setDescricao(infracao.getDescricao());
            infracaoBlitz.setEnquadramento(infracao.getEnquadramento());
            if (infracao.getValor() != null && !infracao.getValor().isEmpty()) {
                infracaoBlitz.setValor(Double.valueOf(infracao.getValor().replace(".", "").replace(",", ".")));
            }
            getDAO().saveOrUpdate(infracaoBlitz, false);
            progress += valorProgressAdd;
        }
        getDAO().getSession().flush();
    }

    @Override
    public InfracaoBlitzDAO getDAO() {
        return infracaoBlitzDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(InfracaoBlitz infracaoBlitz) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }
}
