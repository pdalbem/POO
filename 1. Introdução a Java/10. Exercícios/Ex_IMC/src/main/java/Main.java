import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a altura: ");
        double altura = entrada.nextDouble();

        System.out.println("Digite o peso: ");
        double peso = entrada.nextDouble();

        double imc = peso / (altura*altura); //  peso / Math.pow(altura,2)
        System.out.println("Seu IMC é: " + imc);

        if (imc < 18.5)
            System.out.println("Abaixo do peso");
           else if (imc <= 24.9)
                System.out.println("Peso normal");
              else if (imc <= 29.9)
                   System.out.println("Acima do peso");
                else if (imc <= 34.9)
                      System.out.println("Obesidade I");
                   else if (imc <= 39.9)
                        System.out.println("Obesidade II");
                     else
                        System.out.println("Obesidade III");

    }
}