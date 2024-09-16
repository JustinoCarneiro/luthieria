package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://" + System.getenv("POSTGRES_HOST") + ":" + System.getenv("POSTGRES_PORT") + "/" + System.getenv("POSTGRES_DB");
        String user = System.getenv("POSTGRES_USER");
        String password = System.getenv("POSTGRES_PASSWORD");

        return DriverManager.getConnection(url, user, password);
    }
}

