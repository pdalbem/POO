public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Joaquim", "222.222.222-22");
        Conta conta = new Conta("123456", 1500, cliente);

        System.out.println(cliente.getConta().getSaldo());
        System.out.println(conta.getCliente().getNome());
    }
}
