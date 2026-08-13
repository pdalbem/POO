public class Circulo implements IFiguraPlana{
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.pow(raio,2)* Math.PI;
    }

    @Override
    public double calcularPerimetro() {
        return 2*Math.PI*raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }


}
