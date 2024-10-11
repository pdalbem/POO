import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    static String url = "jdbc:sqlite:aula1.db";

    public static void main(String[] args) {
        apagarTabelas();
        criarTabelas();

        Curso c1 = new Curso(1, "Android");
        c1.save();

        Aluno a1 = new Aluno(1, "SC12345", "Maria", c1);
        a1.save();

        for (Curso c : Curso.findAll())
            System.out.println(c);

        for (Aluno a : Aluno.findAll())
            System.out.println(a);
    }


    public static void criarTabelas() {
        String createTableCurso = "CREATE TABLE IF NOT EXISTS curso" +
                "(idCurso INTEGER PRIMARY KEY," +
                "nome TEXT);";
        String createTableAluno = "CREATE TABLE IF NOT EXISTS aluno" +
                "(idAluno INTEGER PRIMARY KEY," +
                "prontuario TEXT," +
                "nome TEXT," +
                "curso INTEGER," +
                "FOREIGN KEY (curso) REFERENCES curso(idCurso));";

        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement stmt = con.prepareStatement(createTableCurso)) {
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement stmt = con.prepareStatement(createTableAluno)) {
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void apagarTabelas() {
        String apagarTabelaCurso = "DELETE FROM curso";
        String apagarTabelaAluno = "DELETE FROM aluno";

        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement stmt = con.prepareStatement(apagarTabelaAluno)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement stmt = con.prepareStatement(apagarTabelaCurso)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
