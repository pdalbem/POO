
package domain.entity;

public class Curso {
    private int id;
    private String nome;


    public Curso(String nome) {
        setNome(nome);
    }

    public Curso(int id, String nome) {
        setId(id);
        setNome(nome);
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do curso não pode ser nulo ou em branco");
        }
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }
}
