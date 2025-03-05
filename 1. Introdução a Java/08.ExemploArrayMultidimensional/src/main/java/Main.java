import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = new int[4][3]; //matriz bidimensional 4X3

        //Ler a matriz
        Scanner entrada = new Scanner(System.in);
        for(int i=0;i<4;i++)
            for(int k=0;k<3;k++) {
                System.out.println("Digite o valor para a linha " +(i+1) + ", coluna "+ (k+1));
                matriz[i][k] = entrada.nextInt();
            }

        //Percorrer a matriz
        for(int i=0;i<4;i++) {
            for (int k = 0; k < 3; k++)
                System.out.print("  " + matriz[i][k]);
            System.out.print("\n");
        }

        // Outro exemplo
        for(int i=0;i<4;i++)
            for(int k=0;k<3;k++)
                System.out.println("Valor na linha " +(i+1) + ", coluna "+ (k+1) + ": "+ matriz[i][k]);
    }
}