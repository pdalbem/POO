package data.dao;

import data.db.SQLiteConnectionFactory;
import exception.EntityAlreadyExistsException;
import model.Doador;
import model.Sexo;
import model.TipoSanguineo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DoadorDAOImpl implements DoadorDAO {
    @Override
    public Doador save(Doador doador) {
        String sql = """
                INSERT INTO doador
                (nome, cpf, data_nascimento, sexo, tipo_sanguineo,
                 peso, data_ultima_doacao)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, doador.getNome());
            stmt.setString(2, doador.getCpf());
            stmt.setString(3, doador.getDataNascimento().toString());
            stmt.setString(4, doador.getSexo().name());
            stmt.setString(5, doador.getTipoSanguineo().name());
            stmt.setDouble(6, doador.getPeso());
            stmt.setString(7,
                    doador.getDataUltimaDoacao() != null
                            ? doador.getDataUltimaDoacao().toString()
                            : null
            );

            // comando acima é o mesmo que:
           /*  if (doador.getDataUltimaDoacao() != null)
                stmt.setString(7, doador.getDataUltimaDoacao().toString());
            else
                stmt.setString(7, null);*/

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {

                    return new Doador(
                            rs.getInt(1),
                            doador.getNome(),
                            doador.getCpf(),
                            doador.getDataNascimento(),
                            doador.getSexo(),
                            doador.getTipoSanguineo(),
                            doador.getPeso(),
                            doador.getDataUltimaDoacao()
                    );
                }

                throw new RuntimeException("Erro ao obter ID");
            }

        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE"))
                throw new EntityAlreadyExistsException("CPF já cadastrado: " + doador.getCpf());

            throw new RuntimeException("Erro ao cadastrar doador.", e);
        }

    }

    @Override
    public List<Doador> findAll() {
        List<Doador> listaDoadores = new ArrayList<>();

        String sql = "SELECT * FROM doador";

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next())
                listaDoadores.add(mapearDoador(rs));


            return listaDoadores;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter doadores.", e);
        }
    }

    @Override
    public int update(Doador doador) {
        String sql = """
            UPDATE doador
            SET peso = ?, data_ultima_doacao = ?
            WHERE id = ?
            """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, doador.getPeso());

            if (doador.getDataUltimaDoacao() != null)
                stmt.setString(2, doador.getDataUltimaDoacao().toString());
            else
                stmt.setString(2, null);

            stmt.setInt(3, doador.getId());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar doador.", e);
        }

    }

    @Override
    public List<Doador> findByTipoSanguineo(TipoSanguineo tipoSanguineo) {
        List<Doador> listaDoadores = new ArrayList<>();

        String sql = "SELECT * FROM doador WHERE tipo_sanguineo = ?";

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

           stmt.setString(1, tipoSanguineo.name());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next())
                    listaDoadores.add(mapearDoador(rs));
            }

            return listaDoadores;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter doadores.", e);
        }
    }



    @Override
    public List<Doador> findDoadoresAptos() {
        List<Doador> listaDoadoresAptos = new ArrayList<>();
        String sql = """
                SELECT * FROM doador
                WHERE data_ultima_doacao IS NULL
                   OR (sexo = 'MASCULINO'  AND data_ultima_doacao <= ?)
                   OR (sexo = 'FEMININO'   AND data_ultima_doacao <= ?)
                """;
        LocalDate hoje = LocalDate.now();
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hoje.minusDays(60).toString());
            ps.setString(2, hoje.minusDays(90).toString());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next())
                    listaDoadoresAptos.add(mapearDoador(rs));
            }
            return listaDoadoresAptos;
        }catch (SQLException e){
            throw new RuntimeException("Erro ao obter doadores aptos.", e);
        }
    }


    private Doador mapearDoador(ResultSet rs) throws SQLException {
        String dataUltimaDoacao = rs.getString("data_ultima_doacao");

        return new Doador(
                rs.getInt("id"),
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
    }

}
