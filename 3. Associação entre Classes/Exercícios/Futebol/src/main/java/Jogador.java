public class Jogador {
    private String nome;
    private String posicao;
    private int numeroCamisa;



    public Jogador(String nome, String posicao, int numeroCamisa) {
        this.setNome(nome);
        this.setPosicao(posicao);
        this.setNumeroCamisa(numeroCamisa);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }
}
