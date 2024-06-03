package data;

import model.Partida;
import model.Time;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidaSQLiteDAO implements DAO<Partida>{

    @Override
    public void save(Partida partida) {
        String sql = "INSERT INTO partida (idPartida,dataJogo,time1,time2,placarTime1,placarTime2) VALUES (?,?,?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,partida.getIdPartida());
            stmt.setString(2, partida.getDataJogo());
            stmt.setInt(3, partida.getTime1().getIdTime());
            stmt.setInt(4, partida.getTime2().getIdTime());
            stmt.setInt(5, partida.getPlacarTime1());
            stmt.setInt(6, partida.getPlacarTime2());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Partida partida) {
        String sql = "UPDATE partida SET dataJogo=?,time1=?,time2=?,placarTime1=?,placarTime2=? WHERE idPartida=?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setString(1, partida.getDataJogo());
            stmt.setInt(2, partida.getTime1().getIdTime());
            stmt.setInt(3, partida.getTime2().getIdTime());
            stmt.setInt(4, partida.getPlacarTime1());
            stmt.setInt(5, partida.getPlacarTime2());
            stmt.setInt(6,partida.getIdPartida());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Partida partida) {
        String sql = "DELETE FROM partida WHERE idPartida=?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1, partida.getIdPartida());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Partida findById(int id) {
        String sql = "SELECT * FROM partida WHERE idPartida=?";
        Partida partida = null;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Time t1 = new TimeSQLiteDAO().findById(rs.getInt("time1"));
                Time t2 = new TimeSQLiteDAO().findById(rs.getInt("time2"));
                partida = new Partida(rs.getInt("idPartida"),
                                      rs.getString("dataJogo"),
                                        t1,t2,
                        rs.getInt("placarTime1"),
                        rs.getInt("placarTime2"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return partida;
    }

    @Override
    public List<Partida> findAll() {
        String sql = "SELECT * FROM partida";
        List<Partida> listaPartidas = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Time t1 = new TimeSQLiteDAO().findById(rs.getInt("time1"));
                Time t2 = new TimeSQLiteDAO().findById(rs.getInt("time2"));
                Partida partida = new Partida(rs.getInt("idPartida"),
                        rs.getString("dataJogo"),
                        t1,t2,
                        rs.getInt("placarTime1"),
                        rs.getInt("placarTime2"));
                listaPartidas.add(partida);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return listaPartidas;
    }
}
