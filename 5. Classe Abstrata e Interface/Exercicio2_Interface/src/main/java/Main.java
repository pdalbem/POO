public class Main {
    public static void main(String[] args) {
        Quadrado quadrado = new Quadrado(5);
        System.out.println("Área do quadrado: "+quadrado.calcularArea());
        System.out.println("Perímetro do quadrado: "+quadrado.calcularPerimetro());

        Circulo circulo = new Circulo(3);
        System.out.println("Área do círculo: "+circulo.calcularArea());
        System.out.println("Perímetro do círculo: "+circulo.calcularPerimetro());

        Cubo cubo = new Cubo(5);
        System.out.println("Área do cubo: "+cubo.calcularArea());
        System.out.println("Volume do cubo: "+cubo.calcularVolume());

    }
}