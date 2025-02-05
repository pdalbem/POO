import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int idade, quantidadePessoas=0, quantidadeMaiores=0, quantidadeIdosos=0;
        double soma=0;

        do{
            System.out.println("Digite a idade: ");
            idade = entrada.nextInt();

            if (idade>=0){
                quantidadePessoas++;
                soma+=idade;
            }
            if (idade>=21)
                quantidadeMaiores++;

            if  (idade>65)
                quantidadeIdosos++;

        }while (idade>=0);

        System.out.println("Quantidade de pessoas: " +quantidadePessoas);
        System.out.println("Média: " + (soma/quantidadePessoas));

        System.out.println("Quantidade de maiores de idade: " + quantidadeMaiores);

        double porcentagemIdosos = (double) quantidadeIdosos /quantidadePessoas;
        System.out.println("Porcentagem de idosos: " + porcentagemIdosos);

    }
}