package domain.entity;

public class Paciente extends Pessoa{
    private String telefone;

    public Paciente(String nome, String telefone) {
        super(nome);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}