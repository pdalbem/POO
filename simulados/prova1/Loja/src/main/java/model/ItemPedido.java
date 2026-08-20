package model;

public class ItemPedido {
    private final Produto produto;
    private final int quantidadeComprada;
    private final double subtotal;

    //Esta classe é a "parte" da composição Pedido-ItemPedido
    //Seu ciclo de vida deve ser gerenciado pela classe Pedido

    //Construtor sem modificador de visibilidade. Só é acessado por classes dentro do mesmo package
    //Por isso criamos o package model e colocamos as classes de domínio dentro dele
    //Assim, a classe Main não conseguirá instanciar ItemPedido
    ItemPedido(Produto produto, int quantidadeComprada) {
        if (produto==null)
            throw new IllegalArgumentException("Produto não pode ser nulo");

        if (quantidadeComprada<=0)
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");

        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
        this.subtotal = produto.getPrecoUnitario() * quantidadeComprada;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
