import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite um número inteiro: ");
        int numInteiro = entrada.nextInt();
        System.out.println("O número digitado foi:  " + numInteiro);

        System.out.println("Digite um número double: ");
        double numDouble = entrada.nextDouble();
        System.out.println("O número digitado foi:  " + numDouble);

        System.out.println("Digite um número float: ");
        float numFloat = entrada.nextFloat();
        System.out.println("O número digitado foi:  " + numFloat);

        System.out.println("Digite um booleano: ");
        boolean varBoolean = entrada.nextBoolean();
        System.out.println("Foi digitado:  " + varBoolean);

        String nome, cidade;
        System.out.println("Digite seu nome: ");
        nome = entrada.nextLine();
        System.out.println("Digite sua cidade: ");
        cidade = entrada.nextLine();

        System.out.println("Olá, "+ nome + " você é de " + cidade);

        String nomeCompleto;
        int idade;
        float altura;

        System.out.println("Digite seu nome: ");
        nomeCompleto = entrada.nextLine();
        System.out.println("Digite sua idade");
        idade = entrada.nextInt();
        System.out.println("Digite sua altura: ");
        altura = entrada.nextFloat();
        System.out.println("\n Nome: " + nomeCompleto
                          + "\n Idade: " + idade
                          + "\n Altura: " + altura);

    }
}