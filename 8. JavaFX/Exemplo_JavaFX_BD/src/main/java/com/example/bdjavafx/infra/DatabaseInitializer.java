package com.example.bdjavafx.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            String sqlDepartamento = """
                CREATE TABLE IF NOT EXISTS departamento (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    sigla TEXT NOT NULL UNIQUE
                );
                """;

            String sqlFuncionario = """
                CREATE TABLE IF NOT EXISTS funcionario (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    cpf TEXT NOT NULL UNIQUE,
                    nome TEXT NOT NULL,
                    departamento INTEGER,
                    FOREIGN KEY (departamento) REFERENCES departamento (id)
                );
                """;

            stmt.execute(sqlDepartamento);
            stmt.execute(sqlFuncionario);

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabelas do banco de dados: " + e.getMessage());
        }
    }
}

