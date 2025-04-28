package imobiliaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Inquilino extends Pessoa{
    private double rendaMensal;
    private final List<Aluguel> alugueis= new ArrayList<>();

    @Override
    public void exibirInfo() {
        System.out.println("\nCPF: " +this.getCpf()
                          +"\nNome: "+this.getNome()
                          +"\nRenda: "+ this.rendaMensal);
    }

    public Inquilino(String cpf, String nome, double rendaMensal) {
        super(cpf, nome);
        this.rendaMensal = rendaMensal;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public void incluirAluguel(Aluguel... aluguel) {
        Collections.addAll(this.alugueis,aluguel);
    }

    public Iterator<Aluguel> obterAlugueis() {
        return alugueis.iterator();
    }
}
