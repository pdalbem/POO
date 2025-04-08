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
