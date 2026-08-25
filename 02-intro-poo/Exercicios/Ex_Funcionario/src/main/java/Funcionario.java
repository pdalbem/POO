public class Funcionario {
    private String nome;
    private double salario;

    public void reajustarSalario(float porcentagem){
        this.salario += this.salario * porcentagem /100;
    }

    public Funcionario() {
    }

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }


}
