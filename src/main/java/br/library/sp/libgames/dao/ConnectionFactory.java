package br.library.sp.libgames.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection conexao;

    public static Connection getConexao() throws SQLException {
        if (conexao == null) {
            conexao = DriverManager.getConnection
          ("jdbc:mysql://localhost:3306/libgames","root","p@$$w0rd");
        }
        return conexao;
    }
}
