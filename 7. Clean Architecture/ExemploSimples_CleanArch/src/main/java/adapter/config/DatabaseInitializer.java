package adapter.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void init() {
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
               CREATE TABLE IF NOT EXISTS product (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  name TEXT NOT NULL,
                  price REAL NOT NULL
               );
            """);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
