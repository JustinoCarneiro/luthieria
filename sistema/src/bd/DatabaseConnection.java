package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Classe responsável pela conexão com banco de dados, é necessário o serviço postgresql está ativo no host
public class DatabaseConnection {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/bdluthieria";
    private static final String USER = "admin";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro ao estabelecer a conexão com o banco de dados: " + e.getMessage());
            return null; 
        }
    }
}
