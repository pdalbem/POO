package data.dao;

import data.db.SQLiteConnectionFactory;
import exception.EntityAlreadyExistsException;
import model.Proprietario;
import model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoDAOImpl implements VeiculoDAO {

    @Override
    public Veiculo save(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placa, marca, proprietario_id) VALUES (?, ?, ?)";

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getMarca());
            stmt.setInt(3, veiculo.getProprietario().getId());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next())
                    return new Veiculo(rs.getInt(1), veiculo.getPlaca(), veiculo.getMarca(), veiculo.getProprietario() );
            }

            throw new SQLException("Não foi possível obter o ID do veículo.");

        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE"))
                throw new EntityAlreadyExistsException("Placa já existe: " + veiculo.getPlaca());

            throw new RuntimeException("Erro ao cadastrar veículo.", e);
        }
    }

    @Override
    public Optional<Veiculo> findByPlaca(String placa) {
        String sql = """
            SELECT
                v.id,
                v.placa,
                v.marca,
                p.id AS proprietario_id,
                p.nome AS proprietario_nome
            FROM veiculo v
            INNER JOIN proprietario p
            ON v.proprietario_id = p.id
            WHERE v.placa = ?
            """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, placa);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    return Optional.of(mapearVeiculo(rs));

                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar veículo pela placa.", e );
        }
    }

    @Override
    public List<Veiculo> findByProprietario(Proprietario proprietario) {
        String sql = """
            SELECT
                v.id,
                v.placa,
                v.marca,
                p.id AS proprietario_id,
                p.nome AS proprietario_nome
            FROM veiculo v
            INNER JOIN proprietario p
            ON v.proprietario_id = p.id
            WHERE v.proprietario_id = ?
            """;

        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, proprietario.getId());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next())
                    veiculos.add(mapearVeiculo(rs));
            }

            return veiculos;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar veículos do proprietário.", e );
        }
    }

    @Override
    public Optional<Veiculo> findById(int id) {
        String sql =  """
            SELECT
                v.id,
                v.placa,
                v.marca,
                p.id AS proprietario_id,
                p.nome AS proprietario_nome
            FROM veiculo v
            INNER JOIN proprietario p
            ON v.proprietario_id = p.id
            WHERE v.id = ?
            """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    return Optional.of(mapearVeiculo(rs));

                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar veículo por ID.", e );
        }
    }

    @Override
    public List<Veiculo> findAll() {
        String sql = """
            SELECT
                v.id,
                v.placa,
                v.marca,
                p.id AS proprietario_id,
                p.nome AS proprietario_nome
            FROM veiculo v
            INNER JOIN proprietario p
            ON v.proprietario_id = p.id
            """;

        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next())
                veiculos.add(mapearVeiculo(rs));

            return veiculos;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar veículos.", e);
        }
    }

    private Veiculo mapearVeiculo(ResultSet rs) throws SQLException {
        Proprietario proprietario = new Proprietario(
                rs.getInt("proprietario_id"),
                rs.getString("proprietario_nome")
        );

        return new Veiculo(
                rs.getInt("id"),
                rs.getString("placa"),
                rs.getString("marca"),
                proprietario
        );
    }
}
