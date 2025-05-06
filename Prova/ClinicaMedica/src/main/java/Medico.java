import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Medico extends Pessoa {
    private String inscricaoCRM;
    private Especialidade especialidade;
    private final ArrayList<Consulta> consultas = new ArrayList<>();

    private static int contador = 1;

    @Override
    public int gerarID() {
        return contador++;
    }

    public Medico(String cpf, String nome, String inscricaoCRM, Especialidade especialidade) {
        super(cpf, nome);
        this.inscricaoCRM = inscricaoCRM;
        this.especialidade = especialidade;
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
    public Iterator<Consulta> obterConsultas() {
        return this.consultas.iterator();
    }

    @Override
    public void incluirConsulta(Consulta consulta) {
        if (!consulta.getMedico().equals(this)) {
            throw new IllegalArgumentException("Não foi possível adicionar a consulta, médico incorreto!");
        }
        if (this.consultas.contains(consulta)) {
            throw new IllegalArgumentException("Essa consulta já foi cadastrada no médico!");
        }
        this.consultas.add(consulta);
    }

    @Override
    public void removerConsulta(Consulta consulta) {
        if (!this.consultas.contains(consulta)) {
            throw new IllegalArgumentException("A consulta já foi cancelada");
        }
        this.consultas.remove(consulta);
    }

    @Override
    public void exibirInfo() {
        System.out.println("\nDados do médico");
        System.out.println("=================");
        System.out.println("ID: " + getId());
        System.out.println("CPF: " + getCpf());
        System.out.println("Nome: " + getNome());
        System.out.println("Especialidade: " + especialidade.getDescricao());
        System.out.println("CRM: " + inscricaoCRM + "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Medico medico)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getInscricaoCRM(), medico.getInscricaoCRM()) && Objects.equals(getEspecialidade(), medico.getEspecialidade()) && Objects.equals(consultas, medico.consultas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInscricaoCRM(), getEspecialidade(), consultas);
    }
}
