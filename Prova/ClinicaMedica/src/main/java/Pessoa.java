import java.util.Iterator;
import java.util.Objects;

public  abstract class Pessoa implements ExibeDados, IdentificacaoAutomatica {
    private final int id;
    private String cpf;
    private String nome;

    public Pessoa(String cpf, String nome) {
        this.id=gerarID();
        this.cpf = cpf;
        this.nome = nome;
    }

    public abstract Iterator<Consulta> obterConsultas();

    public abstract void incluirConsulta(Consulta consulta);

    public abstract void removerConsulta(Consulta consulta);

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pessoa pessoa)) return false;
        return getId() == pessoa.getId() && Objects.equals(getCpf(), pessoa.getCpf()) && Objects.equals(getNome(), pessoa.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCpf(), getNome());
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
