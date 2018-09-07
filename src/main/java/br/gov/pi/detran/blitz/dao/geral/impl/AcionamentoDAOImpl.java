package br.gov.pi.detran.blitz.dao.geral.impl;

import br.gov.pi.detran.blitz.application.BaseDAOImpl;
import br.gov.pi.detran.blitz.dao.geral.AcionamentoDAO;
import br.gov.pi.detran.blitz.modelo.geral.Cor;
import java.math.BigInteger;
import java.util.Calendar;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author arnaldo
 */
@Stateless
public class AcionamentoDAOImpl extends BaseDAOImpl<Cor> implements AcionamentoDAO {

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Override
    public Long getNextProtocolo() {

        Integer ano = Calendar.getInstance().get(Calendar.YEAR);

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT MAX(a.numero) FROM acionamento a ");
        sql.append("WHERE a.ano = :ano ");

        Query query = getEntityManager().createNativeQuery(sql.toString());
        query.setParameter("ano", ano);

        Long max = null;
        try {
            Object object = query.getSingleResult();
            if (object != null) {
                max = ((BigInteger) object).longValue();
            }
        } catch (NoResultException ex) {
        }

        if (max == null) {
            max = 0L;
        }

        return max + 1;

    }
}
