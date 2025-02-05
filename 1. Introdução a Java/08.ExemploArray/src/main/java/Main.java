import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Array de inteiros de 5 posições
        int[] valores = new int[5];

        //Array de double de 10 posições
        double[] notas = new double[10];

        //Também é possível declarar e inicializar o vetor
        // JVM define automaticamente o tamanho com base nos elementos
        int[] numeros = {10, 20, 30, 40, 50, 60}; //array de 6 posições
        double[] temperaturas = {28.5, 30.7, 21.2, 19.5, 18.0}; //array de 5 posições

        // Ler o vetor
        Scanner entrada = new Scanner(System.in);
        // Exemplo 1
        for (int i=0; i<5; i++)
            valores[i] = entrada.nextInt();

        //Exemplo 2
        for (int i=0; i< valores.length; i++)
            valores[i] = entrada.nextInt();

        //Mostrar os elementos de um vetor
        //Exemplo 1
        for (int i=0; i< valores.length; i++)
            System.out.println("Valor na posição " + (i+1) +": " + valores[i]);

        //Exemplo usando o for aprimorado
        for (int i : valores)
            System.out.println(i);

    }
}