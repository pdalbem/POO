package data;

import model.Departamento;
import model.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioSQLIteDAO implements DAO<Funcionario>{

    @Override
    public void save(Funcionario f) {
        String sql="insert into funcionario(id,cpf, nome,departamento) values (?,?,?,?)";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1,f.getId());
            stmt.setString(2,f.getCpf());
            stmt.setString(3,f.getNome());
            stmt.setInt(4,f.getDepartamento().getId());
            stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Funcionario f) {
        String sql = "update funcionario set nome=?, cpf=?, departamento=? where id=?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setInt(3, f.getDepartamento().getId());
            stmt.setInt(4,f.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Funcionario f) {
        String sql="delete from funcionario where id=?";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,f.getId());
            stmt.executeUpdate();
        }catch (SQLException e)
        {e.printStackTrace();}
    }

    @Override
    public Funcionario findById(int id) {
        Funcionario f=null;
        String sql="Select * from funcionario where id=?";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs= stmt.executeQuery();
            while (rs.next()){
                Departamento d=new DepartamentoSQLiteDAO().findById(rs.getInt("departamento"));
                f=new Funcionario(rs.getInt("id"), rs.getString("cpf"),
                                 rs.getString("nome"),d);
            }
        }catch (SQLException e){e.printStackTrace();}


        return f;
    }

    @Override
    public List<Funcionario> findAll() {
        List<Funcionario> lista=new ArrayList<>();
        String sql="Select * from funcionario";
        try(PreparedStatement stmt=ConnectionFactory.createStatement(sql)){
            ResultSet rs= stmt.executeQuery();
            while (rs.next()){
                Departamento d=new DepartamentoSQLiteDAO().findById(rs.getInt("departamento"));
                Funcionario f=new Funcionario(rs.getInt("id"), rs.getString("cpf"),
                        rs.getString("nome"),d);
                lista.add(f);
            }
        }catch (SQLException e){e.printStackTrace();}


        return lista;
    }
}
