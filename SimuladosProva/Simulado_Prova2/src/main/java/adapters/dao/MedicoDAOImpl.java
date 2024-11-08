package adapters.dao;

import adapters.ConnectionFactory;
import domain.entity.Especialidade;
import domain.entity.Medico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicoDAOImpl implements MedicoDAO{
    @Override
    public List<Medico> findByEspecialidade(Especialidade especialidade) {
        String sql = "SELECT * FROM medico where especialidade=?";
        List<Medico> listaMedicos=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setInt(1, especialidade.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                 Medico medico = new Medico(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("numCRM"), especialidade);
                listaMedicos.add(medico);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMedicos;
    }

    @Override
    public int save(Medico medico) {
        String sql = "INSERT INTO medico (nome, numCRM, especialidade) values (?,?,?)";
        int generatedId=0;
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            stmt.setString(1,medico.getNome());
            stmt.setString(2,medico.getNumCRM());
            stmt.setInt(3,medico.getEspecialidade().getId());
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
    public Optional<Medico> findById(int id) {
        String sql = "SELECT * FROM medico WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Especialidade especialidade = new EspecialidadeDAOImpl().findById(rs.getInt("especialidade")).orElse(null);
                Medico medico = new Medico(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("numCRM"), especialidade);
                return Optional.of(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Medico> findAll() {
        String sql = "SELECT * FROM medico";
        List<Medico> listaMedicos=new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Especialidade especialidade = new EspecialidadeDAOImpl().findById(rs.getInt("especialidade")).orElse(null);
                Medico medico = new Medico(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("numCRM"), especialidade);
                listaMedicos.add(medico);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMedicos;
    }
}
