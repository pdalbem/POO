public class Vinho extends Bebida{
    private String uva;
    private String paisOrigem;


    public Vinho(String descricao, double preco, int quantidadeEstoque, String uva, String paisOrigem) {
        super(descricao, preco, quantidadeEstoque);
        this.setUva(uva);
        this.setPaisOrigem(paisOrigem);
    }

    public String getUva() {
        return uva;
    }

    public void setUva(String uva) {
        this.uva = uva;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    @Override
    public String obterDados() {
        return "\n Descrição: "+getDescricao()
                +"\n Preço: " + getPreco()
                +"\n Estoque: "+getQuantidadeEstoque()
                + "\n Uva: " + getUva()
                + "\n País: "+getPaisOrigem();
    }
}
