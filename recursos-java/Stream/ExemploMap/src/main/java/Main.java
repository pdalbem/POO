import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> nomes = List.of("Ana", "Bruno", "Carlos");

        List<String> maiusculos = nomes.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(maiusculos);

        Produto p1 = new Produto("Smartwatch", 2000);
        Produto p2 = new Produto("Laptop", 4000);
        Produto p3 = new Produto("Smartphone", 3000);
        Produto p4 = new Produto("Tablet", 1200);
        List<Produto> produtos = List.of(p1, p2, p3, p4);

        List<String> nomesProdutosPrecoAcima2000 = produtos.stream()
                .filter(p -> p.getPreco() > 2000)
                .map(Produto::getNome)
                .toList();
        System.out.println("Produtos: " + nomesProdutosPrecoAcima2000);

        double media = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .average()
                .orElse(0.0);

        System.out.printf("Média: R$ %.2f%n", media);

       
    }
}
