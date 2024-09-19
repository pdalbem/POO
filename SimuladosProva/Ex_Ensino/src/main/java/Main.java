import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Categoria prog = new Categoria("Programação");

        Curso java = new Curso("Java",400,30,prog);
        Curso python = new Curso("Python", 150, 30, prog);
        prog.inserirCursos(java,python);

        Categoria bd = new Categoria("Banco de Dados");
        Curso postgres=new Curso("PostgreSQL", 500,60,bd);
        bd.inserirCursos(postgres);

        System.out.println("\nCursos da categoria "+ prog.getNome());
        prog.exibirCursosPorCategoria();

        Instrutor instrutor = new Instrutor("12345","Joaquim","222","9999-9999");

        Turma turma1 = new Turma("T1",
                                LocalDate.of(2024,2,10),
                                LocalDate.of(2024,3,10),
                                java, instrutor);

        Turma turma2 = new Turma("T2",
                LocalDate.of(2024,2,10),
                LocalDate.of(2024,3,10),
                postgres, instrutor);


        instrutor.inserirTurmas(turma1,turma2);

        System.out.println("\nCursos do instrutor "+ instrutor.getNome());
        for (Curso c: instrutor.obterCursos())
            System.out.println(c);

        Aluno aluno = new Aluno("777","Maria","maria@maria.com");

        Matricula m1 = new Matricula(10,100,turma1,aluno);
        Matricula m2 = new Matricula(9.5,100,turma2,aluno);
        aluno.inserirMatriculas(m1,m2);

        System.out.println("\nTotal gasto por "+ aluno.getNome()+ ": "+ aluno.calcularTotalGasto());

        System.out.println("\nCursos do aluno "+ aluno.getNome());
        for (Curso c: aluno.obterCursos())
            System.out.println(c);

        List<Pessoa> lista=new ArrayList<>();
        lista.add(instrutor);
        lista.add(aluno);
        System.out.println("\nPolimorfismo: ");
        for (Pessoa p:lista) {
            System.out.println("Cursos de "+p.getNome());
            for (Curso c : p.obterCursos())
                System.out.println(c);
        }

    }



}