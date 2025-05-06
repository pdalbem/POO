import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Paciente extends Pessoa {
    private String telefone;
    private final ArrayList<Consulta> consultas = new ArrayList<>();

    private static int contador = 1;

    @Override
    public int gerarID() {
        return contador++;
    }


    public Paciente(String cpf, String nome, String telefone) {
        super(cpf, nome);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public Iterator<Consulta> obterConsultas() {
        return this.consultas.iterator();
    }

    @Override
    public void incluirConsulta(Consulta consulta) {
        if (!consulta.getPaciente().equals(this)) {
            throw new IllegalArgumentException("Não foi possível adicionar a consulta, paciente incorreto!");
        }
        if (this.consultas.contains(consulta)) {
            throw new IllegalArgumentException("Essa consulta já foi cadastrada no paciente!");
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
        System.out.println("\nDados do paciente");
        System.out.println("=================");
        System.out.println("ID: " + getId());
        System.out.println("CPF: " + getCpf());
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + telefone + "\n");
    }

    public Iterator<Consulta> obterConsultas(LocalDateTime dataInicio, LocalDateTime dataFim) {
        ArrayList<Consulta> listaFiltrada = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getDataHora().isAfter(dataInicio) && consulta.getDataHora().isBefore(dataFim)) {
                listaFiltrada.add(consulta);
            }
        }
        return listaFiltrada.iterator();
    }

    public Iterator<Consulta> obterConsultas(Medico medico) {
        ArrayList<Consulta> listaFiltrada = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico)) {
                listaFiltrada.add(consulta);
            }
        }
        return listaFiltrada.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Paciente paciente)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getTelefone(), paciente.getTelefone()) && Objects.equals(consultas, paciente.consultas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTelefone(), consultas);
    }
}
