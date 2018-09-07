package br.gov.pi.detran.blitz.dao.local.impl;

import br.gov.pi.detran.blitz.application.BaseDAOBlitzImpl;
import br.gov.pi.detran.blitz.dao.local.AutoBlitzDAO;
import br.gov.pi.detran.blitz.modelo.local.AutoBlitz;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author filipesoares
 */
@Stateless
public class AutoBlitzDAOImpl extends BaseDAOBlitzImpl<AutoBlitz> implements AutoBlitzDAO {
    
    @Override
    public Long maxNumAuto() {
        // municipioEmplacamento,"
        //        + "cor, marcaModelo, categoria, especie, tipoVeiculo

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT max(a.numAuto) FROM AutoBlitz a ");
        
        Query query = getEntityManager().createQuery(sql.toString());
        
        Long resultado = (Long) query.getSingleResult();
        if(resultado == null || resultado == 0){
            resultado = 0L;
        }

        return resultado;

    }
}
