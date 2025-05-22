package adapter.repository;

import adapter.config.SQLiteConnectionFactory;
import domain.entity.Proprietario;
import domain.entity.Veiculo;
import domain.repository.VeiculoRepository;

import java.sql.*;
import java.util.*;

import java.sql.*;
import java.util.*;

import java.sql.*;
import java.util.*;

public class VeiculoRepositoryImpl implements VeiculoRepository {

    @Override
    public void save(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placa, marca, proprietario_id) VALUES (?, ?, ?)";

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getMarca());
            stmt.setInt(3, veiculo.getProprietario().getId());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    veiculo.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar veículo: " + e.getMessage());
        }
    }

    @Override
    public Optional<Veiculo> findById(int id) {
        String sql = """
            SELECT v.id AS v_id, v.placa, v.marca,
                   p.id AS p_id, p.nome
              FROM veiculo v
              JOIN proprietario p ON v.proprietario_id = p.id
             WHERE v.id = ?
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Proprietario proprietario = new Proprietario(
                        rs.getInt("p_id"),
                        rs.getString("nome")
                );

                Veiculo veiculo = new Veiculo(
                        rs.getInt("v_id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        proprietario
                );

                return Optional.of(veiculo);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar veículo por id: " + e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public Iterator<Veiculo> findAll() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = """
            SELECT v.id AS v_id, v.placa, v.marca,
                   p.id AS p_id, p.nome
              FROM veiculo v
              JOIN proprietario p ON v.proprietario_id = p.id
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Proprietario proprietario = new Proprietario(
                        rs.getInt("p_id"),
                        rs.getString("nome")
                );

                Veiculo veiculo = new Veiculo(
                        rs.getInt("v_id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        proprietario
                );

                veiculos.add(veiculo);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar todos os veículos: " + e.getMessage());
        }

        return veiculos.iterator();
    }

    @Override
    public Optional<Veiculo> findByPlaca(String placa) {
        String sql = """
            SELECT v.id AS v_id, v.placa, v.marca,
                   p.id AS p_id, p.nome
              FROM veiculo v
              JOIN proprietario p ON v.proprietario_id = p.id
             WHERE v.placa = ?
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Proprietario proprietario = new Proprietario(
                        rs.getInt("p_id"),
                        rs.getString("nome")
                );

                Veiculo veiculo = new Veiculo(
                        rs.getInt("v_id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        proprietario
                );

                return Optional.of(veiculo);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar veículo por placa: " + e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public Iterator<Veiculo> findByProprietario(Proprietario proprietario) {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculo WHERE proprietario_id=?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, proprietario.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        proprietario
                );

                veiculos.add(veiculo);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar veículo por proprietário: " + e.getMessage());
        }

        return veiculos.iterator();
    }
}



