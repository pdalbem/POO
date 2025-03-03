import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno {
    private String nome;
    private String prontuario;
    private List<Matricula> matriculas= new ArrayList<>();

    //Metodo com quantidade variável de parâmetros
    public void adicionarMatricula(Matricula...m){
        Collections.addAll(matriculas,m);
        //comando acima é o mesmo que:
        //        for (Matricula mat:m)
       //            matriculas.add((mat));

    }

    public void removerMatricula(Matricula m){
        this.matriculas.remove(m);
    }

    // Repare que o construtor não recebe a List<Matricula>.
    // As matrículas serão informadas pelo adicionarMatricula(Matricula...m)
    public Aluno(String nome, String prontuario) {
        this.nome = nome;
        this.prontuario = prontuario;
    }

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

//Não vou precisar. As matriculas serão adicionadas via metodo adicionarMatricula
//    public void setMatriculas(List<Matricula> matriculas) {
//        this.matriculas = matriculas;
//    }
}
