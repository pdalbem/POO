import java.util.Objects;

public class Vendedor extends Funcionario{
    private double totalVendas;

    @Override
    public double calcularBonus() {
        return this.totalVendas*0.08;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Total de vendas: "+this.totalVendas);
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "totalVendas=" + totalVendas +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vendedor vendedor)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getTotalVendas(), vendedor.getTotalVendas()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTotalVendas());
    }

    public Vendedor(String nome, double salario, double totalVendas) {
        super(nome, salario);
        this.setTotalVendas(totalVendas);
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }
}
