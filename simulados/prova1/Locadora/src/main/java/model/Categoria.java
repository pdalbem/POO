package model;

public class Categoria {
    private final String descricao;
    private double valorDiaria;

    public Categoria(String descricao, double valorDiaria) {
        if (descricao==null || descricao.isBlank())
            throw new IllegalArgumentException("Descrição da categoria não pode ter valor nulo/vazio");

        validarValorDiaria(valorDiaria);

        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }

    // Metodo privado
    private void validarValorDiaria(double valor){
        if (valor<=0)
            throw new IllegalArgumentException("Valor da diária deve ser maior que zero");
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        validarValorDiaria(valorDiaria);
        this.valorDiaria = valorDiaria;
    }
}
