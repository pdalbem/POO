import java.util.List;

public class Main {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("João", "SC12345");
        Aluno a2 = new Aluno("Maria", "SC11223");
        Aluno a3 = new Aluno("José", "SC98765");

        Disciplina d1 = new Disciplina("POOS3","Programação Orientada a Objetos",80);
        Disciplina d2 = new Disciplina("ESDS3", "Estrutura de Dados", 80);
        Disciplina d3 = new Disciplina("ESWS3", "Engenharia de Software",80);

        Matricula m1 = new Matricula(a1, d1, 9, 70, "2024.1");
        Matricula m2 = new Matricula(a2, d1, 10, 90,"2024.1");
        Matricula m3 = new Matricula(a2, d2, 8, 100, "2024.1");
        Matricula m4 = new Matricula(a3,d2, 9, 100, "2024.1");
        Matricula m5 = new Matricula(a3, d3, 10,90, "2024.1");


        //A associação entre alunos e matrículas e disciplinas e matrículas
        //pode ser feita via método setMatriculas() de cada classe
        a1.setMatriculas(List.of(m1));
        a2.setMatriculas(List.of(m2,m3));
        a3.setMatriculas(List.of(m4,m5));

        d1.setMatriculas(List.of(m1,m2));
        d2.setMatriculas(List.of(m3,m4));
        d3.setMatriculas(List.of(m5));

        //OUTRA FORMA: A associação entre alunos e matrículas e disciplinas e matrículas
        //pode ser feita via método adicionarMatricula() de cada classe
        //EXEMPLO:
        // a1.adicionarMatricula(m1);
        // a2.adicionarMatricula(m2,m3);
        // a3.adicionarMatricula(m4,m5);

        // d1.adicionarMatricula(m1,m2);
        // d2.adicionarMatricula(m3,m4);
        // d3.adicionarMatricula(m5);


        //Saber as disciplinas em que Maria está matriculado
        for (Matricula m : a2.getMatriculas()) {
            System.out.println(m.getDisciplina().getNomeDisciplina());

        }

        //Saber quem está cursando POO
        for (Matricula m : d1.getMatriculas()) {
            System.out.println(m.getAluno().getNome());
            System.out.println(m.getNota());
        }

    }
}
