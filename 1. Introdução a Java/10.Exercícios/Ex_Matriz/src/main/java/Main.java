import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int SIZE=4;

        Scanner scanner = new Scanner(System.in);


        int[][] matriz = new int[SIZE][SIZE];

        System.out.println("Digite os valores para a matriz 4x4:");

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                System.out.print("Matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }

        //Mostrando a matriz
        System.out.println("A matriz lida foi: ");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(" " + matriz[i][j]);
            System.out.println();
        }


        // I) Soma dos elementos da diagonal principal
        int somaDiagonalPrincipal = 0;
        for (int i = 0; i < SIZE; i++) {
            somaDiagonalPrincipal += matriz[i][i];
        }

        System.out.println("\nI) A soma dos números na diagonal principal: " + somaDiagonalPrincipal);

        // II) Quantidade de números pares em cada linha
        System.out.println("\nII) Quantidade de números pares em cada linha:");

        for (int i = 0; i < SIZE; i++) {
            int quantidadePares = 0;
            for (int j = 0; j < SIZE; j++) {
                if (matriz[i][j] % 2 == 0) {
                    quantidadePares++;
                }
            }
            System.out.println("Linha " + (i + 1) + ": " + quantidadePares + " números pares");
        }

        // III) Média dos números por coluna
        System.out.println("\nIII) Média dos números por coluna:");

        for (int j = 0; j < 4; j++) {
            int somaColuna = 0;
            for (int i = 0; i < 4; i++) {
                somaColuna += matriz[i][j];
            }
            double mediaColuna = (double) somaColuna / SIZE;
            System.out.printf("Coluna %d: %.2f\n", j + 1, mediaColuna);
        }

    }
}
