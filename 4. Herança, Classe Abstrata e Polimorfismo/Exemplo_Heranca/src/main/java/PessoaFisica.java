import java.util.Objects;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private String nome;


    //Implementação do método abstrato mostrarDados()
    @Override
    public void mostrarDados() {
        System.out.println("\n CPF: " + cpf
                + "\n Nome: " + nome
                + "\n E-mail: " + getEmail());
    }


    public PessoaFisica(String endereco, String telefone, String email, String cpf, String nome) {
        super(endereco, telefone, email);
        this.cpf = cpf;
        this.nome = nome;
    }

    public PessoaFisica(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
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
