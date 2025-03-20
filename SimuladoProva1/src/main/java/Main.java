import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // por ora, deixe todo  o codigo dentro do try-catch
        try {
            Vendedor vendedor = new Vendedor("1010","Joaquim");
            Cliente cliente = new Cliente("123.456.789-10", "José");

            Categoria eletronico = new Categoria("Eletrônicos");
            Categoria eletrodomestico = new Categoria("Eletrodomésticos");

            Produto smartphone = new Produto("Smartphone",1500.00, 10,eletronico);
            Produto smarttv = new Produto("Smart TV", 3000.00, 15,eletronico);
            Produto geladeira = new Produto("Geladeira", 5000.00, 7, eletrodomestico);

            /////////////////
            /// Compra 1
            /////////////////

            Compra compra1 = new Compra("001", LocalDate.of(2025,3,20),cliente,vendedor);

            cliente.incluirCompra(compra1);

            ItemCompra itemCompra1 = new ItemCompra(smartphone,2);
            compra1.adicionarItemCompra(itemCompra1);
            compra1.adicionarItemCompra(geladeira,1); // outra forma de adicionar à lista. Veja classe ItemCompra e a sobrecarga de metodo

            /////////////////
            /// Compra 2
            /////////////////
            Compra compra2 = new Compra("002", LocalDate.of(2025,2,10),cliente,vendedor);
            cliente.incluirCompra(compra2);
            compra2.adicionarItemCompra(smarttv,1);

            /////////////////
            /// Consultando compras do cliente em determinado período
            /////////////////
            LocalDate inicio = LocalDate.of(2025,2,1);
            LocalDate fim = LocalDate.of(2025,3,31);
            System.out.print("Compras do(a) cliente " + cliente.getNome()+" realizadas entre "+inicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                                                                           +" e "+fim.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            cliente.exibirHistoricoCompras(inicio,fim);

            /////////////////
            /// Exibindo os itens comprados na comprados na compra1
            /////////////////

            System.out.println("\nDados da compra "+ compra1.getNumeroCompra());
            System.out.println("Cliente: "+compra1.getCliente().getNome());
            Iterator<ItemCompra> it =compra1.iterator();
            while (it.hasNext()){
                ItemCompra item=it.next();
                System.out.println("Produto: "+item.getProduto().getDescricao()+ " - Qtd: "+item.getQuantidadeComprada() + " - Valor: "+item.getValorTotal());
            }

            /////////////////
            /// Estoque atualizado
            /////////////////
            System.out.println("\nEstoque atualizado");
            System.out.println(smartphone.getDescricao()+": "+smartphone.getEstoque());
            System.out.println(smarttv.getDescricao()+": " + smarttv.getEstoque());
            System.out.println(geladeira.getDescricao()+": "+geladeira.getEstoque());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
