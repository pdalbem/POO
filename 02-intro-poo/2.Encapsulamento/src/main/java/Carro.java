public class Carro {
    private  String placa;
    private  String marca;
    private  String modelo;
    private int anoFabricacao;

    public Carro(String placa, String marca, String modelo, int anoFabricacao) {
        this.setPlaca(placa);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setAnoFabricacao(anoFabricacao);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa==null || placa.isBlank())
            throw new IllegalArgumentException("Placa não pode ter valor nulo ou vazio");

        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    private void setMarca(String marca) {
        if (marca==null || marca.isBlank())
            throw new IllegalArgumentException("Marca não pode ter valor nulo ou vazio");
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        if (modelo==null || modelo.isBlank())
            throw new IllegalArgumentException("Modelo não pode ter valor nulo ou vazio");
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    private void setAnoFabricacao(int anoFabricacao) {
        if (anoFabricacao<2020)
            throw new IllegalArgumentException("Ano de fabricação não pode ser anterior a 2020");
        this.anoFabricacao = anoFabricacao;
    }
}
