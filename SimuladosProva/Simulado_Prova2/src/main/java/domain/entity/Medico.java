package domain.entity;

public class Medico extends  Pessoa{
    private String numCRM;
    private Especialidade especialidade;

    public Medico(String nome, String numCRM, Especialidade especialidade) {
        super(nome);
        this.numCRM = numCRM;
        this.especialidade = especialidade;
    }

    public Medico(int id, String nome, String numCRM, Especialidade especialidade) {
        super(id, nome);
        this.numCRM = numCRM;
        this.especialidade = especialidade;
    }

    public String getNumCRM() {
        return numCRM;
    }

    public void setNumCRM(String numCRM) {
        this.numCRM = numCRM;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "\nMédico" + super.toString() +
                "\nCRM=" + numCRM +  "\nEspecialidade=" + especialidade.getDescricao();
    }
}
