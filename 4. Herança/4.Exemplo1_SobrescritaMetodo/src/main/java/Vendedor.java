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
