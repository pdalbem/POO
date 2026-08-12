public class Funcionario {
    private String nome;
    private String cpf;
    private Cidade cidade;

    public Funcionario(String nome, String cpf, Cidade cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
        this.cidade.adicionarFuncionario(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
