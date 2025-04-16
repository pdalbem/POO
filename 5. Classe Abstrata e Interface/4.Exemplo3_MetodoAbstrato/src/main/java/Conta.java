public abstract class Conta {
    private String numero;
    private double saldo;
    private Cliente cliente;

    //Conta Corrente e Poupança exibem comportamentos diferentes para saque
    public abstract void sacar(double valor);

    public void depositar(double valor){
        this.saldo = this.saldo + valor;
        //Outras formas de atribuição
        //this.saldo+=valor;
        //this.setSaldo(valor + this.getSaldo());
    }

    public void transferir(double valor, Conta conta ){
        if (valor <= this.saldo) {
            conta.saldo = conta.saldo + valor;
            this.saldo = this.saldo - valor;
        }else
        System.out.println("Saldo insuficiente");
    }

    public Conta(String numero, double saldo, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
