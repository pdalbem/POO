import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Manutencao {
    private LocalDate data;
    private double custo;
    private Veiculo veiculo;
    private Mecanico mecanico;

    @Override
    public String toString() {
        return  "Data=" + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", Custo=" + custo +
                ", Veiculo=" + veiculo +
                ", Mecanico=" + mecanico ;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Manutencao that)) return false;
        return Double.compare(getCusto(), that.getCusto()) == 0 && Objects.equals(getData(), that.getData()) && Objects.equals(getVeiculo(), that.getVeiculo()) && Objects.equals(getMecanico(), that.getMecanico());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getCusto(), getVeiculo(), getMecanico());
    }

    public Manutencao(LocalDate data, double custo, Veiculo veiculo, Mecanico mecanico) {
        if (veiculo==null)
            throw new IllegalArgumentException("Veículo não pode ser nulo");

        this.setData(data);
        this.setCusto(custo);
        this.setVeiculo(veiculo);
        this.setMecanico(mecanico);
        veiculo.incluirManutencao(this);
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }
}
