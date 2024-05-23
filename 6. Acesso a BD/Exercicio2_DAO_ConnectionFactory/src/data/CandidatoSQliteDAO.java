package data;
import model.Candidato;
import model.Cargo;
import model.Partido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatoSQliteDAO implements DAO<Candidato> {

    @Override
    public void save(Candidato candidato) {
        String sql = "INSERT INTO candidato(numero,nome,cargo,partido) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, candidato.getNumero());
            stmt.setString(2, candidato.getNome());
            stmt.setInt(3, candidato.getCargo().getIdCargo());
            stmt.setInt(4,candidato.getPartido().getNumero());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Candidato candidato) {
        String sql = "UPDATE candidato SET nome=?,partido=?,cargo=? WHERE numero = ?";
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setString(1,candidato.getNome());
            stmt.setInt(2,candidato.getPartido().getNumero());
            stmt.setInt(3,candidato.getCargo().getIdCargo());
            stmt.setInt(4,candidato.getNumero());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Candidato candidato) {

        String sql = "DELETE FROM candidato WHERE numero=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,candidato.getNumero());
            stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Candidato findById(int id) {

        String sql = "SELECT * FROM candidato WHERE numero=?";
        Candidato candidato =null;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Cargo cargo = new CargoSQliteDAO().findById(rs.getInt("cargo"));
                Partido partido = new PartidoSQliteDAO().findById(rs.getInt("partido"));
                candidato= new Candidato(rs.getInt("numero"),rs.getString("nome"),cargo,partido);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return candidato;
    }

    @Override
    public List<Candidato> findAll() {

        String sql = "SELECT * FROM candidato";
        List<Candidato> ListaCandidatos = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Partido partido = new PartidoSQliteDAO().findById(rs.getInt("partido"));
                Cargo cargo = new CargoSQliteDAO().findById(rs.getInt("cargo"));
                Candidato candidato= new Candidato(rs.getInt("numero"),rs.getString("nome"),cargo,partido);
                ListaCandidatos.add(candidato);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaCandidatos;
    }
}
