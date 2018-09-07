package br.gov.pi.detran.blitz.application;

import br.gov.pi.detran.blitz.constante.Constantes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author
 */
public class BaseDAOImpl<T> extends com.xpert.persistence.dao.BaseDAOImpl<T> {

    @PersistenceContext(unitName=Constantes.PERSISTENCE_UNIT_NAME_DETRANPI)
    private EntityManager entityManager;

    public BaseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
