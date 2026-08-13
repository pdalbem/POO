public sealed class Funcionario extends  Pessoa permits Professor,FuncAdm{
    private double salario;

    public Funcionario(String nome, int idade, String endereco, double salario) {
        super(nome, idade, endereco);
        this.setSalario(salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
