package imobiliaria;

public class Apartamento extends Imovel{
    private String nomeEdificio;
    private int andar;

    @Override
    public void exibirInfo() {
        System.out.println("imobiliaria.Apartamento - Endereço: " + getEndereco() + ", Edifício: " + nomeEdificio + ", Andar: " + andar + ", Valor imobiliaria.Aluguel: " + getValorAluguel() + ", Alugado: " + estaAlugado());
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



}
