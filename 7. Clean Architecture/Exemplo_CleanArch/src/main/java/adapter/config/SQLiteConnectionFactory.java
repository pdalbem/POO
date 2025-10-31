
package adapter.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionFactory {
    private static final String URL = "jdbc:sqlite:faculdade.db";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL);
    }
}

