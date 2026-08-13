import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Estabelecendo a conexão com o banco de dados
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/meubanco", "usuario", "senha");

            // Criando um Statement para executar a consulta SQL
            stmt = conn.createStatement();

            // Tentando executar uma consulta SQL que pode gerar uma SQLException
            String sql = "SELECT * FROM tabela_inexistente"; // Tabela inexistente para gerar erro
            ResultSet rs = stmt.executeQuery(sql);

            // Processando os resultados (não será alcançado, pois ocorre uma SQLException)
            while (rs.next()) {
                System.out.println("Dado: " + rs.getString("coluna"));
            }
        } catch (SQLException e) {
            // Capturando e tratando a SQLException
            System.out.println("Erro ao acessar o banco de dados: " + e.getMessage());
        } finally {
            // Fechando recursos no bloco finally
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}

