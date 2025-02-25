import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno {
    private String nome;
    private String prontuario;
    private List<Matricula> matriculas= new ArrayList<>();

    public void adicionarMatricula(Matricula m){

        this.matriculas.add(m);
    }

    //Metodo com quantidade variável de parâmetros
    public void adicionarMatricula(Matricula...m){

        Collections.addAll(matriculas,m);
    }

    public void removerMatricula(Matricula m){
        this.matriculas.remove(m);
    }

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

    public void setMatriculas(List<Matricula> matriculas) {

        this.matriculas = matriculas;
    }
}
