package model;


public class Cidade {
    private int idCidade;
    private String nome;

    @Override
    public String toString() {
        return  "\nidCidade=" + idCidade +
                "\nNome=" + nome;
    }

    public Cidade(int idCidade, String nome) {
        this.idCidade = idCidade;
        this.nome = nome;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
