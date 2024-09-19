public class Produto {
    private String descricao;
    private double precoUnitario;

    public Produto(String descricao, double precoUnitario) {
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
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


    public void mostrarDados() {
        System.out.println("\n Descrição: " + this.getDescricao()
                            + "\n Preço: " + this.getPrecoUnitario());
    }
}
