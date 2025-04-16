import java.util.Objects;

public class Curso {
    private String nome;
    private String sigla;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(nome, curso.nome) && Objects.equals(sigla, curso.sigla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sigla);
    }

    public Curso(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
