
package model;

public class Cidade {
    private int id;
    private String nome;

    public Cidade(String nome) {
        this.setNome(nome);
    }

    public Cidade(int id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
