import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitializer {
    private static final String URL = "jdbc:sqlite:produtos.db";

    public static void init() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            String sql = """
                CREATE TABLE IF NOT EXISTS produto (
                    id INTEGER PRIMARY KEY,
                    nome TEXT NOT NULL,
                    preco REAL NOT NULL
                );
                """;

            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println("Erro ao inicializar o banco de dados: " + e.getMessage());
        }
    }

}
