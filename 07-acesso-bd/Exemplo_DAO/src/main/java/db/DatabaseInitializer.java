
package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void init() {
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS cidade (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS curso (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS aluno (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    prontuario TEXT NOT NULL UNIQUE,
                    nome TEXT NOT NULL,
                    curso_id INTEGER NOT NULL,
                    cidade_id INTEGER NOT NULL,
                    FOREIGN KEY (curso_id) REFERENCES curso(id),
                    FOREIGN KEY (cidade_id) REFERENCES cidade(id)
                )
            """);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
