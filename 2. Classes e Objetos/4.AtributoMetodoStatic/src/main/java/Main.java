public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro("ABC1234","VW","Amarok", 2020);
        Carro carro2 = new Carro("XYZ5678", "Jeep", "Compass");

        int quantidade = Carro.getQuantidadeCarros(); //chamada do método static
        System.out.println("Quantide de objetos Carro: " + quantidade);

    }
}
