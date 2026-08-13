
package adapter.repository;

import adapter.config.SQLiteConnectionFactory;
import domain.entity.Cidade;
import domain.repository.CidadeRepository;

import java.sql.*;
import java.util.*;

 public class CidadeRepositoryImpl implements CidadeRepository {
    @Override
    public void save(Cidade cidade) {
        String sqlInsert = "INSERT INTO cidade (nome) VALUES (?)";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cidade.getNome());
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                cidade.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cidade: " + e.getMessage());
        }
    }

    @Override
    public void update(Cidade cidade) {
        String sqlUpdate = "UPDATE cidade SET nome = ? WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlUpdate)) {
            stmt.setString(1, cidade.getNome());
            stmt.setInt(2, cidade.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cidade: " + e.getMessage());
        }
    }


    @Override
    public void delete(Cidade cidade) {
        String sql = "DELETE FROM cidade WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cidade.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar cidade: " + e.getMessage());
        }
    }

    @Override
    public Optional<Cidade> findById(int id) {
        String sql = "SELECT * FROM cidade WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                return Optional.of(new Cidade(rs.getInt("id"), rs.getString("nome")));

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar cidade por ID: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Cidade> findAll() {
        List<Cidade> cidades = new ArrayList<>();
        String sql = "SELECT * FROM cidade";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cidades.add(new Cidade(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar todas as cidade: " + e.getMessage());
        }
        return cidades.iterator();
    }

}
