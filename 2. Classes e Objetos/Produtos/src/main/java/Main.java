public class Main {

    public static void main(String[] args) {

        // Utilizando o construtor padrão
        Produto mouse = new Produto();
        mouse.setNome("Mouse");

        if (mouse.alimentarEstoque(10, 115.00f))
            System.out.println("Operação realizada com sucesso");
        else
            System.out.println("Erro ao atualizar");

        // Utilizando o construtor com parâmetros
        Produto smartphone = new Produto("Smartphone", 3500.00f, 15);

        // Reajuste de preço
        System.out.println("\nReajuste de preço");
        if (smartphone.reajustarPreco(10))
            System.out.println("Novo preço: R$ " + smartphone.getPreco());
        else
            System.out.println("Reajuste inválido");

        // Exemplo de reajuste inválido
        if (!smartphone.reajustarPreco(80))
            System.out.println("Não é permitido reajuste superior a 50%");



        // Baixa de estoque
        System.out.println("\nBaixa de estoque ");

        if (smartphone.baixarEstoque(2))
            System.out.println("Baixa  realizada com sucesso");
        else
            System.out.println("Estoque insuficiente");

        System.out.println("Estoque atual: " + smartphone.getEstoque());

        // Sobrecarga do método baixarEstoque()
        if (smartphone.baixarEstoque())
            System.out.println("Baixa de 1 unidade realizada com sucesso");

        System.out.println("Após vender uma unidade:");
        System.out.println("Estoque: " + smartphone.getEstoque());

         // Tentando vender mais do que existe
        if (!smartphone.baixarEstoque(100))
            System.out.println("Estoque insuficiente");


        // Alimentando o estoque
        System.out.println("\nAlimentação de estoque");

        smartphone.alimentarEstoque(5);

        System.out.println("Estoque após reposição: "
                + smartphone.getEstoque());

        // Alimentando estoque e alterando o preço
        smartphone.alimentarEstoque(10, 3200);

        System.out.println("Novo estoque: " + smartphone.getEstoque());
        System.out.println("Novo preço: R$ " + smartphone.getPreco());


        // Método static
        System.out.println("Quantidade de objetos criados: "
                + Produto.getContadorObjetos());
    }
}