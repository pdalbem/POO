import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Especialidade {
    private int id;
    private String descricao;
    private List<Medico> medicos = new ArrayList<>();

    public Especialidade(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Especialidade that)) return false;
        return getId() == that.getId() && Objects.equals(getDescricao(), that.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public void adicionarMedico(Medico medico){
        this.medicos.add(medico);
    }

    public void removerMedico(Medico medico){
        this.medicos.remove(medico);
    }
}