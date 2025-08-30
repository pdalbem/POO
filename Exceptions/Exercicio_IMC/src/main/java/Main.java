import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite o nome do paciente: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o peso: ");
            double peso = scanner.nextDouble();

            System.out.print("Digite a altura: ");
            double altura = scanner.nextDouble();

            Paciente paciente = new Paciente(nome, peso,altura);

            double imc = paciente.calcularIMC();
            System.out.println(paciente.obterClassificacao(imc));

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Entrada inválida");
        }
        finally {
            scanner.close();
        }
    }
}
