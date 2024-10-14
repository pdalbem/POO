package adapters;

import domain.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public  class CursoSQLiteDAO implements DAO<Curso> {

    @Override
     public  int save(Curso c) {
        String sql = "INSERT INTO curso (nome) values (?)";
        int generatedId=0;
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){
            stmt.setString(1,c.getNome());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                generatedId=generatedKeys.getInt(1);


        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  generatedId;
    }

    @Override
    public void update(Curso c) {
        String sql = "UPDATE curso SET nome=? WHERE idCurso=?";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){
            stmt.setString(1,c.getNome());
            stmt.setInt(2,c.getIdCurso());
            stmt.executeUpdate();
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Curso c) {
        String sql = "DELETE FROM curso WHERE idCurso=?";

        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,c.getIdCurso());
            stmt.executeUpdate();
        }
       catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Curso> findById(int codCur) {
        String sql = "SELECT * FROM curso WHERE idCurso=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, codCur);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Curso c = new Curso(rs.getInt("idCurso"), rs.getString("nome"));
                return Optional.of(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public List<Curso> findAll() {
        String sql = "SELECT * FROM curso";
        List<Curso> listaCursos =new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso c = new Curso(rs.getInt("idCurso"), rs.getString("nome"));
                listaCursos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCursos;
    }
}
