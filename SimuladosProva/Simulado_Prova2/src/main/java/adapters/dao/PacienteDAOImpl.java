package adapters.dao;

import adapters.ConnectionFactory;
import domain.entity.Especialidade;
import domain.entity.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacienteDAOImpl implements PacienteDAO{
    @Override
    public int save(Paciente paciente) {
        String sql = "INSERT INTO paciente (nome, telefone) values (?,?)";
        int generatedId = 0;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getTelefone());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                generatedId = generatedKeys.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedId;
    }

    @Override
    public Optional<Paciente> findById(int id) {
        String sql = "SELECT * FROM paciente WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Paciente paciente = new Paciente(rs.getInt("id"),
                                         rs.getString("nome"),rs.getString("telefone"));
                return Optional.of(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Paciente> findAll() {
        String sql = "SELECT * FROM paciente";
        List<Paciente> listaPacientes = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente(rs.getInt("id"),
                        rs.getString("nome"),rs.getString("telefone"));
                listaPacientes.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPacientes;
    }

}
