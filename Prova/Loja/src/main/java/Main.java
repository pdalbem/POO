import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Produto prod1 = new Produto(1, "Laptop", 3500, 10);
        Produto prod2 = new Produto(2, "SmartTV", 2500, 5);

        Cliente cliente1 = new PessoaFisica(1, "Rua A", "Maria", "12345678910");

        Pedido pedido1 = new Pedido(1, LocalDate.now(), cliente1);
        pedido1.adicionarProduto(prod1);
        pedido1.adicionarProduto(prod2);

        pedido1.finalizarPedido();

        Iterator<Pedido> it = cliente1.obterPedidos();
        System.out.println(cliente1.obterDados());
        while(it.hasNext()) {
            Pedido p = it.next();
            System.out.println(p.obterDados());
        }
        System.out.println("Tributos do pedido1: "+ pedido1.calcularTributo());
    }
}
