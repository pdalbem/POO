package data;
import model.Cargo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargoSQliteDAO implements DAO<Cargo>{
    @Override
    public void save(Cargo cargo) {
        String sql = "INSERT INTO cargo(idcargo,cargo) VALUES (?,?)";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,cargo.getIdCargo());
            stmt.setString(2,cargo.getCargo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cargo cargo) {
        String sql = "UPDATE cargo SET cargo=? WHERE idcargo = ?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setString(1,cargo.getCargo());
            stmt.setInt(2,cargo.getIdCargo());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cargo cargo) {
        String sql = "DELETE FROM cargo WHERE idcargo=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,cargo.getIdCargo());
            stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Cargo findById(int id) {
        String sql = "SELECT * FROM cargo WHERE idcargo=?";
        Cargo cargo = null;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                cargo = new Cargo(rs.getInt("idcargo"),rs.getString("cargo"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return cargo;
    }

    @Override
    public List<Cargo> findAll() {
        String sql = "SELECT * FROM cargo";
        List<Cargo> ListaCargos = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Cargo cargo = new Cargo(rs.getInt("idcargo"),rs.getString("cargo"));
                ListaCargos.add(cargo);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaCargos;
    }
}
