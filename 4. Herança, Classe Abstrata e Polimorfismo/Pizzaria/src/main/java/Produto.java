public abstract class Produto {
    private String descricao;
    private double preco;

    public abstract String obterDados();

    public Produto(String descricao, double preco) {
        this.setDescricao(descricao);
        this.setPreco(preco);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
