import java.time.LocalDate;

public class Turma {
    private String codigo;
    private LocalDate inicio;
    private LocalDate termino;
    private Curso curso;
    private Instrutor instrutor;

    public Turma(String codigo, LocalDate inicio, LocalDate termino, Curso curso, Instrutor instrutor) {
        this.codigo = codigo;
        this.inicio = inicio;
        this.termino = termino;
        this.curso = curso;
        this.instrutor = instrutor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
}
