public class Cidade {
    private String nome;
    private String uf;

    public Cidade(String nome, String uf) {

        this.setNome(nome);
        this.setUf(uf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
