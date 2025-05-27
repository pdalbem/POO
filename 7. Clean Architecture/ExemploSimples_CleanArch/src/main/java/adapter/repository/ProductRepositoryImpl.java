package adapter.repository;

import adapter.config.SQLiteConnectionFactory;
import domain.entity.Product;
import domain.repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public void save(Product product) {
        String sql = "INSERT INTO product (name, price) VALUES (?, ?)";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                product.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar produto: "+e.getMessage());
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: "+e.getMessage());
        }
    }

    @Override
    public void delete(Product product) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao remover produto: "+e.getMessage());
        }
    }

    @Override
    public Optional<Product> findById(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
                return Optional.of(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao encontrar produto por id: "+e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar todos os produtos: "+e.getMessage());
        }
        return products.iterator();
    }
}
