import java.util.Objects;

public class Carro extends Veiculo {
    private int capacidadePassageiros;

    @Override
    public String toString() {
        return super.toString() + ", CapacidadePassageiros=" + capacidadePassageiros ;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Carro carro)) return false;
        if (!super.equals(o)) return false;
        return getCapacidadePassageiros() == carro.getCapacidadePassageiros();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCapacidadePassageiros());
    }

    public Carro(String placa, String modelo, Proprietario proprietario, int capacidadePassageiros) {
        super(placa, modelo, proprietario);
        this.setCapacidadePassageiros(capacidadePassageiros);
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }
}
