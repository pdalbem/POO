import java.util.Objects;

public class Moto extends Veiculo{
    private double cilindradas;

    @Override
    public String toString() {
        return super.toString() + ", Cilindradas=" + cilindradas;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Moto moto)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getCilindradas(), moto.getCilindradas()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCilindradas());
    }

    public Moto(String placa, String modelo, Proprietario proprietario, double cilindradas) {
        super(placa, modelo, proprietario);
        this.setCilindradas(cilindradas);
    }

    public double getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(double cilindradas) {
        this.cilindradas = cilindradas;
    }
}
