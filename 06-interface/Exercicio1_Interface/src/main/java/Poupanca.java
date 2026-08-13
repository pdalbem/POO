public class Poupanca extends Conta{
    private double rendimentoMensal;


    public Poupanca(String descricao, Cliente cliente, String numero, double saldo, double rendimentoMensal) {
        super(descricao, cliente, numero, saldo);
        this.rendimentoMensal = rendimentoMensal;
    }

    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void setRendimentoMensal(double rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }

    @Override
    public void exibirInfo() {
        System.out.println("\nDescricao: "+getDescricao()
                            + "\n Cliente: " +getCliente().getNome()
                            + "\n Numero da conta: " + getNumero()
                            + "\n Saldo: " + getSaldo()
                            + "\n Rendimento: " + getRendimentoMensal());
    }
}
