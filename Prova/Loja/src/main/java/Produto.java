public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(int id, String nome, double preco, int quantidadeEstoque) {
        if(preco <= 0)
            throw new IllegalArgumentException("Preço deve ser valor positivo");

        if (quantidadeEstoque <= 0)
            throw new IllegalArgumentException("Quantidade deve ser valor positivo");

        this.id = id;
        setNome(nome);
        setPreco(preco);
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void adicionarEstoque(int qtd) {
        this.quantidadeEstoque += qtd;
    }

    public void removerEstoque(int qtd) {
        this.quantidadeEstoque -= qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}
