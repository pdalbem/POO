
package domain.entity;

public class Aluno {
    private int id;
    private String prontuario;
    private String nome;
    private Curso curso;
    private Cidade cidade;

    private void validarProntuario(String prontuario) {
        if (prontuario == null || prontuario.isBlank()) {
            throw new IllegalArgumentException("Prontuário não pode ser nulo ou em branco.");
        }
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do aluno não pode ser nulo ou em branco.");
        }
    }

    private void validarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("Curso não pode ser nulo.");
        }
    }

    private void validarCidade(Cidade cidade) {
        if (cidade == null) {
            throw new IllegalArgumentException("Cidade não pode ser nula.");
        }
    }

    public Aluno(String prontuario, String nome, Curso curso, Cidade cidade) {
        validarProntuario(prontuario);
        validarNome(nome);
        validarCurso(curso);
        validarCidade(cidade);

        this.prontuario = prontuario;
        this.nome = nome;
        this.curso = curso;
        this.cidade = cidade;
    }

    public Aluno(int id, String prontuario, String nome, Curso curso, Cidade cidade) {
        this(prontuario, nome, curso, cidade);
        this.id=id;
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

    public void setProntuario(String prontuario) {
        validarProntuario(prontuario);
        this.prontuario = prontuario;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public void setCurso(Curso curso) {
        validarCurso(curso);
        this.curso = curso;
    }

    public void setCidade(Cidade cidade) {
        validarCidade(cidade);
        this.cidade = cidade;
    }

    public void setId(int id) {
        this.id = id;
    }
}
