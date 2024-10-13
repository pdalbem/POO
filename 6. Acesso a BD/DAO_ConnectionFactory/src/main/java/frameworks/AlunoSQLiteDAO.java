package frameworks;

import interfaces.DAO;
import domain.Aluno;
import domain.Cidade;
import domain.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AlunoSQLiteDAO implements DAO<Aluno> {
    @Override
    public int save(Aluno a) {
        String sql = "INSERT INTO aluno (prontuario, nome, curso, cidade) values (?,?,?,?)";
        int generatedId=0;
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setString(1,a.getProntuario());
            stmt.setString(2,a.getNome());
            stmt.setInt(3,a.getCurso().getIdCurso());
            stmt.setInt(4, a.getCidade().getIdCidade());
            stmt.executeUpdate();

           ResultSet generatedKeys = stmt.getGeneratedKeys();
           if (generatedKeys.next())
                    generatedId= generatedKeys.getInt(1);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedId;
    }

    @Override
    public void update(Aluno a) {

        String sql = "UPDATE aluno SET prontuario=?, nome=?, curso=?, cidade=? WHERE idAluno=?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setString(1,a.getProntuario());
            stmt.setString(2,a.getNome());
            stmt.setInt(3,a.getCurso().getIdCurso());
            stmt.setInt(4, a.getCidade().getIdCidade());
            stmt.setInt(5,a.getIdAluno());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Aluno a) {
        String sql = "DELETE FROM aluno WHERE idAluno=?";

        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,a.getIdAluno());
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Aluno> findById(int idAluno) {
        String sql = "SELECT * FROM aluno WHERE idAluno=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Curso curso = new CursoSQLiteDAO().findById(rs.getInt("curso")).orElse(null);
                Cidade cidade = new CidadeSQLiteDAO().findById(rs.getInt("cidade")).orElse(null);
                Aluno a = new Aluno(rs.getInt("idAluno"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso, cidade);
                return Optional.of(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Aluno> findAll() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> listaAlunos=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new CursoSQLiteDAO().findById(rs.getInt("curso")).orElse(null);
                Cidade cidade = new CidadeSQLiteDAO().findById(rs.getInt("cidade")).orElse(null);
                Aluno a = new Aluno(rs.getInt("idAluno"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso,cidade);
                listaAlunos.add(a);
            }
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlunos;
    }
}
