import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Curso {
    private int idCurso;
    private String nome;

    public void save() {
        String sql = "INSERT INTO curso (idCurso,nome) values (?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getIdCurso());
            stmt.setString(2, getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        String sql = "UPDATE curso SET nome=? WHERE idCurso=?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getNome());
            stmt.setInt(2, getIdCurso());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String sql = "DELETE FROM curso WHERE idCurso=?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getIdCurso());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Optional<Curso> findById(int param) {
        String sql = "SELECT * FROM curso WHERE idCurso=?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, param);
            final ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Curso c = new Curso(rs.getInt("idCurso"), rs.getString("nome"));
                return Optional.of(c);
            }
        }catch(SQLException e)
    {
        e.printStackTrace();
    }
   return Optional.empty();
}

    public static List<Curso> findAll(){
        String sql = "SELECT * FROM curso";
        List<Curso> listaCursos =new ArrayList<>();
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
        {
            while (rs.next()) {
                Curso c = new Curso(rs.getInt("idCurso"), rs.getString("nome"));
                listaCursos.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCursos;
    }

    @Override
    public String toString() {
        return  "idCurso=" + idCurso +
                ", nome='" + nome + '\'' ;
    }

    public Curso(int idCurso, String nome) {
        this.setIdCurso(idCurso);
        this.setNome(nome);
    }

        public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
