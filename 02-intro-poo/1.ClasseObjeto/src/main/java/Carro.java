import java.time.LocalDate;

public class Carro {
    String placa;
    String marca;
    String modelo;
    int anoFabricacao;

    public Carro() {
    }

    public Carro(String placa, String marca, String modelo, int anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    public Carro(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }
}
