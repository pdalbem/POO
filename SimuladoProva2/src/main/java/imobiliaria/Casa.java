package imobiliaria;

public class Casa extends Imovel{
    private String quadra;
    private String lote;

    @Override
    public void exibirInfo() {
        System.out.println("imobiliaria.Casa - Endereço: " + getEndereco() + ", Quadra: " + quadra + ", Lote: " + lote + ", Valor imobiliaria.Aluguel: " + getValorAluguel() + ", Alugado: " + estaAlugado());
    }

    public Casa(String endereco, double valorAluguel, Proprietario proprietario, String quadra, String lote) {
        super(endereco, valorAluguel, proprietario);
        this.quadra = quadra;
        this.lote = lote;
    }

    public String getQuadra() {
        return quadra;
    }

    public String getLote() {
        return lote;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }



}
