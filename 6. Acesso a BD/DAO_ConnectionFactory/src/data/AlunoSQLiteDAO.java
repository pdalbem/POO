package data;

import model.Aluno;
import model.Cidade;
import model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AlunoSQLiteDAO implements DAO<Aluno>{
    @Override
    public void save(Aluno a) {
        String sql = "INSERT INTO aluno values (?,?,?,?,?)";

        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,a.getIdAluno());
            stmt.setString(2,a.getProntuario());
            stmt.setString(3,a.getNome());
            stmt.setInt(4,a.getCurso().getIdCurso());
            stmt.setInt(5, a.getCidade().getIdCidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public Aluno findById(int idAluno) {
        String sql = "SELECT * FROM aluno WHERE idAluno=?";
        Aluno a=null;
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,idAluno);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new CursoSQLiteDAO().findById(rs.getInt("curso"));
                Cidade cidade = new CidadeSQLiteDAO().findById(rs.getInt("cidade"));
                a = new Aluno(rs.getInt("idAluno"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso,cidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Aluno> findAll() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> listaAlunos=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new CursoSQLiteDAO().findById(rs.getInt("curso"));
                Cidade cidade = new CidadeSQLiteDAO().findById(rs.getInt("cidade"));
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
