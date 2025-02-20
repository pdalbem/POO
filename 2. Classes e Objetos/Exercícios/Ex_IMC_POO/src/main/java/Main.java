import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Relembrando como instanciar objetos com diferentes métodos construtores

        Paciente p1 = new Paciente();
        p1.setNome("Maria");
        p1.setAltura(1.75);
        p1.setPeso(60);

        p1.calcularIMC();

        Paciente p2 = new Paciente("joão",1.80,90);
        p2.setPeso(93);

        Paciente p3 = new Paciente(1.75,90);

        Scanner ent = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = ent.nextLine();

        System.out.println("Digite a altura: ");
        double altura = ent.nextDouble();

        System.out.println("Digite o peso: ");
        double peso = ent.nextDouble();
        Paciente p4 = new Paciente(nome,altura,peso);
        System.out.println("IMC da paciente "+ p4.getNome());
        p4.calcularIMC();

    }
}