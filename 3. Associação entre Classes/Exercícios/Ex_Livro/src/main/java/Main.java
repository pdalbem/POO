import java.util.Iterator;


public class Main {
    public static void main(String[] args) {

        Editora ed1 = new Editora("Pearson", "123456");

        Autor a1 = new Autor("Maria", "3351-1234");
        Autor a2 = new Autor("Joao", "1234");

        Livro livro1 = new Livro("Java", 2015,400, ed1);

        Livro livro2 = new Livro("POO", 2020, 300, ed1);
        livro2.adicionarAutor(a1,a2);

        System.out.println("Autores do livro " + livro2.getTitulo() + ": ");
        Iterator<Autor> it = livro2.iterator();
        while (it.hasNext())
            System.out.println(it.next().getNome());

    }
}