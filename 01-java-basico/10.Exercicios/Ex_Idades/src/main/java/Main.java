import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int idade, quantidadePessoas=0, soma=0, quantidadeMaiorIdade=0, quantidadeIdoso=0;

        do{
            System.out.println("Digite a idade: ");
            idade = scanner.nextInt();

            if (idade>=0) {
                quantidadePessoas++;
                soma += idade;
            }

            if (idade>=21)
                quantidadeMaiorIdade++;

            if (idade>=65)
                quantidadeIdoso++;

        }while (idade>=0);

        System.out.println("Quantidade de pessoas: "+ quantidadePessoas);
        System.out.println("Média das idades: "+ soma/quantidadePessoas);
        System.out.println("Quantidade de pessoas acima de 21 anos: "+quantidadeMaiorIdade);
        double porcentagemIdosos = (double) quantidadeIdoso/quantidadePessoas;
        System.out.println("Porcentagem de idosos: "+ porcentagemIdosos*100+"%");
        
    }
}
