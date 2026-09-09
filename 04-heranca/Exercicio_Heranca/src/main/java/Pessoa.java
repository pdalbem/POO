import java.util.Objects;

public sealed class Pessoa permits Proprietario, Mecanico {
    private String nome;

    @Override
    public String toString() {
        return "Nome=" + nome;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(getNome(), pessoa.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNome());
    }

    public Pessoa(String nome) {
        this.setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
