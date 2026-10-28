
package data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnectionFactory {
    private static final String URL = "jdbc:sqlite:faculdade.db";

    public static Connection getConnection() throws SQLException{
        Connection conn =  DriverManager.getConnection(URL);
        try (Statement st = conn.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
        return conn;
    }
}
