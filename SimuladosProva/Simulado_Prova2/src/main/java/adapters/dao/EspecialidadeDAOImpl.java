package adapters.dao;

import adapters.ConnectionFactory;
import domain.entity.Especialidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EspecialidadeDAOImpl implements EspecialidadeDAO{
    @Override
    public void update(Especialidade especialidade) {
        String sql = "UPDATE especialidade SET descricao=? WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, especialidade.getDescricao());
            stmt.setInt(2, especialidade.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Especialidade especialidade) {
        String sql = "DELETE FROM especialidade WHERE id=?";

        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, especialidade.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Especialidade especialidade) {
        String sql = "INSERT INTO especialidade (descricao) values (?)";
        int generatedId = 0;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, especialidade.getDescricao());
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
    public Optional<Especialidade> findById(int id) {
        String sql = "SELECT * FROM especialidade WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Especialidade especialidade = new Especialidade(rs.getInt("id"),
                                                          rs.getString("descricao"));
                return Optional.of(especialidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Especialidade> findAll() {
        String sql = "SELECT * FROM especialidade";
        List<Especialidade> listaEspecialidades = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Especialidade especialidade = new Especialidade(rs.getInt("id"),
                        rs.getString("descricao"));
                listaEspecialidades.add(especialidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEspecialidades;
    }
}
