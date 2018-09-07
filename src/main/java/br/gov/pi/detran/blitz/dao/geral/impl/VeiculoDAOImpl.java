package br.gov.pi.detran.blitz.dao.geral.impl;

import br.gov.pi.detran.blitz.application.BaseDAOImpl;
import br.gov.pi.detran.blitz.constante.Constantes;
import br.gov.pi.detran.blitz.dao.geral.VeiculoDAO;
import br.gov.pi.detran.blitz.modelo.geral.Veiculo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author filipesoares
 */
@Stateless
public class VeiculoDAOImpl extends BaseDAOImpl<Veiculo> implements VeiculoDAO {

    @Override
    public List<Veiculo> consultaVeiculosData(Date data) {
        // municipioEmplacamento,"
        //        + "cor, marcaModelo, categoria, especie, tipoVeiculo
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT v FROM Veiculo v ");
        sql.append("join fetch v.cor ");
        sql.append("join fetch v.marcaModelo ");
        sql.append("join fetch v.categoria ");
        sql.append("join fetch v.especie ");
        sql.append("join fetch v.tipoVeiculo ");
        sql.append("join fetch v.municipioEmplacamento ");
        sql.append("join fetch v.municipioProprietario ");
        if (data != null) {
            sql.append("where v.dataUltimoProcessamento >= :data ");
        }
        sql.append(" order by v.dataUltimoProcessamento ");

        Query query = getEntityManager().createQuery(sql.toString());
        if (data != null) {
            query.setParameter("data", data);
        }
        query.setMaxResults(Constantes.QUANTIDADE_VEICULOS_CONSULTA);
        return query.getResultList();

    }

    @Override
    public Long contaVeiculosData(Date data) {
        // municipioEmplacamento,"
        //        + "cor, marcaModelo, categoria, especie, tipoVeiculo

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT count(*) FROM Veiculo v ");
        sql.append("join fetch v.cor ");
        sql.append("join fetch v.marcaModelo ");
        sql.append("join fetch v.categoria ");
        sql.append("join fetch v.especie ");
        sql.append("join fetch v.tipoVeiculo ");
        sql.append("join fetch v.municipioEmplacamento ");
        if (data != null) {
            sql.append("where v.dataUltimoProcessamento > :data ");
        }
        sql.append(" order by v.dataUltimoProcessamento ");

        Query query = getEntityManager().createQuery(sql.toString());
        if (data != null) {
            query.setParameter("data", data);
        }

        return (Long) query.getSingleResult();

    }
}
