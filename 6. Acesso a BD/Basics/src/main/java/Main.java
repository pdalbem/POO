import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


public class Main{
    public static void main(String[] args) {
        DatabaseInitializer.init();

        try {
            Produto produto = new Produto(1, "laptop", 3000);
            save(produto);
            System.out.println("Produto inserido com sucesso!");

            Iterator<Produto> it = findAll();
            while (it.hasNext()) {
                Produto next =  it.next();
                System.out.println(next);
            }

            System.out.println("Atualizando preço do produto");
            produto.setPreco(3500);
            update(produto);

            it = findAll();
            while (it.hasNext()) {
                Produto next =  it.next();
                System.out.println(next);
            }

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void save(Produto produto){
        String insertSql = "INSERT INTO produto (id, nome, preco) VALUES (?, ?, ?)";
        try (Connection conn =  DriverManager.getConnection("jdbc:sqlite:produtos.db");
             PreparedStatement stmt = conn.prepareStatement(insertSql)) {

            stmt.setInt(1,produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public static void update(Produto produto) {
        String updateSql = "UPDATE produto SET nome = ?, preco = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:produtos.db");
             PreparedStatement stmt = conn.prepareStatement(updateSql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public static void delete(Produto produto) {
        String deleteSql = "DELETE FROM produto WHERE id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:produtos.db");
             PreparedStatement stmt = conn.prepareStatement(deleteSql)) {

            stmt.setInt(1, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }

    public static Optional<Produto> findById(int id) {
        String sql = "SELECT id, nome, preco FROM produto WHERE id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:produtos.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco")
                );
                return Optional.of(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar por ID: " + e.getMessage());
        }
        return Optional.empty();
    }

    public static Iterator<Produto> findAll() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT id, nome, preco FROM produto";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:produtos.db");
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco")
                );
                produtos.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos: " + e.getMessage());
        }

        return produtos.iterator();
    }

}
