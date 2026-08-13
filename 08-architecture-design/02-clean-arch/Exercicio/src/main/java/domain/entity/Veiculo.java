package domain.entity;

public class Veiculo {
    private int id;
    private String placa;
    private String marca;
    private Proprietario proprietario;

    public void validarPlaca(String placa){
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("Placa não pode ser nula ou em branco.");
        }
    }

    public void validarMarca(String marca){
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("Marca não pode ser nula ou em branco.");
        }
    }

    public void validarProprietario(Proprietario proprietario){
        if (proprietario == null) {
            throw new IllegalArgumentException("Proprietário não pode ser nulo.");
        }
    }

    public Veiculo(String placa, String marca, Proprietario proprietario) {
        validarPlaca(placa);
        validarMarca(marca);
        validarProprietario(proprietario);
        this.placa = placa;
        this.marca = marca;
        this.proprietario = proprietario;
    }

    public Veiculo(int id, String placa, String marca, Proprietario proprietario) {
        this(placa, marca, proprietario);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Veiculo{id=" + id + ", placa='" + placa + "', marca='" + marca +
                "', proprietario=" + proprietario.getNome() + "}";
    }
}

