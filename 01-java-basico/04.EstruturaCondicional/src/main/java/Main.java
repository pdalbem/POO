public class Main {
    public static void main(String[] args) {

        double nota = 8.5;

        //Estrutura condicional simples
        if (nota >= 6)
            System.out.println("Aluno Aprovado!");
        if (nota >=4 && nota <6)
            System.out.println("Aluno fará IFA!");
        if (nota < 4)
            System.out.println("Aluno Reprovado!");


        //Estrutura condicional composta
        if (nota >= 6)
            System.out.println("Aluno Aprovado!");
        else
            System.out.println("Verifique se aluno precisa de IFA ou já está reprovado");


        //Estrutura condicional aninhada
        if (nota >= 6)
            System.out.println("Aluno Aprovado!");
        else
        if (nota>=4)
            System.out.println("Aluno fará IFA!");
        else
            System.out.println("Aluno Reprovado!");

        // Mais um exemplo de if aninhado
        int primeiro = 8;
        int segundo = 3;

        if (primeiro == segundo) {
            System.out.println("Os números são iguais");
        }else if (primeiro > segundo) {
            System.out.println("Primeiro é maior");
        }else {
            System.out.println("Segundo é maior");
        }

    }
}