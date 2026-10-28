package model;

public class Aluno {
    private final int id;
    private String prontuario;
    private String nome;
    private Curso curso;

     public Aluno(String prontuario, String nome, Curso curso) {
        this.id = 0;
        setNome(nome);
        setProntuario(prontuario);
        setCurso(curso);
    }

    public Aluno(int id, String prontuario, String nome, Curso curso) {
        this.id=id;
        setNome(nome);
        setProntuario(prontuario);
        setCurso(curso);
    }

    public int getId() {
        return id;
    }

    public String getProntuario() {
        return prontuario;
    }

    public String getNome() {
        return nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setProntuario(String prontuario) {
        if (prontuario == null || prontuario.isBlank())
            throw new IllegalArgumentException("Prontuário não pode ser nulo ou em branco.");

        this.prontuario = prontuario;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome do aluno não pode ser nulo ou em branco.");

        this.nome = nome;
    }

    public void setCurso(Curso curso) {
        if (curso == null)
            throw new IllegalArgumentException("Curso não pode ser nulo.");

        this.curso = curso;
    }
}
