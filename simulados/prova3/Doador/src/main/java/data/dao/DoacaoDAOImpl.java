package data.dao;

import data.db.SQLiteConnectionFactory;
import model.Doacao;
import model.Doador;
import model.Sexo;
import model.TipoSanguineo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DoacaoDAOImpl implements DoacaoDAO{
    @Override
    public Doacao save(Doacao doacao) {
        String sql = """
                INSERT INTO doacao (doador_id, data_doacao)
                VALUES (?, ?)
                """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, doacao.getDoador().getId());
            stmt.setString(2, doacao.getDataDoacao().toString());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next())
                    return new Doacao(
                            rs.getInt(1),
                            doacao.getDataDoacao(),
                            doacao.getDoador()
                    );


                throw new RuntimeException("Erro ao obter ID da doação.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar doação.", e);
        }
    }

    @Override
    public List<Doacao> findAll() {
        List<Doacao> listaDoacoes = new ArrayList<>();

        String sql = """
                SELECT d.id, d.data_doacao, d.doador_id,
                       do.nome, do.cpf, do.data_nascimento,
                       do.sexo, do.tipo_sanguineo, do.peso,
                       do.data_ultima_doacao
                FROM doacao d
                INNER JOIN doador do ON d.doador_id = do.id
                """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next())
                listaDoacoes.add(mapearDoacao(rs));

            return listaDoacoes;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter doações.", e);
        }
    }

    @Override
    public List<Doacao> findByDoador(Doador doador) {
        List<Doacao> listaDoacoes = new ArrayList<>();

        String sql = """
                SELECT d.id, d.data_doacao, d.doador_id,
                       do.nome, do.cpf, do.data_nascimento,
                       do.sexo, do.tipo_sanguineo, do.peso,
                       do.data_ultima_doacao
                FROM doacao d
                INNER JOIN doador do ON d.doador_id = do.id
                WHERE d.doador_id = ?
                """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, doador.getId());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next())
                    listaDoacoes.add(mapearDoacao(rs));
            }

            return listaDoacoes;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter doações do doador.", e);
        }
    }

    private Doacao mapearDoacao(ResultSet rs) throws SQLException {

        String dataUltimaDoacao = rs.getString("data_ultima_doacao");

        Doador doador = new Doador(
                rs.getInt("doador_id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                LocalDate.parse(rs.getString("data_nascimento")),
                Sexo.valueOf(rs.getString("sexo")),
                TipoSanguineo.valueOf(rs.getString("tipo_sanguineo")),
                rs.getDouble("peso"),
                dataUltimaDoacao != null
                        ? LocalDate.parse(dataUltimaDoacao)
                        : null
        );

        return new Doacao(rs.getInt("id"),
                LocalDate.parse(rs.getString("data_doacao")), doador);

    }
}
