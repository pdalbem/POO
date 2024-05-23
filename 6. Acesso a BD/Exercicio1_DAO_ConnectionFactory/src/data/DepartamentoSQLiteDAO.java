package data;

import model.Departamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoSQLiteDAO implements DAO<Departamento> {

    @Override
    public void save(Departamento d) {
        String sql="insert into departamento(id,nome,sigla) values (?,?,?)";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)) {
           stmt.setInt(1,d.getId());
           stmt.setString(2,d.getNome());
           stmt.setString(3,d.getSigla());
           stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Departamento d) {
        String sql = "update departamento set nome=?, sigla=? where id=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getSigla());
            stmt.setInt(3, d.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Departamento d) {
        String sql="delete from departamento where id=?";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,d.getId());
            stmt.executeUpdate();
        }catch (SQLException e)
        {e.printStackTrace();}
    }

    @Override
    public Departamento findById(int id) {
        Departamento d=null;
        String sql="select * from departamento where id=?";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                d=new Departamento(rs.getInt("id"),
                                   rs.getString("nome"),
                                   rs.getString("sigla"));
            }

        }catch (SQLException e){e.printStackTrace();}

        return d;
    }

    @Override
    public List<Departamento> findAll() {
        List<Departamento> lista=new ArrayList<>();
        String sql="select * from departamento";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Departamento d=new Departamento(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("sigla"));
               lista.add(d);
            }

        }catch (SQLException e){e.printStackTrace();}

        return lista;
    }
}
