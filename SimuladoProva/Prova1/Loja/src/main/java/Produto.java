public class Produto {
    private String descricao;
    private double precoUnitario;
    private int estoque;
    private Categoria categoria;

    public void reduzirEstoque(int qtd){
        if (qtd>this.estoque)
            throw  new IllegalArgumentException("Estoque insuficiente do produto "+this.descricao+": "+this.estoque);

        this.estoque-=qtd;
    }

    public Produto(String descricao, double precoUnitario, int estoque, Categoria categoria) {
        if (precoUnitario<=0)
            throw new IllegalArgumentException("Preço do produto "+ descricao+" não pode ser zero ou negativo");
        if (estoque<=0)
            throw new IllegalArgumentException("Estoque do produto "+ descricao+" não pode ser zero ou negativo");

        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
