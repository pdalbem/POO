public class Quadrado implements IFiguraPlana{
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public void calcularArea() {
        double area = Math.pow(lado,2);
        System.out.println("Área: " + area);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
