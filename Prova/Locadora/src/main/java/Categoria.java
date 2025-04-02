public class Categoria {
    private String descricao;
    private double valorDiaria;

    public Categoria(String descricao, double valorDiaria) {
        if (valorDiaria<0)
            throw new IllegalArgumentException("Categoria não pode ter valor da diária negativo");
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
