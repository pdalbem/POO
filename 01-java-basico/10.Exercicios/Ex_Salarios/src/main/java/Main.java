import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de funcionários: ");
        int n = scanner.nextInt();

        double[] salarios = new double[n];
        double somaSalarios = 0;

        for (int i = 0; i < n; i++) {
                System.out.print("Digite o salário do funcionário " + (i + 1) + ": ");
                double salario = scanner.nextDouble();

                salarios[i] = salario;
                somaSalarios += salario;
        }


        double mediaSalarios = somaSalarios / n;
        System.out.println("\nMédia dos salários: " + mediaSalarios);

        System.out.println("\nNovos salários após o reajuste:");
        for (int i = 0; i < n; i++) {
            if (salarios[i] > mediaSalarios)
                salarios[i] = salarios[i] * 1.05;
            else
                salarios[i] = salarios[i] * 1.10;

            System.out.println("Novo salário: " + salarios[i]);
        }
    }
}
