package adapter.repository;

import adapter.config.SQLiteConnectionFactory;
import domain.entity.Proprietario;
import domain.repository.ProprietarioRepository;

import java.sql.*;
import java.util.*;

public class ProprietarioRepositoryImpl implements ProprietarioRepository {

    @Override
    public void save(Proprietario proprietario) {
        String sql = "INSERT INTO proprietario (nome) VALUES (?)";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, proprietario.getNome());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                proprietario.setId(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar proprietário: "+e.getMessage());
        }
    }

    @Override
    public Optional<Proprietario> findById(int id) {
        String sql = "SELECT * FROM proprietario WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Proprietario(rs.getInt("id"), rs.getString("nome")));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar proprietário por id: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Proprietario> findAll() {
        List<Proprietario> proprietarios = new ArrayList<>();
        String sql = "SELECT * FROM proprietario";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                proprietarios.add(new Proprietario(rs.getInt("id"), rs.getString("nome")));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar todos os proprietários: " + e.getMessage());
        }
        return proprietarios.iterator();
    }
}

