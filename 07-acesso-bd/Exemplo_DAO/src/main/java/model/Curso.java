package model;

public class Curso {
    private final int id;
    private String nome;

    public Curso(String nome) {
      setNome(nome);
      this.id = 0;
    }

    public Curso(int id, String nome) {
        setNome(nome);
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome do curso não pode ser nulo ou em branco");

        this.nome = nome;
    }
}
