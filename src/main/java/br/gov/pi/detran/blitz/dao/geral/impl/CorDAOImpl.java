package br.gov.pi.detran.blitz.dao.geral.impl;

import br.gov.pi.detran.blitz.application.BaseDAOImpl;
import br.gov.pi.detran.blitz.dao.geral.CorDAO;
import br.gov.pi.detran.blitz.modelo.geral.Cor;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author filipesoares
 */
@Stateless
public class CorDAOImpl extends BaseDAOImpl<Cor> implements CorDAO {
    
    @Override
    public Long maxCodigo(){
        
        StringBuilder queryString = new StringBuilder();
        queryString.append("select max(codigo) from Cor");
        
        Query query = getEntityManager().createQuery(queryString.toString());
        
        return (Long)query.getSingleResult();
        
    }
    
    
}
