import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Digite o valor do lado A: ");
        int a = scanner.nextInt();

        System.out.println("Digite o valor do lado B: ");
        int b = scanner.nextInt();

        System.out.println("Digite o valor do lado C: ");
        int c = scanner.nextInt();

        if (a+b>c && a+c>b && b+c>a) {
            if (a == b && b == c)
                System.out.println("Triângulo equilátero");
            else if (a == b || b == c || a == c)
                System.out.println("Triângulo isósceles");
            else
                System.out.println("Triângulo escaleno");
        }else
            System.out.println("Não forma triângulo");

    }
}
