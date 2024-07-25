public class Poupanca extends Conta{
    public Poupanca(String numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
    }
    @Override
    public void sacar(double valor) {
        this.setSaldo(this.getSaldo() - valor);
    }

    public void aplicarRendimento(double taxa){
        this.setSaldo(this.getSaldo() * (1+taxa));
    }
}
