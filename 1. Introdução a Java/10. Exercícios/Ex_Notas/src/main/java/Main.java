import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int TAM=5;
        Scanner ent = new Scanner(System.in);
        double[] notas = new double[TAM];
        for (int i=0;i<TAM;i++){
            System.out.println("Digite a nota do aluno "+ (i+1));
            notas[i]=ent.nextDouble();
        }

        double media = calcularMedia(notas);
        System.out.println("Média das notas: "+media);

        System.out.println("Notas acima da média: ");
        mostrarMaiorMedia(notas);

        double porc = calcularPorcentagemAprovados(notas);
        System.out.println("Porcentagem de alunos aprovados: "+ porc);

        System.out.println("Maior nota: "+ maiorNota(notas));

        bubbleSort(notas,-1);
        System.out.println("Array ordenado");
        for (double n:notas)
            System.out.println(n);

    }

    public static void bubbleSort(double[] notas, int ordem){
       for (int i=0;i<notas.length;i++)
           for (int j=0;j<notas.length-1;j++)
               if((ordem==1 && notas[j]>notas[j+1]) ||
                       (ordem==-1 && notas[j]<notas[j+1]) ){
                   double aux=notas[j];
                   notas[j]=notas[j+1];
                   notas[j+1]=aux;
               }
    }

    public static double maiorNota(double[] notas){
        double maior=0;
        for (double n:notas)
            if (n>maior)
                maior=n;
        return maior;
    }

    public static double calcularPorcentagemAprovados(double[] notas){
        int qtd=0;
        for(double n:notas)
            if (n>=6)
                qtd++;
        return (double) qtd/notas.length;
    }

    public static void mostrarMaiorMedia(double[] notas){
        double media = calcularMedia(notas);
        for (double n:notas)
            if (n>media)
                System.out.println(n);
    }


    public static double calcularMedia(double[] notas){
        double soma=0;
        for(double n:notas)
            soma+=n;
        return soma/notas.length;
    }

//    public static double calcularMedia(double[] notas){
//        double soma=0;
//        for (int i=0;i< notas.length;i++)
//            soma+=notas[i]; // soma=soma+notas[i];
//        return soma/notas.length;
//    }



}
