package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Inquilino extends Pessoa{
    private double rendaMensal;
    private final List<Aluguel> alugueis= new ArrayList<>();

    @Override
    public void exibirInfo() {
       super.exibirInfo();
        System.out.println("Renda: "+ this.rendaMensal);
    }

    public Inquilino(String cpf, String nome, double rendaMensal) {
        super(cpf, nome);

        if (rendaMensal<=0)
            throw new IllegalArgumentException("Renda deve ser maior que 0");

        this.rendaMensal = rendaMensal;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        if (rendaMensal<=0)
            throw new IllegalArgumentException("Renda deve ser maior que 0");

        this.rendaMensal = rendaMensal;
    }

    //package-private
    void incluirAluguel(Aluguel aluguel) {
        this.alugueis.add(aluguel);
    }

    public Iterator<Aluguel> obterAlugueis() {
        return Collections.unmodifiableList(this.alugueis).iterator();
    }
}