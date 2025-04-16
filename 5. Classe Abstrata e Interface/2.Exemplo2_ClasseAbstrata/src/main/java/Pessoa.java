public abstract class Pessoa { //Classe abstrata, não é possível instanciar objetos
    private String cpf;
    private String nome;

    //Método abstrato. As classes filhas concretas devem implementá-lo
    public abstract void exibirInfo();

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
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
