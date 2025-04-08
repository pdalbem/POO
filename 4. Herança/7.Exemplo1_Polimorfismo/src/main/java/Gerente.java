import java.util.Objects;

public class Gerente extends Funcionario{
    private int qtdProjetos;

    @Override
    public double calcularBonus() {
        return getSalario()*.10 + (1000*this.qtdProjetos);
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Qtd. de projetos: "+ this.qtdProjetos);
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "qtdProjetos=" + qtdProjetos +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Gerente gerente)) return false;
        if (!super.equals(o)) return false;
        return getQtdProjetos() == gerente.getQtdProjetos();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getQtdProjetos());
    }

    public Gerente(String nome, double salario, int qtdProjetos) {
        super(nome, salario);
        this.setQtdProjetos(qtdProjetos);
    }

    public int getQtdProjetos() {
        return qtdProjetos;
    }

    public void setQtdProjetos(int qtdProjetos) {
        this.qtdProjetos = qtdProjetos;
    }
}
