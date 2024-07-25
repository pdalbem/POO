import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o capital inicial: ");
        double capitalInicial = entrada.nextDouble();

        System.out.println("Digite a taxa anual: ");
        double taxa = entrada.nextDouble();

        System.out.println("Digite o tempo: ");
        int tempo = entrada.nextInt();

        double montante = capitalInicial * Math.pow((1+taxa),tempo);
       // System.out.println("Capital acumulado: " + montante);
        System.out.printf("Capital acumulado: %.2f", montante);

    }
}