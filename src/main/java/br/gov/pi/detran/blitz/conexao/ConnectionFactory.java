package br.gov.pi.detran.blitz.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection createConnection() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/blitz";
        //Nome da base de dados 
        String user = "postgres"; //nome do usuário do MySQL 
        String password = ""; //senha do MySQL 
        Connection conexao = DriverManager.getConnection(url, user, password);
        return conexao;
    }
}
