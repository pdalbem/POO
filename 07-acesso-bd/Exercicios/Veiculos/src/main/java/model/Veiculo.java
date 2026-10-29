package model;

public class Veiculo {
    private final int id;
    private String placa;
    private String marca;
    private Proprietario proprietario;

    public Veiculo(String placa, String marca, Proprietario proprietario) {
        setPlaca(placa);
        setMarca(marca);
        setProprietario(proprietario);
        this.id = 0;
    }

    public Veiculo(int id, String placa, String marca, Proprietario proprietario) {
        setPlaca(placa);
        setMarca(marca);
        setProprietario(proprietario);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", proprietario=" + proprietario +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa==null || placa.isBlank())
            throw new IllegalArgumentException("Placa não pode ser nula.");

        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca==null || marca.isBlank())
            throw new IllegalArgumentException("Marca não pode ser nula.");

        this.marca = marca;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        if (proprietario==null)
            throw new IllegalArgumentException("Proprietário não pode ser nulo.");

        this.proprietario = proprietario;
    }
}
