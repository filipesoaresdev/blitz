package br.gov.pi.detran.blitz.thread;

import br.gov.pi.detran.blitz.conexao.ConnectionFactory;
import br.gov.pi.detran.blitz.modelo.local.VeiculoBlitz;
import com.xpert.faces.utils.FacesMessageUtils;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Ayslan
 */
@Stateless
public class SalvarVeiculoBlitz extends Thread {

    private List<VeiculoBlitz> veiculos;

    @Override
    public void run() {

        try {

            if (veiculos != null && !veiculos.isEmpty()) {

                Connection con = ConnectionFactory.createConnection();
                CallableStatement csSalvarUpdate;
                for (VeiculoBlitz veiculoBlitz : veiculos) {
                    if (veiculoBlitz != null) {
                        StringBuilder sql = new StringBuilder();
                        sql.append("{call upsertveiculo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                        csSalvarUpdate = con.prepareCall(sql.toString());

                        csSalvarUpdate.setLong(1, veiculoBlitz.getId());
                        csSalvarUpdate.setInt(2, veiculoBlitz.getAnoExercicio());
                        csSalvarUpdate.setInt(3, veiculoBlitz.getAnoFabricacao());
                        csSalvarUpdate.setString(4, veiculoBlitz.getChassi());
                        csSalvarUpdate.setString(5, veiculoBlitz.getCpf());
                        csSalvarUpdate.setString(6, veiculoBlitz.getNomeProprietario());
                        csSalvarUpdate.setString(7, veiculoBlitz.getPlaca());
                        csSalvarUpdate.setString(8, veiculoBlitz.getRenavam());
                        csSalvarUpdate.setString(9, veiculoBlitz.getUfPlaca());

                        if (veiculoBlitz.getCategoria() != null) {
                            csSalvarUpdate.setInt(10, veiculoBlitz.getCategoria().getId());
                        } else {
                            csSalvarUpdate.setNull(10, Types.INTEGER);
                        }
                        if (veiculoBlitz.getCor() != null) {
                            csSalvarUpdate.setInt(11, veiculoBlitz.getCor().getId());
                        } else {
                            csSalvarUpdate.setNull(11, Types.INTEGER);
                        }
                        if (veiculoBlitz.getEspecie() != null) {
                            csSalvarUpdate.setInt(12, veiculoBlitz.getEspecie().getId());
                        } else {
                            csSalvarUpdate.setNull(12, Types.INTEGER);
                        }
                        if (veiculoBlitz.getMarcaModelo() != null) {
                            csSalvarUpdate.setInt(13, veiculoBlitz.getMarcaModelo().getId());
                        } else {
                            csSalvarUpdate.setNull(13, Types.INTEGER);
                        }
                        if (veiculoBlitz.getMunicipioBlitz() != null) {
                            csSalvarUpdate.setInt(14, veiculoBlitz.getMunicipioBlitz().getId());
                        } else {
                            csSalvarUpdate.setNull(14, Types.INTEGER);
                        }
                        if (veiculoBlitz.getTipoVeiculoBlitz() != null) {
                            csSalvarUpdate.setInt(15, veiculoBlitz.getTipoVeiculoBlitz().getId());
                        } else {
                            csSalvarUpdate.setNull(15, Types.INTEGER, "integer");
                        }

                        csSalvarUpdate.execute();

                        csSalvarUpdate.close();
                        this.interrupt();
                    }
                }

            }
        } catch (SQLException ex) {

            FacesMessageUtils.error(ex.getMessage());
        }
    }

    public List<VeiculoBlitz> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<VeiculoBlitz> veiculos) {
        this.veiculos = veiculos;
    }
}