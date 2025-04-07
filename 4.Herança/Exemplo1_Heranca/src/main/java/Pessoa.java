public class Pessoa {
    private String cpf;
    private String nome;

    public void validarCPF(){
        System.out.println("Validando o CPF "+ this.getCpf());
    }

    public Pessoa(String cpf, String nome) {
        this.setCpf(cpf);
        this.setNome(nome);
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
