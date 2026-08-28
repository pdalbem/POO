package model;

public class Acessorio {
    private final String nome;
    private final double valorDiaria;

    public Acessorio(String nome,  double valorDiaria) {
        if (nome==null || nome.isBlank())
            throw new IllegalArgumentException("Nome do acessório não pode ser nulo/vazio");

        if (valorDiaria<=0)
            throw new IllegalArgumentException("Valor da diária deve ser maior que zero");

        this.nome = nome;
        this.valorDiaria = valorDiaria;
    }

    public String getNome() {
        return nome;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}
