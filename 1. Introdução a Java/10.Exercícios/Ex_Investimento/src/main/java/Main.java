import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Digite o valor do capital inicial: ");
        double capital = scanner.nextDouble();

        System.out.println("Digite a taxa em decimal: ");
        double taxa = scanner.nextDouble();

        System.out.println("Digite o tempo da aplicação: ");
        int tempo = scanner.nextInt();

        double montante = capital * Math.pow(1+taxa,tempo);
        System.out.printf("Montante acumulado: %.2f", montante);

    }
}
