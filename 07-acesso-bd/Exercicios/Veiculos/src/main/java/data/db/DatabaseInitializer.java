
package data.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private static final String CREATE_PROP = """
               CREATE TABLE IF NOT EXISTS proprietario
              (
              id INTEGER PRIMARY KEY AUTOINCREMENT,
              nome TEXT NOT NULL
              )
                  """;

    private static final String CREATE_VEIC = """
                 CREATE TABLE IF NOT EXISTS veiculo
                  (
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  placa TEXT NOT NULL UNIQUE,
                  marca TEXT NOT NULL,
                  proprietario_id INTEGER NOT NULL,
                  FOREIGN KEY (proprietario_id) REFERENCES proprietario(id)
                  )
                 """;

    public static void initialize()  {
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(CREATE_PROP);
            stmt.execute(CREATE_VEIC);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar BD", e);
        }
    }
}
