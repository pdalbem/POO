
package data.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private static final String CREATE_CURSO = """
                  CREATE TABLE IF NOT EXISTS curso 
                  (
                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                      nome TEXT NOT NULL
                  )
                  """;

    private static final String CREATE_ALUNO = """
                 CREATE TABLE IF NOT EXISTS aluno 
                 (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    prontuario TEXT NOT NULL UNIQUE,
                    nome TEXT NOT NULL,
                    curso_id INTEGER NOT NULL,
                    FOREIGN KEY (curso_id) REFERENCES curso(id)
                 )
                 """;

    public static void initialize()  {
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(CREATE_CURSO);
            stmt.execute(CREATE_ALUNO);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar BD", e);
        }
    }
}
