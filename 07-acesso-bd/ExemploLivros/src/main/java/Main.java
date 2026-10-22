import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:sqlite:livros.db";

    public static void main(String[] args) {
        inicializarDatabase();

        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); //limpar buffer
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        Livro livro = new Livro(id, titulo, preco);
        save(livro);

        System.out.println("Livros cadastrados: ");
        for (Livro liv : findAll())
            System.out.println(liv);
    }

    public static List<Livro> findAll(){
        List<Livro> listaLivros = new ArrayList<>();
        String sql = "SELECT * FROM livro";

        try(Connection conn = DriverManager.getConnection(URL);
           PreparedStatement stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery()){

          while (rs.next()){
              Livro livro = new Livro(rs.getInt("id"),
                                      rs.getString("titulo"),
                                      rs.getDouble("preco")  );
              listaLivros.add(livro);
          }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return listaLivros;
    }

    public static void save(Livro livro){
        String sql = "INSERT INTO livro (id,titulo,preco) VALUES (?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, livro.getId());
            stmt.setString(2, livro.getTitulo());
            stmt.setDouble(3, livro.getPreco());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void inicializarDatabase(){
        try(Connection conn = DriverManager.getConnection(URL);
            Statement st = conn.createStatement()){

            String sql = """
                    CREATE TABLE IF NOT EXISTS livro 
                    (
                     id INTEGER PRIMARY KEY,
                     titulo TEXT,
                     preco REAL
                    )
                    """;
            st.execute(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
