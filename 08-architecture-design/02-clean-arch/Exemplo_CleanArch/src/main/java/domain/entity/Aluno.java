
package domain.entity;

public class Aluno {
    private int id;
    private String prontuario;
    private String nome;
    private Curso curso;
    private Cidade cidade;


    public Aluno(String prontuario, String nome, Curso curso, Cidade cidade) {
        setProntuario(prontuario);
        setNome(nome);
        setCurso(curso);
        setCidade(cidade);
    }

    public Aluno(int id, String prontuario, String nome, Curso curso, Cidade cidade) {
        this(prontuario, nome, curso, cidade);
        setId(id);
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
        if (prontuario == null || prontuario.isBlank()) {
            throw new IllegalArgumentException("Prontuário não pode ser nulo ou em branco.");
        }
        this.prontuario = prontuario;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do aluno não pode ser nulo ou em branco.");
        }
        this.nome = nome;
    }

    public void setCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("Curso não pode ser nulo.");
        }
        this.curso = curso;
    }

    public void setCidade(Cidade cidade) {
        if (cidade == null) {
            throw new IllegalArgumentException("Cidade não pode ser nula.");
        }
        this.cidade = cidade;
    }

    public void setId(int id) {
        this.id = id;
    }
}
