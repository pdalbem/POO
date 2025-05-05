import java.util.Optional;

public class Medico {
    private String CRM;
    private String nome;
    private Especialidade especialidade;


    public Medico(String CRM, String nome, Especialidade especialidade) {
        this.CRM = CRM;
        this.nome = nome;
        this.especialidade = especialidade;
        this.especialidade.incluirMedicos(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }
}
