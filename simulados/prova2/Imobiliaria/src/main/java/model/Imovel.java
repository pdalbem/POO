package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public  abstract class Imovel implements ExibeDados, Comparable<Imovel>{
    private String endereco;
    private double valorAluguel;
    private Proprietario proprietario;
    private StatusImovel statusImovel;
    private final List<Aluguel> alugueis = new ArrayList<>();

    public Imovel(String endereco, double valorAluguel, Proprietario proprietario) {
        if (proprietario==null)
            throw new IllegalArgumentException("Proprietário do imóvel não pode ser nulo");

        setValorAluguel(valorAluguel);

        this.endereco = endereco;
        this.proprietario = proprietario;
        this.statusImovel = StatusImovel.VAGO;
        this.proprietario.incluirImovel(this);
    }

    public abstract double calcularValorSeguro();

    @Override
    public int compareTo(Imovel o) {
        return Double.compare(this.valorAluguel,o.valorAluguel);
    }

    @Override
    public void exibirInfo() {
        System.out.println("\nEndereço: " + this.getEndereco());
        System.out.println("Proprietário: "+ this.getProprietario().getNome());
        System.out.println("Valor do aluguel: "+ this.getValorAluguel());
        System.out.println("Status do imóvel: "+ this.getStatusImovel());
    }

    public String getEndereco() {
        return endereco;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public StatusImovel getStatusImovel() {
        return statusImovel;
    }

    public void setValorAluguel(double valorAluguel) {
        if (valorAluguel<=0)
            throw new IllegalArgumentException("Valor do aluguel deve ser positivo");

        this.valorAluguel = valorAluguel;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // setter
    public void alterarProprietario(Proprietario proprietario) {
        if (proprietario==null)
            throw new IllegalArgumentException("Proprietário do imóvel não pode ser nulo");

        if (!proprietario.equals(this.proprietario)) {
            this.proprietario.removerImovel(this);
            this.proprietario = proprietario;
            this.proprietario.incluirImovel(this);
        }
    }

    //package-private
    void setStatusImovel(StatusImovel statusImovel) {
        this.statusImovel = statusImovel;
    }

    public Inquilino obterInquilinoAtual() {
        for (Aluguel aluguel:alugueis)
            if (aluguel.getStatusAluguel()==StatusAluguel.ATIVO)
                return aluguel.getInquilino();
        return null;
    }

    void incluirAluguel(Aluguel aluguel) {
        this.alugueis.add(aluguel);
    }

    public Iterator<Aluguel> obterAlugueis() {
        return Collections.unmodifiableList(this.alugueis).iterator();
    }

    public Proprietario getProprietario() {
        return proprietario;
    }
}