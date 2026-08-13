public class Funcionario {
    private String nome;
    private double salario;

    public double calcularBonus(){
        return salario*0.05;
    }

    public void exibirInfo(){
        System.out.println("\nNome: "+this.nome+
                           "\nSalário: "+this.salario);
    }

    public Funcionario(String nome, double salario) {
        this.setNome(nome);
        this.setSalario(salario);
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

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
