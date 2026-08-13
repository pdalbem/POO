import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro("ABC1234","VW","Amarok", 2020);

        Carro carro2 = new Carro("XYZ5678", "Jeep", "Compass");
        carro2.anoFabricacao=2019;

        Carro carro3 = new Carro();

        System.out.println("Placa do carro: " + carro1.placa);
        System.out.println("Marca do carro: " + carro1.marca);
        System.out.println("Modelo do carro: " + carro1.modelo);
        System.out.println("Ano de fabricação do carro: " + carro1.anoFabricacao);

        //É possível ler os dados via teclado e passar para o construtor
        Scanner scanner=new Scanner(System.in);

        System.out.print("Digite a placa: ");
        String placa=scanner.nextLine();

        System.out.print("Digite a marca: ");
        String marca=scanner.nextLine();

        System.out.print("Digite o modelo: ");
        String modelo=scanner.nextLine();

        System.out.print("Digite o ano de fabricação: ");
        int ano=scanner.nextInt();

        Carro carro4 = new Carro(placa, marca,modelo,ano);



    }
}
