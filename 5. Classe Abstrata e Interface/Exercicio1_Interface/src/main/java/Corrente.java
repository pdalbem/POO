public class Corrente extends Conta implements ITributavel{
    private double limiteDisponivel;

    public Corrente(String descricao, Cliente cliente, String numero, double saldo, double limiteDisponivel) {
        super(descricao, cliente, numero, saldo);
        this.limiteDisponivel = limiteDisponivel;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    @Override
    public void exibirInfo() {
        System.out.println("\nDescricao: "+getDescricao()
                + "\n Cliente: " +getCliente().getNome()
                + "\n Numero da conta: " + getNumero()
                + "\n Saldo: " + getSaldo()
                + "\n Limite: " + getLimiteDisponivel());
    }

    @Override
    public void calcularTributo() {
        System.out.println("Tributo: " + getSaldo()*0.05);
    }
}
