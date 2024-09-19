public class Cerveja extends Bebida{
    private double teorAlcoolico;

    public Cerveja(String descricao, double preco, int quantidadeEstoque, double teorAlcoolico) {
        super(descricao, preco, quantidadeEstoque);
        this.setTeorAlcoolico(teorAlcoolico);
    }

    public double getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }


    @Override
    public String obterDados() {
        return "\n Descrição: "+getDescricao()
               +"\n Preço: " + getPreco()
                + "\n Teor: "+getTeorAlcoolico()
                +"\n Estoque: "+getQuantidadeEstoque();
    }
}
