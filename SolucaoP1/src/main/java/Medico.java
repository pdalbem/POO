import java.util.Objects;

public class Medico extends Pessoa {
    private String inscricaoCRM;
    private Especialidade especialidade;

    public Medico(String cpf, String nome, Cidade cidade, String inscricaoCRM, Especialidade especialidade) {
        super(cpf, nome, cidade);
        this.inscricaoCRM = inscricaoCRM;
        this.especialidade = especialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medico medico)) return false;
        return Objects.equals(getInscricaoCRM(), medico.getInscricaoCRM()) && Objects.equals(getEspecialidade(), medico.getEspecialidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInscricaoCRM(), getEspecialidade());
    }

    public String getInscricaoCRM() {
        return inscricaoCRM;
    }

    public void setInscricaoCRM(String inscricaoCRM) {
        this.inscricaoCRM = inscricaoCRM;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String obterDados() {
        return "cpf='" + this.getCpf() + '\'' +
                ", nome='" + this.getNome() + '\'' +
                ", cidade=" + this.getCidade().getNome() +
                ", CRM='" + this.getInscricaoCRM() + '\'' +
                ", especialidade='" + this.getEspecialidade().getDescricao() + '\'' +
                '}';
    }
}