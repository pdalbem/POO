public class Main {
    public static void main(String[] args) {
        Quadrado quadrado = new Quadrado(5);
        quadrado.calcularArea();

        Circulo circulo = new Circulo(3);
        circulo.calcularArea();

        Cubo cubo = new Cubo(5);
        cubo.calcularArea();
        cubo.calcularVolume();

    }
}