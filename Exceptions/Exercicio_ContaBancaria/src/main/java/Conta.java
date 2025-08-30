public class Conta {
    private final String titular;
    private double saldo;

    public void sacar(double valor){
        if (valor>this.saldo)
            throw new SaldoInsuficienteException("ERRO: saldo insuficiente");
        if (valor<0)
            throw new ValorInvalidoException("ERRO: valor não pode ser negativo");
        this.saldo = this.saldo-valor;
    }

    public void depositar(double valor){
        if (valor<0)
            throw new ValorInvalidoException("ERRO: valor inválido");
        this.saldo = this.saldo+valor;
    }

    public void transferir(Conta conta, double valor){
        if (conta==null)
            throw new IllegalArgumentException("ERRO: conta não pode ser nula");
        if (valor>this.saldo)
            throw new SaldoInsuficienteException("ERRO: saldo insuficiente");
        if (valor<0)
            throw new ValorInvalidoException("ERRO: valor não pode ser negativo");

        this.saldo = this.saldo - valor;
        conta.saldo = conta.saldo + valor;
    }

    public Conta(String titular, double saldo) {
        if (titular==null || titular.isBlank())
            throw new IllegalArgumentException("ERRO: titular não pode ser nulo");
        if (saldo<0)
            throw new ValorInvalidoException("ERRO: saldo não pode ser negativo");

        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

}
