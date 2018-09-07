package br.gov.pi.detran.blitz.dao.local.impl;

import br.gov.pi.detran.blitz.application.BaseDAOBlitzImpl;
import br.gov.pi.detran.blitz.dao.CorBlitzDAO;
import br.gov.pi.detran.blitz.modelo.local.CorBlitz;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author filipesoares
 */
@Stateless
public class CorBlitzDAOImpl extends BaseDAOBlitzImpl<CorBlitz> implements CorBlitzDAO {

    @Override
    public Long maxCodigo() {

        StringBuilder queryString = new StringBuilder();
        queryString.append("select max(id) from Cor");

        Query query = getEntityManager().createQuery(queryString.toString());

        return (Long) query.getSingleResult();

    }
}
