package com.example.bdjavafx.infra;

import com.example.bdjavafx.domain.model.Departamento;
import com.example.bdjavafx.domain.model.Funcionario;
import com.example.bdjavafx.domain.repository.FuncionarioRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncionarioRepositoryImpl implements FuncionarioRepository {
    @Override
    public void save(Funcionario f) {
        String sql = "INSERT INTO funcionario (cpf,nome, departamento) values (?,?,?)";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, f.getCpf());
            stmt.setString(2, f.getNome());
            stmt.setInt(3, f.getDepartamento().getId());// retorna o id do depto do funcionario, pois chave-estrangeira é int
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Funcionario f) {
        String sql = "UPDATE funcionario SET cpf=?, nome=?, departamento=? WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {

            stmt.setString(1, f.getCpf());
            stmt.setString(2, f.getNome());
            stmt.setInt(3, f.getDepartamento().getId());
            stmt.setInt(4, f.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Funcionario f) {
        String sql = "DELETE FROM funcionario WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, f.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Funcionario> findById(int id) {
        Funcionario funcionario = null;
        String sql = "SELECT f.id, f.cpf, f.nome, d.id AS dep_id, d.nome AS dep_nome, d.sigla AS dep_sigla " +
                "FROM funcionario f " +
                "LEFT JOIN departamento d ON f.departamento = d.id " +
                "WHERE f.id = ?";

        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Departamento dep = null;
                int depId = rs.getInt("dep_id");
                if (!rs.wasNull()) {
                    dep = new Departamento(depId, rs.getString("dep_nome"), rs.getString("dep_sigla"));
                }
                funcionario = new Funcionario(
                        rs.getInt("id"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        dep
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(funcionario);
    }


    @Override
    public List<Funcionario> findAll() {
        String sql = "SELECT f.id, f.cpf, f.nome, d.id AS dep_id, d.nome AS dep_nome, d.sigla AS dep_sigla " +
                "FROM funcionario f " +
                "LEFT JOIN departamento d ON f.departamento = d.id";

        List<Funcionario> listaFuncionarios = new ArrayList<>();

        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Departamento dep = null;
                int depId = rs.getInt("dep_id");
                if (!rs.wasNull()) {
                    dep = new Departamento(depId, rs.getString("dep_nome"), rs.getString("dep_sigla"));
                }

                Funcionario f = new Funcionario(
                        rs.getInt("id"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        dep
                );
                listaFuncionarios.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaFuncionarios;
    }

    public Optional<Funcionario> findByCPF(String cpf){
        Funcionario funcionario = null;
        String sql = "SELECT f.id, f.cpf, f.nome, d.id AS dep_id, d.nome AS dep_nome, d.sigla AS dep_sigla " +
                "FROM funcionario f " +
                "LEFT JOIN departamento d ON f.departamento = d.id " +
                "WHERE f.cpf = ?";

        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Departamento dep = null;
                int depId = rs.getInt("dep_id");
                if (!rs.wasNull()) {
                    dep = new Departamento(depId, rs.getString("dep_nome"), rs.getString("dep_sigla"));
                }
                funcionario = new Funcionario(
                        rs.getInt("id"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        dep
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(funcionario);
    }


}