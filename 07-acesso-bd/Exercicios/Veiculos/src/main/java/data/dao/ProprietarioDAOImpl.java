package data.dao;

import data.db.SQLiteConnectionFactory;
import model.Proprietario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProprietarioDAOImpl implements ProprietarioDAO{
    @Override
    public Proprietario save(Proprietario proprietario) {
        String sql = """
                INSERT INTO proprietario (nome)
                VALUES (?)
                """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, proprietario.getNome());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next())
                    return new Proprietario(rs.getInt(1), proprietario.getNome());

            }

            throw new SQLException("Não foi possível obter o ID do proprietário.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar proprietário.", e);
        }
    }

    @Override
    public Optional<Proprietario> findById(int id) {
        String sql = """
                SELECT id, nome
                FROM proprietario
                WHERE id = ?
                """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Proprietario proprietario = new Proprietario(rs.getInt("id"), rs.getString("nome") );
                    return Optional.of(proprietario);
                }

                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar proprietário por ID.", e);
        }
    }

    @Override
    public List<Proprietario> findAll() {
        String sql = """
                SELECT id, nome
                FROM proprietario
                ORDER BY nome
                """;

        List<Proprietario> proprietarios = new ArrayList<>();

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Proprietario proprietario = new Proprietario(rs.getInt("id"), rs.getString("nome"));
                proprietarios.add(proprietario);
            }

            return proprietarios;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar proprietários.", e);
        }
    }
}
