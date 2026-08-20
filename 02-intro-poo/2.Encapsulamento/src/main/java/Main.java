public class Main {
    public static void main(String[] args) {
       try {
           Carro carro1 = new Carro("ABC1234", "VW", "Amarok", 2020);
           carro1.setPlaca("ABC5555");

           System.out.println("Placa do carro: " + carro1.getPlaca());
           System.out.println("Marca do carro: " + carro1.getMarca());
           System.out.println("Modelo do carro: " + carro1.getModelo());
           System.out.println("Ano de fabricação: " + carro1.getAnoFabricacao());
       } catch (IllegalArgumentException e) {
           System.out.println(e.getMessage());;
       }
    }
}
