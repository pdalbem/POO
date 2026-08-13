import java.util.Objects;

public abstract class Funcionario {
    private String nome;
    private double salario;

    public abstract double calcularBonus(); //metodo abstrato

    public void exibirInfo(){
        System.out.println("\nNome: "+this.nome+
                           "\nSalário: "+this.salario);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Funcionario that)) return false;
        return Double.compare(getSalario(), that.getSalario()) == 0 && Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getSalario());
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
