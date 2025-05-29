package adapter.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void init() {
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Paciente (
                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                         cpf TEXT NOT NULL UNIQUE,
                         nome TEXT NOT NULL,
                         telefone TEXT
                         )
            """);

            stmt.execute("""
               CREATE TABLE IF NOT EXISTS Especialidade (
                                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                                  descricao TEXT NOT NULL
                                  )
            """);

            stmt.execute("""
               CREATE TABLE IF NOT EXISTS Medico (
                                           id INTEGER PRIMARY KEY AUTOINCREMENT,
                                           cpf TEXT NOT NULL UNIQUE,
                                           nome TEXT NOT NULL,
                                           inscricaoCRM TEXT NOT NULL UNIQUE,
                                           especialidade_id INTEGER NOT NULL,
                                           FOREIGN KEY (especialidade_id) REFERENCES Especialidade(id)
                                           )
            """);

            stmt.execute("""
              CREATE TABLE IF NOT EXISTS Consulta (
                                           id INTEGER PRIMARY KEY AUTOINCREMENT,
                                           dataHora TEXT NOT NULL,
                                           status TEXT NOT NULL CHECK (status IN ('AGENDADA', 'CANCELADA', 'CONFIRMADA')),
                                           paciente_id INTEGER NOT NULL,
                                           medico_id INTEGER NOT NULL,
                                           FOREIGN KEY (paciente_id) REFERENCES Paciente(id),
                                           FOREIGN KEY (medico_id) REFERENCES Medico(id)
                                           )
            """);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
