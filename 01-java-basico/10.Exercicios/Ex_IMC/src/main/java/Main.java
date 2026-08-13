import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a altura: ");
        double altura = scanner.nextDouble();

        System.out.println("Digite o peso: ");
        double peso = scanner.nextDouble();

        double imc = peso / (altura*altura); // Math.pow(altura,2)
        System.out.println("Seu IMC é: "+imc);

        if (imc<18.5)
            System.out.println("Abaixo do pese");
          else if (imc<25)
            System.out.println("Peso normal");
          else if (imc<30)
            System.out.println("Acima do peso");
          else if (imc<35)
            System.out.println("Obesidade I");
          else if (imc<40)
            System.out.println("Obesidade II");
          else
              System.out.println("Obesidade III");



    }
}
