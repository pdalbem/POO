import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lendo os valores de X, V1, V2 e P
        System.out.print("Digite o valor de X (limite de km): ");
        double X = scanner.nextDouble();

        System.out.print("Digite o valor de V1 (preço por km até X): ");
        double V1 = scanner.nextDouble();

        System.out.print("Digite o valor de V2 (preço por km acima de X): ");
        double V2 = scanner.nextDouble();

        System.out.print("Digite a quantidade de km percorridos (P): ");
        double P = scanner.nextDouble();

         double valorTotal;

        if (P <= X) {
            valorTotal = P * V1;
        } else {
            valorTotal = P * V2;
        }

        System.out.printf("O valor total da viagem é: R$ %.2f%n", valorTotal);
    }
}
