import java.util.Iterator;

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
        //pode ser feita via metodo adicionarMatricula(Matricula...m) de cada classe
         a1.adicionarMatricula(m1);
         a2.adicionarMatricula(m2,m3);
         a3.adicionarMatricula(m4,m5);

         d1.adicionarMatricula(m1,m2);
         d2.adicionarMatricula(m3,m4);
         d3.adicionarMatricula(m5);

        //Saber as disciplinas em que Maria (objeto a2) está matriculado
        System.out.println("Disciplinas que "+a2.getNome() + " possui matrícula");
        Iterator<Matricula> it = a2.iterator();
        while (it.hasNext()){
            Matricula m = it.next();
            System.out.println("Disciplina: "+m.getDisciplina().getNomeDisciplina());
            System.out.println("Sigla: "+ m.getDisciplina().getSigla()+"\n");
        }

        //Saber quem está cursando POO (objeto d1)
        System.out.println("Alunos matriculados em "+d1.getNomeDisciplina());
        it= d1.iterator();
        while (it.hasNext()){
            Matricula m = it.next();
            System.out.println("Nome: " +m.getAluno().getNome());
            System.out.println("Nota: " +m.getNota());
            System.out.println("Frequência: " +m.getFrequencia());
            System.out.println("Período: "+m.getPeriodo()+"\n");

        }

    }
}
