
package adapter.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void init() {
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
               CREATE TABLE IF NOT EXISTS proprietario (
                             id INTEGER PRIMARY KEY AUTOINCREMENT,
                             nome TEXT NOT NULL
                         )
            """);

            stmt.execute("""
                    CREATE TABLE IF NOT EXISTS veiculo (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        placa TEXT NOT NULL UNIQUE,
                        marca TEXT NOT NULL,
                        proprietario_id INTEGER NOT NULL,
                        FOREIGN KEY (proprietario_id) REFERENCES proprietario(id)
                    )
            """);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
