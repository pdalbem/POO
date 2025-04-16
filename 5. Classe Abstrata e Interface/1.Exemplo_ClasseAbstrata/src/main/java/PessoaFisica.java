public class PessoaFisica extends Pessoa {
    private String cpf;
    private String nome;

    public PessoaFisica(String endereco, String telefone, String email, String cpf, String nome) {
        super(endereco, telefone, email);
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                "} " + super.toString();
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

    public boolean validarCPF() {
        //código para validar CPF
        return false;
    }
}
