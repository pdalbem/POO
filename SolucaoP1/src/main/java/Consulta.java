import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta implements SaidaFormatada {

    private static int contadorId = 1;
    private int id;
    private LocalDate data;
    private LocalTime hora;
    private double valorConsulta;
    private Paciente paciente;
    private Medico medico;


    public Consulta(LocalDate data, LocalTime hora, double valorConsulta, Paciente paciente, Medico medico) {
        this.id = contadorId++;
        this.data = data;
        this.hora = hora;
        this.valorConsulta = valorConsulta;
        this.paciente = paciente;
        this.medico = medico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String obterDados() {
        return "Consulta{" +
                "id=" + this.id +
                ", data=" + this.data +
                ", hora=" + this.hora +
                ", valorConsulta=" + this.valorConsulta +
                ", paciente=" + this.paciente +
                ", medico=" + this.medico +
                '}';
    }
}