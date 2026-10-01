package model;

public class Casa extends Imovel{
    private String quadra;
    private String lote;

    private static final double PERCENTUAL_SEGURO_CASA = 0.20;

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Quadra: " + this.getQuadra());
        System.out.println("Lote: " + this.getLote());
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


    @Override
    public double calcularValorSeguro() {
        return this.getValorAluguel() * PERCENTUAL_SEGURO_CASA;
    }
}