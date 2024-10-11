import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Aluno {
    private int idAluno;
    private String prontuario;
    private String nome;
    private Curso curso;

    public void save() {
        String sql = "INSERT INTO aluno (idAluno,prontuario,nome,curso) values (?,?,?,?)";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getIdAluno());
            stmt.setString(2, getProntuario());
            stmt.setString(3, getNome());
            stmt.setInt(4, getCurso().getIdCurso());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        String sql = "UPDATE aluno SET prontuario=?, nome=?, curso=? WHERE idAluno=?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getProntuario());
            stmt.setString(2, getNome());
            stmt.setInt(3, getCurso().getIdCurso());
            stmt.setInt(4, getIdAluno());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void delete() {
        String sql = "DELETE FROM aluno WHERE idAluno=?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getIdAluno());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Optional<Aluno> findById(int param) {
        String sql = "SELECT * FROM aluno WHERE idAluno=?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, param);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Optional<Curso> curso = Curso.findById(rs.getInt("curso"));

                Aluno a = new Aluno(
                        rs.getInt("idAluno"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        curso.orElse(null));
                return Optional.of(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static List<Aluno> findAll() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> listaAlunos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:aula1.db");
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Optional<Curso> cursoOptional = Curso.findById(rs.getInt("curso"));
                Aluno a = new Aluno(
                        rs.getInt("idAluno"),
                        rs.getString("prontuario"),
                        rs.getString("nome"),
                        cursoOptional.orElse(null) );
                listaAlunos.add(a);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return  listaAlunos;
    }

    @Override
    public String toString() {
        return "idAluno=" + idAluno +
                ", prontuario='" + prontuario + '\'' +
                ", nome='" + nome + '\'' +
                ", curso=" + curso.getNome();
    }

    public Aluno(int idAluno, String prontuario, String nome, Curso curso) {
        this.idAluno = idAluno;
        this.prontuario = prontuario;
        this.nome = nome;
        this.curso = curso;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
