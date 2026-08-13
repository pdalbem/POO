import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("123", "Maria");
        //upcasting
        Conta corrente = new Corrente("123", 200, cliente);
        Conta poupanca = new Poupanca("456", 500, cliente);

        corrente.sacar(50);
        System.out.println("Saldo da CC: " + corrente.getSaldo());
        //método transferir aceita como parâmetro tanto obj conta como poupança.
        corrente.transferir(20, poupanca);
        System.out.println("Saldo da CC: " + corrente.getSaldo());
        System.out.println("Saldo da Poupança: " + poupanca.getSaldo());
        }
}