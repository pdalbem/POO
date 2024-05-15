package data;

import model.Cidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CidadeSQLiteDAO implements DAO<Cidade>{
    @Override
    public void save(Cidade c) {
        String sql = "INSERT INTO cidade values (?,?)";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, c.getIdCidade());
            stmt.setString(2, c.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Cidade c) {

        String sql = "UPDATE cidade SET nome=? WHERE idCidade=?";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){

            stmt.setString(1,c.getNome());
            stmt.setInt(2,c.getIdCidade());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cidade c) {
        String sql = "DELETE FROM cidade WHERE idCidade=?";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,c.getIdCidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cidade findById(int codCid) {
        Cidade c=null;
        String sql = "SELECT * FROM cidade WHERE idCidade=?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,codCid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
                c = new Cidade(rs.getInt("idCidade"), rs.getString("nome"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Cidade> findAll() {
        String sql = "SELECT * FROM cidade";
        List<Cidade> listaCursos =new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cidade c = new Cidade(rs.getInt("idCidade"), rs.getString("nome"));
                listaCursos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCursos;
    }
}
