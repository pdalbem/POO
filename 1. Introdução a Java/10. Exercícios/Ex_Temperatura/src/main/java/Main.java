import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int TAM = 3;
        double[] temperaturas = new double[TAM];
        Scanner entrada = new Scanner(System.in);
        double soma=0;
        for (int i=0; i<temperaturas.length; i++) {
            System.out.println("Digite a temperatura doa dia "+ (i+1));
            temperaturas[i] = entrada.nextDouble();
            soma+=temperaturas[i];
        }
        double media = soma /TAM;
        System.out.println("Média das temperaturas: "+ media);

        int cont=0;
        for(double t : temperaturas)
            if (t>media) {
                System.out.println("Temperatura acima da média: " + t);
                cont++;
            }
        System.out.println("Quantidade de dias acima da média: "+ cont);
    }
}