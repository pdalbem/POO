import java.util.*;

public class Veiculo {
    private String placa;
    private String modelo;
    private Proprietario proprietario;
    private List<Manutencao> manutencoes = new ArrayList<>();

    public void incluirManutencao(Manutencao...manutencao){
        Collections.addAll(this.manutencoes,manutencao);
    }

    public void removerManutencao(Manutencao manutencao){
        this.manutencoes.remove(manutencao);
    }

    public Iterator<Manutencao> obterManutencoes(){
        return  this.manutencoes.iterator();
    }

    @Override
    public String toString() {
        return "Placa=" + placa +
                ", Modelo=" + modelo +
                ", Proprietario=" + proprietario.getNome() ;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Veiculo veiculo)) return false;
        return Objects.equals(getPlaca(), veiculo.getPlaca()) && Objects.equals(getModelo(), veiculo.getModelo()) && Objects.equals(getProprietario(), veiculo.getProprietario()) && Objects.equals(manutencoes, veiculo.manutencoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlaca(), getModelo(), getProprietario(), manutencoes);
    }

    public Veiculo(String placa, String modelo, Proprietario proprietario) {
        if (proprietario==null)
            throw new IllegalArgumentException("Proprietário não pode ser nulo");

        this.setPlaca(placa);
        this.setModelo(modelo);
        this.setProprietario(proprietario);
        proprietario.incluirVeiculo(this);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
