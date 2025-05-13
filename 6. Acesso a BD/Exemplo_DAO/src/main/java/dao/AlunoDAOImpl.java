
package dao;

import db.SQLiteConnectionFactory;
import exception.EntityAlreadyExistsException;
import exception.EntityNotFoundException;
import model.Aluno;
import model.Curso;
import model.Cidade;

import java.sql.*;
import java.util.*;

public class AlunoDAOImpl implements AlunoDAO {
    @Override
    public void save(Aluno aluno) {
        String sqlInsert = "INSERT INTO aluno (prontuario, nome, curso_id, cidade_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, aluno.getProntuario());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getCurso().getId());
            stmt.setInt(4, aluno.getCidade().getId());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                aluno.setId(generatedKeys.getInt(1));


        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE")) {
                throw new EntityAlreadyExistsException("Prontuário já existe: " + aluno.getProntuario());
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Aluno aluno) {
        String sqlUpdate = "UPDATE aluno SET prontuario = ?, nome = ?, curso_id = ?, cidade_id = ? WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlUpdate)) {

            stmt.setString(1, aluno.getProntuario());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getCurso().getId());
            stmt.setInt(4, aluno.getCidade().getId());
            stmt.setInt(5, aluno.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void delete(Aluno aluno) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Aluno> findById(int id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int cursoId = rs.getInt("curso_id");
                int cidadeId = rs.getInt("cidade_id");

                CursoDAO cursoDAO = new CursoDAOImpl();
                CidadeDAO cidadeDAO = new CidadeDAOImpl();

                Curso curso = cursoDAO.findById(cursoId)
                        .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado (ID: " + cursoId + ")"));
                Cidade cidade = cidadeDAO.findById(cidadeId)
                        .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada (ID: " + cidadeId + ")"));

                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso, cidade
                );

                return Optional.of(aluno);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public Iterator<Aluno> findAll() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            CursoDAO cursoDAO = new CursoDAOImpl();
            CidadeDAO cidadeDAO = new CidadeDAOImpl();

            while (rs.next()) {
                int cursoId = rs.getInt("curso_id");
                int cidadeId = rs.getInt("cidade_id");

                Curso curso = cursoDAO.findById(cursoId)
                        .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado (ID: " + cursoId + ")"));
                Cidade cidade = cidadeDAO.findById(cidadeId)
                        .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada (ID: " + cidadeId + ")"));

                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso, cidade
                );

                alunos.add(aluno);
            }

            return alunos.iterator();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<Aluno> findByProntuario(String prontuario) {
        String sql = "SELECT * FROM aluno WHERE prontuario = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, prontuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int cursoId = rs.getInt("curso_id");
                int cidadeId = rs.getInt("cidade_id");

                CursoDAO cursoDAO = new CursoDAOImpl();
                CidadeDAO cidadeDAO = new CidadeDAOImpl();

                Curso curso = cursoDAO.findById(cursoId)
                        .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado (ID: " + cursoId + ")"));
                Cidade cidade = cidadeDAO.findById(cidadeId)
                        .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada (ID: " + cidadeId + ")"));

                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso, cidade
                );

                return Optional.of(aluno);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
