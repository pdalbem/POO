package domain.entity;

public class Proprietario {
    private int id;
    private String nome;

    public void validarNome(String nome){
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou em branco.");
        }
    }

    public Proprietario(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public Proprietario(int id, String nome) {
        this(nome);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Proprietario{id=" + id + ", nome='" + nome + "'}";
    }
}
