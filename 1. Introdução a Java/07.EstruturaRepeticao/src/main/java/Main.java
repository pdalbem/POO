public class Main {
    public static void main(String[] args) {
        int i;  // variável de controle da iteração
        // WHILE - teste no início
        i=1;
        System.out.println("Usando o WHILE");
        while  (i < 10){
            System.out.println("Valor de i: " + i);
            i++;
        }

        // DO WHILE - teste no final
        System.out.println("\n Usando o DO WHILE");
        i = 1;
        do{
            System.out.println("Valor de i: " + i);
            i++;
        }while (i <= 10);

        // FOR - repetição contada
        System.out.println("\n Usando o FOR");
        for (i=1; i<=10; i++)
            System.out.println("Valor de i: " + i);

        // Exemplo de estrutura de repetição aninhada
        // Calcular a tabuada
        for (int k = 1; k <= 10; k++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(k + " x " + j + " = " + (k * j));
            }
            System.out.print("\n");
        }





    }
}