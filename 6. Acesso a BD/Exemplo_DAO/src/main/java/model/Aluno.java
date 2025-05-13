
package model;

public class Aluno {
    private int id;
    private String prontuario;
    private String nome;
    private Curso curso;
    private Cidade cidade;

    public Aluno(String prontuario, String nome, Curso curso, Cidade cidade) {
        this.setProntuario(prontuario);
        this.setNome(nome);
        this.setCurso(curso);
        this.setCidade(cidade);
    }

    public Aluno(int id, String prontuario, String nome, Curso curso, Cidade cidade) {
        this.setId(id);
        this.setProntuario(prontuario);
        this.setNome(nome);
        this.setCurso(curso);
        this.setCidade(cidade);
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
