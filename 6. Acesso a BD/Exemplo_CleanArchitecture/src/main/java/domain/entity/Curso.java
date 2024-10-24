package domain.entity;

public class Curso {
    private int idCurso;
    private String nome;

    @Override
    public String toString() {
        return "\nidCurso=" + idCurso +
                "\nNome=" + nome ;

    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public Curso(int idCurso, String nome) {
        this.idCurso = idCurso;
        this.nome = nome;
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
