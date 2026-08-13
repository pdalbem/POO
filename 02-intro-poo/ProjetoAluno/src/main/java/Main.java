import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Aluno a1=new Aluno(); //instanciação usando o contrutor vazio
        a1.setNome("Joaquim");
        a1.setCurso("Arduino");
        a1.setNotas(new double[]{10,9,8.5});

        System.out.println("Nome do aluno: "+a1.getNome());
        System.out.println("Curso do aluno: "+a1.getCurso());
        System.out.print("Notas do alunos:  ");
        for (double nota:a1.getNotas())
              System.out.print(nota + "  ");


        System.out.printf("\nMédia do aluno: %.2f",a1.calcularMedia());

        try{
            System.out.printf("\nMédia ponderada do aluno: %.2f" , a1.calcularMedia(new double[]{3,3,4}));
        }catch (IllegalArgumentException | ArithmeticException e){
            System.out.println(e.getMessage());
        }

       //Instanciação usando o construtor parametrizado
        Aluno a2 = new Aluno("Maria","Java",new double[]{10,9,9});

        //Chamada de método statis
        System.out.println("\n\nQtd de objetos Aluno: "+ Aluno.getQuantidadeAlunos());

        //Array de objetos Aluno
        final int SIZE=5;
        Aluno[] arrayAlunos=new Aluno[SIZE];
        arrayAlunos[0]=a1;
        arrayAlunos[1]=a2;
        arrayAlunos[2]=new Aluno("Joao", "Android");

        //Exemplo de instanciação com dados lidos do teclado
        Scanner scanner=new Scanner(System.in);
        System.out.print("\nEm seguida, insira os dados de "+SIZE+" alunos");
        for (int i=0;i<SIZE;i++) //array de 5 posições
        {
            System.out.println("\nALUNO "+(i+1));
            System.out.print("Nome do aluno: ");
            String nome= scanner.nextLine();
            System.out.print("Nome do curso: ");
            String curso=scanner.nextLine();
            double[] notas= new double[3];
            for (int k=0;k<3;k++) //para ler as 3 notas de cada aluno
            {
                System.out.print("Digite a nota " + (k+1)+": ");
                notas[k]= scanner.nextDouble();
            }
            //Com os dados lidos, é só instanciar o objeto
            arrayAlunos[i]=new Aluno(nome,curso,notas);
            scanner.nextLine();
        }

        //Percorrendo o array e mostrando os alunos com for aprimorado
        System.out.print("\nOs dados lidos foram:");
        for (Aluno a:arrayAlunos){
            System.out.print("\nNome do aluno: "+a.getNome());
            System.out.print("\nCurso: "+a.getCurso());
            System.out.print("\nNotas: ");
            for (double nota: a.getNotas())
                System.out.print(nota+ "   ");
            System.out.println();
        }



    }
}
