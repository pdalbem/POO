import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // criei os mesmos produtos do exemplo do exercício
        Produto panela = new Produto("Panela", 50);
        Produto jogoCama = new Produto("Jogo de Cama", 150);
        Produto geladeira = new Eletronico("Geladeira", 5000, "110v");

        //Atenção no construtor do Cliente. Veja a classe Cliente
        Cliente cliente = new Cliente("123", "Maria", "9999-9999");

        Vendedor vendedor = new Vendedor("456","José", "101010");

        //Atenção nestes construtores. Veja a classe ItemCompra
        ItemCompra itemCompra1 = new ItemCompra(panela,2);
        ItemCompra itemCompra2 = new ItemCompra(jogoCama,1);
        ItemCompra itemCompra3 = new ItemCompra(geladeira,1);

        //Atenção neste construtor. Veja a classe Compra
        Compra compra = new Compra("001",
                                    LocalDate.of(2024,9,21),
                                    cliente,vendedor);
        compra.incluirItemCompra(itemCompra1,itemCompra2,itemCompra3);

        cliente.inserirCompras(compra); //faço o relacionamento do cliente com a compra

        cliente.exibirHistoricoCompras(LocalDate.of(2024,9,1),
                                       LocalDate.of(2024,9,30) );

    }
}