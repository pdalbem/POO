import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Main{
    private static final String URL = "jdbc:sqlite:products.db";

    public static void main(String[] args) {
        databaseInitializer();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite o id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o preço: ");
            double preco = scanner.nextDouble();

            Product product = new Product(id,nome,preco);

            save(product);
            showProducts();

            System.out.print("Novo preço para " + product.getName() + ": ");
            preco = scanner.nextDouble();
            System.out.println("Atualizando preço");
            product.setPrice(preco);
            update(product);

            showProducts();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void databaseInitializer(){
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            String sql = """
                CREATE TABLE IF NOT EXISTS product (
                    id INTEGER PRIMARY KEY,
                    name TEXT NOT NULL,
                    price REAL NOT NULL
                )
                """;

            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao inicializar o banco de dados: " + e.getMessage());
        }
    }

    public static void save(Product product){
        String insertSql = "INSERT INTO product (id, name, price) VALUES (?, ?, ?)";
        try (Connection conn =  DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(insertSql)) {

            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setDouble(3, product.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    public static void update(Product product) {
        String updateSql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        try (Connection conn =  DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(updateSql)) {

            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public static void delete(Product product) {
        String deleteSql = "DELETE FROM product WHERE id = ?";
        try (Connection conn =  DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(deleteSql)) {

            stmt.setInt(1, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }

    public static Optional<Product> findById(int id) {
        String sql = "SELECT id, name, price FROM product WHERE id = ?";
        try (Connection conn =  DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    Product p = new Product(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price")
                    );
                    return Optional.of(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar por ID: " + e.getMessage());
        }
        return Optional.empty();
    }

    public static List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id, name, price FROM product";

        try (Connection conn =  DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos: " + e.getMessage());
        }

        return products;
    }

    public static void showProducts(){
        for (Product p : findAll())
            System.out.println(p);
    }

}
