import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int SIZE=7;

        double[] temperatura = new double[SIZE];
        double soma=0;
        for (int i=0;i<SIZE;i++){
            System.out.println("Digite a temperatura do dia "+(i+1));
            temperatura[i]= scanner.nextDouble();
            soma+=temperatura[i];
        }
        double media = soma/SIZE;
        System.out.println("Média das temperaturas: "+media);

        int contador=0;
        for (double temp:temperatura) { //usando for aprimorado
            System.out.println(temp);
            if (temp > media)
                contador++;
        }
        System.out.println("Qtd de dias com temperatura acima da média: "+contador);




    }
}
