import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente("222222222-22", "Joaquim");

            Produto p1 = new Produto("Laptop", 3000, 10);
            Produto p2 = new Produto("Smartphone", 2500, 15);
            Produto p3 = new Produto("Smartwatch", 1500, 20);

            Pedido pedido = new Pedido("PED001",cliente, LocalDate.now());
            pedido.adicionarItem(p1, 2);
            pedido.adicionarItem(p2, 2);
            pedido.adicionarItem(p3, 1);
            pedido.confirmarPedido();

            System.out.println("Valor total da venda: "+ pedido.getValorTotal());

            System.out.println("Estoque após venda: ");
            System.out.println(p1.getNome() + ": " + p1.getQuantidadeEstoque());
            System.out.println(p2.getNome() + ": " + p1.getQuantidadeEstoque());
            System.out.println(p2.getNome() + ": " + p1.getQuantidadeEstoque());

            System.out.println("Pedidos do cliente " + cliente.getNome());
            Iterator<Pedido> pedidoIterator = cliente.obterPedidos(LocalDate.of(2026,8,1), LocalDate.now());
            while (pedidoIterator.hasNext()) {
                Pedido ped =  pedidoIterator.next();
                System.out.println("Número: "+ ped.getNumero());
                System.out.println("Data: "+ ped.getData());
                System.out.println("Produtos neste pedido:");
                Iterator<ItemPedido> itemPedidoIterator = ped.iterator();
                while (itemPedidoIterator.hasNext()) {
                    ItemPedido itemPed =  itemPedidoIterator.next();
                    System.out.println("Nome: "+itemPed.getProduto().getNome()+ "Qtd: "+ itemPed.getQuantidadeComprada());
                }
            }

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
}
