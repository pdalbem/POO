import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Disciplina {
    private String sigla;
    private String nomeDisciplina;
    private int cargaHoraria;
    private List<Matricula> matriculas= new ArrayList<>();

    //Metodo com quantidade variável de parâmetros
    public void adicionarMatricula(Matricula...m){
        Collections.addAll(matriculas,m);
    }

    public void removerMatricula(Matricula m){
        this.matriculas.remove(m);
    }

    // Repare que o construtor não recebe a List<Matricula>.
    // As matrículas serão informadas pelo adicionarMatricula(Matricula...m)
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

    //Não vou precisar. As matriculas serão adicionadas via metodo adicionarMatricula
   //  public void setMatriculas(List<Matricula> matriculas) {
  //        this.matriculas = matriculas;
  //    }
}
