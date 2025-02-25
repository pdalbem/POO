import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disciplina {
    private String sigla;
    private String nomeDisciplina;
    private int cargaHoraria;
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

    public Disciplina(String sigla, String nomeDisciplina, int cargaHoraria) {
        this.sigla = sigla;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina() {
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
