import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curso c1 = new Curso("ADS", "ADS");

        AlunoGraduacao alunoGraduacao = new AlunoGraduacao("123",
                "Maria",
                9,
                "SC1234",
                c1,
                100);

        Professor p1 = new Professor("999",
                "João",
                "SC9898",
                "Doutor");

        AlunoPosGraduacao alunoPosGraduacao = new AlunoPosGraduacao("343434",
                "José",
                9,
                "SC7676",
                c1,
                "Desenvolvimento Mobile",
                p1);

        // Vou adicionar estes objetos em uma lista
        // Repare que a lista é de objetos Pessoa !!!
        List<Pessoa> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(alunoGraduacao);
        lista.add(alunoPosGraduacao);

        for (Pessoa p: lista)
            p.exibirInfo(); //Polimorfismo
    }
}