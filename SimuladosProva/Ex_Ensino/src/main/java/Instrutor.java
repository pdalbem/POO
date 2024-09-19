import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Instrutor extends Pessoa {
   private String matricula;
   private String telefone;
   private List<Turma> turmas = new ArrayList<>();

  public Instrutor(String cpf, String nome, String matricula, String telefone) {
        super(cpf, nome);
        this.matricula = matricula;
        this.telefone = telefone;
    }

    public void inserirTurmas(Turma...t){
        Collections.addAll(turmas,t);
    }

    public void removerTurma(Turma t){
      turmas.remove(t);
    }

    @Override
    public List<Curso> obterCursos() {
        List<Curso> resultado=new ArrayList<>();
        for (Turma turma:turmas)
            resultado.add(turma.getCurso());
        return resultado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
