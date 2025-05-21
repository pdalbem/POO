
package adapter.repository;

import adapter.config.SQLiteConnectionFactory;
import domain.entity.Curso;
import domain.repository.CursoRepository;

import java.sql.*;
import java.util.*;

public class CursoRepositoryImpl implements CursoRepository {
    @Override
    public void save(Curso curso) {
        String sqlInsert = "INSERT INTO curso (nome) VALUES (?)";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, curso.getNome());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                curso.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar curso: " + e.getMessage());
        }
    }

    @Override
    public void update(Curso curso) {
        String sqlUpdate = "UPDATE curso SET nome = ? WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlUpdate)) {
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar curso: " + e.getMessage());
        }
    }



    @Override
    public void delete(Curso curso) {
        String sql = "DELETE FROM curso WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, curso.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar curso: " + e.getMessage());
        }
    }

    @Override
    public Optional<Curso> findById(int id) {
        String sql = "SELECT * FROM curso WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                return Optional.of(new Curso(rs.getInt("id"), rs.getString("nome")));

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar curso por ID: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cursos.add(new Curso(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar todos os cursos: " + e.getMessage());
        }
        return cursos.iterator();
    }

    @Override
    public Iterator<Curso> findByName(String name) {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso WHERE nome LIKE ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cursos.add(new Curso(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar curso por nome: " + e.getMessage());
        }
        return cursos.iterator();
    }

}
