import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno extends Pessoa {
    private String email;
    private List<Matricula> matriculas = new ArrayList<>();

    public void inserirMatriculas(Matricula...m){
        Collections.addAll(matriculas,m);
    }

    public void removerMatricula(Matricula m){
        matriculas.remove(m);
    }

    public Aluno(String cpf, String nome, String email) {
        super(cpf, nome);
        this.email = email;
    }

    @Override
    public List<Curso> obterCursos() {
        List<Curso> resultado = new ArrayList<>();
        for (Matricula m: matriculas)
            resultado.add(m.getTurma().getCurso());
        return resultado;
    }

    public double calcularTotalGasto(){
        double total=0;
        for (Matricula m: matriculas)
            total+=m.getTurma().getCurso().getValor();
        return total;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
