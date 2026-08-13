public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro("ABC1234","VW","Amarok", 2020);

        Carro carro2 = new Carro("XYZ5678", "Jeep", "Compass");
        carro2.setAnoFabricacao(2019);

        Carro carro3 = new Carro();

        System.out.println("Placa do carro: " + carro1.getPlaca());
        System.out.println("Marca do carro: " + carro1.getMarca());
        System.out.println("Modelo do carro: " + carro1.getModelo());
        System.out.println("Ano de fabricação: " + carro1.getAnoFabricacao());


    }
}
