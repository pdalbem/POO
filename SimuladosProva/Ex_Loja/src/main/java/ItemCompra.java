public class ItemCompra {
    private Produto produto;
    private int quantidadeComprada;
    private double valorTotal;

    void calcularValorTotal(){

        this.valorTotal= this.quantidadeComprada * this.getProduto().getPrecoUnitario();
    }

    //ATENÇÃO NESTE CONSTRUTOR
    // Ele recebe apenas 2 parâmetros: produto e quantidade
    // o valorTotal é calculado automaticamente. Portanto, não passamos no construtor
    public ItemCompra(Produto produto, int quantidadeComprada) {
        this.produto = produto;
        this.quantidadeComprada = quantidadeComprada;
        calcularValorTotal();   // chama o método para calcular o valor total
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        calcularValorTotal();
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(int quantidadeComprada) {
        this.quantidadeComprada = quantidadeComprada;
        calcularValorTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    //ATENÇÃO: Não teremos o setValorTotal, pois não queremos
    // que o valor deste atributo seja modificado fora desta classe, o que poderia
    // gerar inconsistências
    /*public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }*/
}
