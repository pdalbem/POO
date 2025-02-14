public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro("ABC1234","VW","Amarok", 2020);

        Carro carro2 = new Carro("XYZ5678", "Jeep", "Compass");
        carro2.setAnoFabricacao(2019);

        Carro carro3 = new Carro();

        System.out.println("Idade do carro no ano atual: " +carro1.calculaIdade());
        System.out.println("Idade do carro em 2024: "+ carro1.calculaIdade(2023));

    }
}
