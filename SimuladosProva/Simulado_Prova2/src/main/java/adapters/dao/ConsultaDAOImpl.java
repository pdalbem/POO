package adapters.dao;

import adapters.ConnectionFactory;
import domain.entity.Consulta;
import domain.entity.Medico;
import domain.entity.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsultaDAOImpl implements ConsultaDAO{
    @Override
    public List<Consulta> findByPaciente(Paciente paciente) {
        String sql = "SELECT * FROM consulta where paciente=?";
        List<Consulta> listaConsultas=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
           stmt.setInt(1,paciente.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Medico medico = new MedicoDAOImpl().findById(rs.getInt("medico")).orElse(null);
                Consulta consulta = new Consulta(rs.getInt("id"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        paciente, medico);
                listaConsultas.add(consulta);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaConsultas;
    }

    @Override
    public int save(Consulta consulta) {
        String sql = "INSERT INTO consulta (data, hora, paciente, medico) values (?,?,?,?)";
        int generatedId=0;
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setString(1,consulta.getData());
            stmt.setString(2,consulta.getHora());
            stmt.setInt(3,consulta.getPaciente().getId());
            stmt.setInt(4, consulta.getMedico().getId());
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
    public Optional<Consulta> findById(int id) {
        String sql = "SELECT * FROM consulta WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Paciente paciente = new PacienteDAOImpl().findById(rs.getInt("paciente")).orElse(null);
                Medico medico = new MedicoDAOImpl().findById(rs.getInt("medico")).orElse(null);
                Consulta consulta = new Consulta(rs.getInt("id"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        paciente, medico);
                return Optional.of(consulta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Consulta> findAll() {
        String sql = "SELECT * FROM consulta";
        List<Consulta> listaConsultas=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Paciente paciente = new PacienteDAOImpl().findById(rs.getInt("paciente")).orElse(null);
                Medico medico = new MedicoDAOImpl().findById(rs.getInt("medico")).orElse(null);
                Consulta consulta = new Consulta(rs.getInt("id"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        paciente, medico);
                listaConsultas.add(consulta);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaConsultas;
    }
}
