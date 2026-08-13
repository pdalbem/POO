import java.util.Objects;

public class Mecanico extends Pessoa{
    private double salario;

    @Override
    public String toString() {
        return super.toString() +
                ", Salario=" + salario;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Mecanico mecanico)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getSalario(), mecanico.getSalario()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSalario());
    }

    public Mecanico(String nome, double salario) {
        super(nome);
        this.setSalario(salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
