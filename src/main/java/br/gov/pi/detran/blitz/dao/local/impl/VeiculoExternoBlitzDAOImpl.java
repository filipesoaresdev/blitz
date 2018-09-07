package br.gov.pi.detran.blitz.dao.local.impl;

import br.gov.pi.detran.blitz.application.BaseDAOBlitzImpl;
import br.gov.pi.detran.blitz.dao.local.VeiculoExternoBlitzDAO;
import br.gov.pi.detran.blitz.modelo.local.VeiculoExternoBlitz;
import javax.ejb.Stateless;

/**
 *
 * @author filipesoares
 */
@Stateless
public class VeiculoExternoBlitzDAOImpl extends BaseDAOBlitzImpl<VeiculoExternoBlitz> implements VeiculoExternoBlitzDAO {

    @Override
    public Class getEntityClass() {
        return VeiculoExternoBlitz.class;
    }

}
