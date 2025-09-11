public class Acessorio {
    private String nome;
    private int quantidadeDisponivel;
    private double valorDiaria;

    public Acessorio(String nome, int quantidadeDisponivel, double valorDiaria) {
        this.nome = nome;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.valorDiaria = valorDiaria;
    }

    public void retirarAcessorio() {
        if (quantidadeDisponivel <= 0)
            throw new IllegalStateException("Acessório "+this.nome+" indisponível para locação");

        this.quantidadeDisponivel -= 1;
    }

    public void devolverAcessorio() {
        this.quantidadeDisponivel += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
