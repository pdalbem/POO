public abstract class Pessoa implements SaidaFormatada {
    private String cpf;
    private String nome;
    private Cidade cidade;

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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Pessoa(String cpf, String nome, Cidade cidade) {
        this.cpf = cpf;
        this.nome = nome;
        this.cidade = cidade;
    }


}