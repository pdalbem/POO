import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int TAM = 5;
        Scanner ent = new Scanner(System.in);
        Funcionario[] funcionarios = new Funcionario[TAM];
        double soma =0;
        for (int i=0;i<TAM;i++){
            System.out.println("Digite o nome: ");
            String nome = ent.nextLine();
            System.out.println("Digite o salário: ");
            double salario = ent.nextDouble();
            ent.nextLine();

            soma = soma+salario;

            funcionarios[i] = new Funcionario(nome,salario);

            //Outra forma de instanciar o objeto e atribuir ao vetor
           /* Funcionario f = new Funcionario(nome,salario);
            funcionarios[i]=f;*/
        }

        double media = soma / TAM;
        System.out.println("Media: " + media);

        for (int i=0;i<TAM;i++)
            if (funcionarios[i].getSalario()>media) {
                System.out.println("Nome: " + funcionarios[i].getNome());
                funcionarios[i].setSalario(funcionarios[i].getSalario()*1.05);
            }else
                funcionarios[i].setSalario(funcionarios[i].getSalario()*1.10);

        for (Funcionario f: funcionarios)
            System.out.printf("Novo salário: %.2f",f.getSalario() );

    }
}