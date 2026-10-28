
package data.dao;

import data.db.SQLiteConnectionFactory;
import exception.EntityAlreadyExistsException;
import model.Aluno;
import model.Curso;

import java.sql.*;
import java.util.*;

public class AlunoDAOImpl implements AlunoDAO {
    @Override
    public Aluno save(Aluno aluno) {
        String sqlInsert = "INSERT INTO aluno (prontuario, nome, curso_id) VALUES (?, ?, ?)";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, aluno.getProntuario());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getCurso().getId());
            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next())
                    return new Aluno(rs.getInt(1), aluno.getProntuario(), aluno.getNome(), aluno.getCurso());
                throw new RuntimeException("Erro ao obter ID");
            }

        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE"))
                throw new EntityAlreadyExistsException("Prontuário já existe: " + aluno.getProntuario());

            throw new RuntimeException("Erro ao cadastrar aluno.", e);
        }
    }

    @Override
    public int update(Aluno aluno) {
        String sqlUpdate = "UPDATE aluno SET prontuario = ?, nome = ?, curso_id = ? WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlUpdate)) {

            stmt.setString(1, aluno.getProntuario());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getCurso().getId());
            stmt.setInt(4, aluno.getId());
            return stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno.", e);
        }
    }


    @Override
    public int delete(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir aluno.", e);
        }
    }

    @Override
    public Optional<Aluno> findById(int id) {
        String sql= """
        SELECT
            aluno.id,
            aluno.prontuario,
            aluno.nome,
            aluno.curso_id,
            curso.nome AS curso_nome
        FROM aluno
        INNER JOIN curso ON aluno.curso_id = curso.id
        WHERE aluno.id = ?
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    Curso curso = new Curso(
                            rs.getInt("curso_id"),
                            rs.getString("curso_nome")
                    );

                    Aluno aluno = new Aluno(
                            rs.getInt("id"),
                            rs.getString("prontuario"),
                            rs.getString("nome"),
                            curso);

                    return Optional.of(aluno);
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter aluno.", e);
        }
    }



    @Override
    public List<Aluno> findAll() {
        String sql= """
        SELECT
            aluno.id,
            aluno.prontuario,
            aluno.nome,
            aluno.curso_id,
            curso.nome AS curso_nome
        FROM aluno
        INNER JOIN curso ON aluno.curso_id = curso.id
        """;

        List<Aluno> listaAlunos = new ArrayList<>();

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("curso_id"),
                        rs.getString("curso_nome")
                );

                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso
                );

                listaAlunos.add(aluno);
            }
            return listaAlunos;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter alunos.", e);
        }
    }


    @Override
    public Optional<Aluno> findByProntuario(String prontuario) {
        String sql= """
        SELECT
            aluno.id,
            aluno.prontuario,
            aluno.nome,
            aluno.curso_id,
            curso.nome AS curso_nome
        FROM aluno
        INNER JOIN curso ON aluno.curso_id = curso.id
        WHERE aluno.prontuario = ?
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, prontuario);
            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    Curso curso = new Curso(rs.getInt("curso_id"), rs.getString("curso_nome"));

                    Aluno aluno = new Aluno(
                            rs.getInt("id"),
                            rs.getString("prontuario"),
                            rs.getString("nome"),
                            curso );

                    return Optional.of(aluno);

                }
                return Optional.empty();

            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter alunos.", e);
        }
    }
}
