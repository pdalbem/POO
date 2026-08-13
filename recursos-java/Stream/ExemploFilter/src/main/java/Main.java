import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(pares);

        Produto p1 = new Produto("Smartwatch", 2000);
        Produto p2 = new Produto("Laptop", 4000);
        Produto p3 = new Produto("Smartphone", 3000);
        Produto p4 = new Produto("Tablet", 1200);
        List<Produto> produtos = List.of(p1, p2, p3, p4);

        List<Produto> produtosPrecoAcima2000 = produtos.stream()
                .filter(p -> p.getPreco() > 2000)
                .toList();
        System.out.println("Produtos: " + produtosPrecoAcima2000);
    }
}
