import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Categoria {
    private String nome;
    private List<Curso> cursos= new ArrayList<>();

    public void exibirCursosPorCategoria(){
        for (Curso c:cursos)
            System.out.println(c);
    }

    public void inserirCursos(Curso... c){
        Collections.addAll(cursos,c);
    }

    public void removerCursos(Curso c){
        cursos.remove(c);
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
