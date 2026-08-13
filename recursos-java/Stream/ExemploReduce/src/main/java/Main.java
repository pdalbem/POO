import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(10, 20, 30, 40);

        int soma = numeros.stream()
                .reduce(0, Integer::sum);

        System.out.println("Soma: " +soma);

        Optional<Integer> maior = numeros.stream()
                .reduce((a, b) -> a > b ? a : b);
        maior.ifPresent(valor -> System.out.println("Maior valor: " + valor));

        Produto p1 = new Produto("Smartwatch", 2000);
        Produto p2 = new Produto("Laptop", 4000);
        Produto p3 = new Produto("Smartphone", 3000);
        Produto p4 = new Produto("Tablet", 1200);
        List<Produto> produtos = List.of(p1, p2, p3, p4);

        Produto maisCaro = produtos.stream()
                .reduce((prod1, prod2) ->
                        prod1.getPreco() > prod2.getPreco() ? prod1 : prod2)
                .orElse(null);

        System.out.println("Mais caro: "+ maisCaro);
    }
}
