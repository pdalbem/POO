
package data.dao;

import data.db.SQLiteConnectionFactory;
import model.Curso;

import java.sql.*;
import java.util.*;

public class CursoDAOImpl implements CursoDAO {
    @Override
    public Curso save(Curso curso) {
        String sqlInsert = "INSERT INTO curso (nome) VALUES (?)";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, curso.getNome());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next())
                    return new Curso(rs.getInt(1), curso.getNome());
                throw new RuntimeException("Erro ao obter ID");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar curso.", e);
        }
    }


    @Override
    public int update(Curso curso) {
        String sqlUpdate = "UPDATE curso SET nome = ? WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlUpdate)) {
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getId());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar curso.", e);
        }
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM curso WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir curso.", e);
        }
    }

    @Override
    public Optional<Curso> findById(int id) {
        String sql = "SELECT * FROM curso WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next())
                    return Optional.of(new Curso(rs.getInt("id"), rs.getString("nome")));
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter curso.", e);
        }
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> listaCursos = new ArrayList<>();
        String sql = "SELECT * FROM curso";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery() ) {

             while (rs.next())
                    listaCursos.add(new Curso(rs.getInt("id"), rs.getString("nome")));

            return listaCursos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter cursos.", e);
        }
    }

    @Override
    public List<Curso> findByNome(String nome) {
        List<Curso> listaCursos = new ArrayList<>();
        String sql = "SELECT * FROM curso WHERE nome LIKE ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");

            try(ResultSet rs = stmt.executeQuery()) {
                while (rs.next())
                    listaCursos.add(new Curso(rs.getInt("id"), rs.getString("nome")));
            }
            return listaCursos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter cursos.", e);
        }
    }
}
