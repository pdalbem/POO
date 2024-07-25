import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Exemplos de instanciação de objetos:
        Livro livro1;
        livro1 = new Livro();

        Livro livro2 = new Livro();

        Livro livro3 = new Livro("Java 8", "Deitel");

        // Acesso aos atributos por meio do get e set
        livro1.setTitulo("Java");
        livro1.setAutor("Deitel");
        livro1.setAnoPublicacao(2015);
        livro1.setPreco(350);

        System.out.println("Preço antes do reajuste: " + livro1.getPreco());
        // o objeto livro1 chama método reajustarPreco().
        livro1.reajustarPreco(0.10);
        System.out.println("Preço após reajuste: " + livro1.getPreco());

        //Array de objetos Livro com 3 posições
        Livro[] livros = new Livro[3];

        livros[0] = new Livro("BD","Silberschatz"); //posição 0 recebe novo livro
        livros[1]= livro1; //posição 1 recebe objeto já criado anteriormente

        //Outro exemplo, obtendo dados do teclado
        Scanner ent = new Scanner(System.in);
        for (int i=0;i<3;i++)
        {
            String titulo, autor;
            System.out.println("Digite o título do livro " + i+1);
            titulo = ent.nextLine();
            System.out.println("Digite o autor do livro " + i+1);
            autor= ent.nextLine();
            livros[i] = new Livro(titulo,autor);

        }

        System.out.println("Mostrando os títulos dos livros no array");
        for (Livro livro:livros)
            System.out.println("Título: " + livro.getTitulo());


    }
}