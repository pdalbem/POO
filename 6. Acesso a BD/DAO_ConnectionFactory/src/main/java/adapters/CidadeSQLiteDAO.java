package adapters;

import domain.Cidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CidadeSQLiteDAO implements DAO<Cidade> {
    @Override
    public int save(Cidade c) {
        String sql = "INSERT INTO cidade (nome) values (?)";
        int generatedId=0;
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, c.getNome());
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
    public Optional<Cidade> findById(int codCid) {
        String sql = "SELECT * FROM cidade WHERE idCidade=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, codCid);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cidade c = new Cidade(rs.getInt("idCidade"), rs.getString("nome"));
                return Optional.of(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
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
