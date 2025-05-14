
package model;

public class Cidade {
    private int id;
    private String nome;

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da cidade não pode ser nulo ou em branco");
        }
    }

    public Cidade(String nome) {
      validarNome(nome);
      this.nome=nome;
    }

    public Cidade(int id, String nome) {
        validarNome(nome);
        this.id=id;
        this.nome=nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }
}
