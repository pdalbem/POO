import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curso c= new Curso("ADS","ADS");
        Pessoa p = new Professor("123","Joaquim",
                                "SC12345","doutor");

        Pessoa alunoGraduacao= new AlunoGraduacao("777","Maria",
                                     "SC8888",9.5,c,50);

        Pessoa alunoPosGraduacao=new AlunoPosGraduacao("888","João",
                                                      "SC3333",8,c,
                                         "Machine Learning",(Professor) p);

        List<Pessoa> lista = new ArrayList<>();
        lista.add(p);
        lista.add(alunoGraduacao);
        lista.add(alunoPosGraduacao);
        for (Pessoa pessoa:lista)
               pessoa.mostrarDados();
    }
}
