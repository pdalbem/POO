package data;
import model.Partido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidoSQliteDAO implements DAO<Partido>{
    @Override
    public void save(Partido partido) {
        String sql = "INSERT INTO partido(numero,nome,sigla) VALUES (?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,partido.getNumero());
            stmt.setString(2,partido.getNome());
            stmt.setString(3,partido.getSigla());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Partido partido) {
        String sql = "UPDATE partido SET nome=?,sigla=? WHERE numero = ?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setString(1,partido.getNome());
            stmt.setString(2,partido.getSigla());
            stmt.setInt(3,partido.getNumero());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Partido partido) {

        String sql = "DELETE FROM partido WHERE numero=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,partido.getNumero());
            stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Partido findById(int id) {
        String sql = "SELECT * FROM partido WHERE numero=?";
        Partido partido = null;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                partido = new Partido(rs.getInt("numero"),rs.getString("nome"),rs.getString("sigla"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return partido;
    }

    @Override
    public List<Partido> findAll() {
        String sql = "SELECT * FROM partido";
        List<Partido> ListaPartidos = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Partido partido = new Partido(rs.getInt("numero"),rs.getString("nome"),rs.getString("sigla"));
                ListaPartidos.add(partido);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaPartidos;
    }
}

