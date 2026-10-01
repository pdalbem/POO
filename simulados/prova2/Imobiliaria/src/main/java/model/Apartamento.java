package model;

public class Apartamento extends Imovel{
    private String nomeEdificio;
    private int andar;

    private static final double PERCENTUAL_SEGURO_APTO = 0.10;

    @Override
    public void exibirInfo() {
       super.exibirInfo();
        System.out.println("Edifício: " + this.getNomeEdificio());
        System.out.println("Andar: " + this.getAndar());
    }

    public Apartamento(String endereco, double valorAluguel, Proprietario proprietario, String nomeEdificio, int andar) {
        super(endereco, valorAluguel, proprietario);
        this.nomeEdificio = nomeEdificio;
        this.andar = andar;
    }

    public String getNomeEdificio() {
        return nomeEdificio;
    }

    public int getAndar() {
        return andar;
    }

    public void setNomeEdificio(String nomeEdificio) {
        this.nomeEdificio = nomeEdificio;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }


    @Override
    public double calcularValorSeguro() {
        return this.getValorAluguel() * PERCENTUAL_SEGURO_APTO;
    }
}