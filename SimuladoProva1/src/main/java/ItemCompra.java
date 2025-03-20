public class ItemCompra {
    final private Produto produto;  //pode ser final
    final private int quantidadeComprada; //pode ser final
    private double valorTotal;

    //pode ser privado, será usado pelo construtor apenas
    private void calcularValorTotal(){
        this.valorTotal = produto.getPrecoUnitario()*quantidadeComprada;
    }

    // Vou deixar para tratar a exceção na Main.
    // Por isso não coloquei try-catch aqui
    public ItemCompra(Produto produto, int quantidadeComprada) {
       if (produto==null)
           throw new IllegalArgumentException("Item da compra não pode ser null");
       if (quantidadeComprada<=0)
           throw new IllegalArgumentException("Quantidade não pode ser zero ou negativa");

        produto.reduzirEstoque(quantidadeComprada);
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
        calcularValorTotal();
    }

    // Repare que classe só possui métodos get. Os setters foram omitidos para evitar inconsistências

    public Produto getProduto() {
        return produto;
    }


    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }


    public double getValorTotal() {
        return valorTotal;
    }
}
