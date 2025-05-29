package com.example.bdjavafx.infra;

import com.example.bdjavafx.domain.model.Departamento;
import com.example.bdjavafx.domain.repository.DepartamentoRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartamentoRepositoryImpl implements DepartamentoRepository {
    @Override
    public void save(Departamento d) {
        String sql = "INSERT INTO departamento  (nome,sigla) values (?,?)";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getSigla());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Departamento d) {
        String sql = "UPDATE departamento SET nome=?, sigla=? WHERE id=?";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){

            stmt.setString(1,d.getNome());
            stmt.setString(2,d.getSigla());
            stmt.setInt(3,d.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Departamento d) {
        String sql = "DELETE FROM departamento WHERE id=?";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,d.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Departamento> findById(int id) {
        Departamento dep = null;
        String sql = "SELECT * FROM departamento WHERE id=?";

        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dep = new Departamento(rs.getInt("id"), rs.getString("nome"), rs.getString("sigla"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(dep);
    }


    @Override
    public List<Departamento> findAll() {
        String sql = "SELECT * FROM departamento";
        List<Departamento> listaDepartamentos = new ArrayList<>();

        try(PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Departamento d = new Departamento(rs.getInt("id"), rs.getString("nome"),rs.getString("sigla"));
                listaDepartamentos.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDepartamentos;
    }

    public Optional<Departamento> findBySigla(String sigla){
        Departamento dep = null;
        String sql = "SELECT * FROM departamento WHERE sigla=?";

        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, sigla);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dep = new Departamento(rs.getInt("id"), rs.getString("nome"), rs.getString("sigla"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(dep);
    }
}

