public class Corrente extends Conta{

    public Corrente(String numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
    }

    //é cobrada uma taxa de $ 5.00
    @Override
    public void sacar(double valor) {
        this.setSaldo(this.getSaldo() - valor - 5);
    }

    public void cobrarTaxa(double valor){
        this.setSaldo(this.getSaldo()- valor);
    }
}
