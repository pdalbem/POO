import java.util.*;

public class Especialidade {
    private String descricao;
    private List<Medico> medicos = new ArrayList<>();

    public Iterator<Medico> obterMedicos(){
        return medicos.iterator();
    }

    public void incluirMedicos(Medico...m){
        Collections.addAll(medicos,m);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Especialidade that)) return false;
        return Objects.equals(getDescricao(), that.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDescricao());
    }

    public Especialidade(String descricao) {
        this.setDescricao(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
