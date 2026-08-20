package model;

public class Produto {
    private final String nome;
    private double precoUnitario;
    private int quantidadeEstoque;

    public void reajustarPreco(double novoPreco){
        if (novoPreco<0)
            throw new IllegalArgumentException("Preço não pode ser negativo");

        this.precoUnitario = novoPreco;
    }

    public void abastecerEstoque(int quantidade){
        if (quantidade<0)
            throw new IllegalArgumentException("Quantidade não pode ser negativa");

        this.quantidadeEstoque += quantidade;
    }

    public void baixarEstoque(int quantidade){
        if (quantidade<0)
            throw new IllegalArgumentException("Quantidade não pode ser negativa");

        if (quantidade > quantidadeEstoque)
            throw new IllegalArgumentException("Estoque insuficiente");

        this.quantidadeEstoque -= quantidade;
    }

    public Produto(String nome, double precoUnitario, int quantidadeEstoque) {
       if (nome==null || nome.isBlank())
           throw new IllegalArgumentException("Nome não pode ser nulo ou vazo");
       if (precoUnitario<0)
           throw new IllegalArgumentException("Preço não pode ser negativo");
       if (quantidadeEstoque<0)
           throw new IllegalArgumentException("Quantidade não pode ser negativa");

        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}
