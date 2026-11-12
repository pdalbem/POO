
package data.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private static final String CREATE_DOADOR = """
              
            CREATE TABLE IF NOT EXISTS doador (
               id INTEGER PRIMARY KEY AUTOINCREMENT,
               nome TEXT NOT NULL,
               cpf TEXT NOT NULL UNIQUE,
               data_nascimento TEXT NOT NULL,
               sexo TEXT NOT NULL,
               tipo_sanguineo TEXT NOT NULL,
               peso REAL NOT NULL,
               data_ultima_doacao TEXT
              )
                  """;

    private static final String CREATE_DOACAO = """
             
            CREATE TABLE IF NOT EXISTS doacao (
              id INTEGER PRIMARY KEY AUTOINCREMENT,
              doador_id INTEGER NOT NULL,
              data_doacao TEXT NOT NULL,
              FOREIGN KEY (doador_id) REFERENCES doador(id)
             )
                 """;

    public static void initialize()  {
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(CREATE_DOADOR);
            stmt.execute(CREATE_DOACAO);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar BD", e);
        }
    }
}
