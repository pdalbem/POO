import java.time.LocalDate;

public class Carro {
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private static  int quantidadeCarros;

    public static int getQuantidadeCarros() {
        return quantidadeCarros;
    }


    //Sobrecarga de metodo no construtor
    public Carro(String placa, String marca, String modelo, int anoFabricacao) {
        this.setPlaca(placa);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAnoFabricacao(anoFabricacao);
        quantidadeCarros++;  // a cada novo obj, o contador é incrementad
    }

    public Carro(String placa, String marca, String modelo) {
        this.setPlaca(placa);
        this.setMarca(marca);
        this.setModelo(modelo);
        quantidadeCarros++; // a cada novo obj, o contador é incrementad
    }


    //Sobrecarga de metodo
    int calculaIdade(){
        return LocalDate.now().getYear() - getAnoFabricacao();
    }

    int calculaIdade(int anoReferencia){
        return anoReferencia - getAnoFabricacao();
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
