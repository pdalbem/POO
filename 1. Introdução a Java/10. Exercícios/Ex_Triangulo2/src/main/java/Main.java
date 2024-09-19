import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        System.out.println("Digite o primeiro valor: ");
        int a = ent.nextInt();
        System.out.println("Digite o segundo valor: ");
        int b = ent.nextInt();
        System.out.println("Digite o terceiro valor: ");
        int c = ent.nextInt();

        if (formaTriangulo(a,b,c))
           System.out.println(tipoTriangulo(a,b,c));
        else
            System.out.println("Não forma triângulo");

    }

    public static boolean formaTriangulo(int a, int b, int c){
        if (a+b>c && a+c>b && b+c>a)
            return true;
        else
            return false;
    }

    public static String tipoTriangulo(int a, int b, int c){
        if (a==b && b==c)
            return "Equilátero";
        else if (a==b || a==c || b==c)
            return "Isósceles";
        else
            return "Escaleno";
    }

}
