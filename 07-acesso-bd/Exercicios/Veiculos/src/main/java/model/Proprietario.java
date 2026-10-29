package model;

public class Proprietario {
    private final int id;
    private String nome;

    public Proprietario(String nome) {
        setNome(nome);
        this.id = 0;
    }

    public Proprietario(int id, String nome) {
        setNome(nome);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Proprietario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome==null || nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser nulo.");

        this.nome = nome;
    }
}
