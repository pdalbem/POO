import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Categoria eletronicos = new Categoria("Eletrônicos");
        Categoria informatica = new Categoria("Informática");
        Categoria acessorios = new Categoria("Acessórios");

        List<Produto> produtos = List.of(
                new Produto("Monitor", 900.0, informatica),
                new Produto("Teclado", 150.0, acessorios),
                new Produto("Mouse", 80.0, acessorios),
                new Produto("Notebook", 3500.0, informatica),
                new Produto("Smartphone", 2500.0, eletronicos),
                new Produto("Fone", 200.0, eletronicos)
        );

        // groupingBy: agrupa produtos por categoria
        Map<Categoria, List<Produto>> porCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));

        porCategoria.forEach((categoria, listaProdutos) ->
                System.out.println(
                        categoria.getNome() + " -> "
                                + listaProdutos.size() + " produto(s)"
                ));

        System.out.println("---");

        // groupingBy + counting: quantidade de produtos por categoria
        Map<Categoria, Long> contagemPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(
                        Produto::getCategoria,
                        Collectors.counting()
                ));

        contagemPorCategoria.forEach((categoria, quantidade) ->
                System.out.println(
                        categoria.getNome() + " -> " + quantidade
                ));

        System.out.println("---");

        // joining: concatena os nomes dos produtos
        String nomes = produtos.stream()
                .map(Produto::getNome)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(nomes);

        System.out.println("---");

        // toMap: cria um Map nome -> preço
        Map<String, Double> precoPorNome = produtos.stream()
                .collect(Collectors.toMap(
                        Produto::getNome,
                        Produto::getPreco
                ));

        System.out.println(precoPorNome);

        System.out.println("---");

        // partitioningBy: separa produtos em caros (>= 500)
        // e baratos (< 500)
        Map<Boolean, List<Produto>> produtosPorPreco = produtos.stream()
                .collect(Collectors.partitioningBy(
                        produto -> produto.getPreco() >= 500
                ));

        System.out.println(
                "Caros: " +
                        produtosPorPreco.get(true)
                                .stream()
                                .map(Produto::getNome)
                                .toList()
        );

        System.out.println(
                "Baratos: " +
                        produtosPorPreco.get(false)
                                .stream()
                                .map(Produto::getNome)
                                .toList()
        );
    }
}
