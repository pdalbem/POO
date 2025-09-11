import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class Consulta implements ExibeDados, IdentificacaoAutomatica{
    private final int id;
    private LocalDateTime dataHora;
    private final Medico medico;
    private final Paciente paciente;
    private StatusConsulta status;

    private static final int DURACAO_MINUTOS = 30;

    private static int contador = 1;

    @Override
    public int gerarID() {
        return contador++;
    }

    public Consulta(LocalDateTime dataHora, Medico medico, Paciente paciente) {
        if (medico==null)
            throw new IllegalArgumentException("Médico não pode ser nulo.");

        if (paciente==null)
            throw new IllegalArgumentException("Paciente não pode ser nulo.");

        if (dataHora.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Não é possível agendar uma consulta para data anterior a hoje.");

        if (conflitoDeHorario(paciente.obterConsultas(), dataHora))
            throw new IllegalArgumentException("Paciente já possui consulta nesse horário.");

        if (conflitoDeHorario(medico.obterConsultas(), dataHora))
            throw new IllegalArgumentException("Médico já possui consulta nesse horário.");

        this.id = gerarID();
        this.dataHora = dataHora;
        this.medico = medico;
        this.paciente = paciente;
        this.status = StatusConsulta.AGENDADA;
        paciente.incluirConsulta(this);
        medico.incluirConsulta(this);
    }

    private boolean conflitoDeHorario(Iterator<Consulta> consultas, LocalDateTime novaData) {
        while (consultas.hasNext()) {
            Consulta c = consultas.next();
            if (c.getStatus()!=StatusConsulta.CANCELADA) {
                LocalDateTime inicio = c.getDataHora();
                LocalDateTime fim = inicio.plusMinutes(DURACAO_MINUTOS);
                LocalDateTime novaFim = novaData.plusMinutes(DURACAO_MINUTOS);

                boolean conflito = novaData.isBefore(fim) && novaFim.isAfter(inicio);
                if (conflito)
                    return true;
            }
        }
        return false;
    }

    public void cancelarConsulta() {
        if (this.dataHora.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Não é possível cancelar uma consulta que já passou!");

        if (this.getStatus() == StatusConsulta.CANCELADA)
            throw new IllegalArgumentException("A consulta já foi cancelada.");

        this.paciente.removerConsulta(this);
        this.medico.removerConsulta(this);
        this.status = StatusConsulta.CANCELADA;
    }

    public void remarcarConsulta(LocalDateTime novaDataHora) {
        if (novaDataHora.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Não é possível remarcar para o passado.");

        if (this.getStatus() == StatusConsulta.CANCELADA)
            throw new IllegalArgumentException("Consulta cancelada não pode ser remarcada.");

        if (conflitoDeHorario(paciente.obterConsultas(), novaDataHora))
            throw new IllegalArgumentException("Paciente já possui consulta nesse horário.");

        if (conflitoDeHorario(medico.obterConsultas(), novaDataHora))
            throw new IllegalArgumentException("Médico já possui consulta nesse horário.");

        this.dataHora = novaDataHora;
    }

    public void confirmarConsulta() {
        if (this.getStatus() != StatusConsulta.AGENDADA)
            throw new IllegalStateException("Apenas consultas agendadas podem ser confirmadas.");

        this.status = StatusConsulta.CONFIRMADA;
    }

    @Override
    public void exibirInfo() {
        System.out.println("\nDados da consulta");
        System.out.println("=================");
        System.out.println("ID: " + id);
        System.out.println("Data e hora: " + dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")));
        System.out.println("Médico: " + medico.getNome());
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Status: " + getStatus());
        System.out.println();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public StatusConsulta getStatus() {
        return status;
    }
}
