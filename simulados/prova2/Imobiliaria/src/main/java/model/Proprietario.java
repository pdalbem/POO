package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Proprietario extends Pessoa{
    private String telefone;
    private String numContaBancaria;
    private final List<Imovel> imoveis=new ArrayList<>();

    @Override
    public void exibirInfo() {
       super.exibirInfo();
        System.out.println("Telefone: "+this.telefone);
    }

    public Proprietario(String cpf, String nome, String telefone, String numContaBancaria) {
        super(cpf, nome);
        this.telefone = telefone;
        this.numContaBancaria = numContaBancaria;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNumContaBancaria() {
        return numContaBancaria;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNumContaBancaria(String numContaBancaria) {
        this.numContaBancaria = numContaBancaria;
    }

    public double calcularRendimentoMensal() {
        double rendimento = 0.0;
        for (Imovel imovel : imoveis)
            if (imovel.getStatusImovel()==StatusImovel.ALUGADO)
                rendimento += imovel.getValorAluguel();

        return rendimento;
    }

    public Iterator<Imovel> obterImoveisVagos() {
        List<Imovel> imoveisVagos = new ArrayList<>();
        for (Imovel imovel : imoveis)
            if (imovel.getStatusImovel()==StatusImovel.VAGO)
                imoveisVagos.add(imovel);

        return imoveisVagos.iterator();
    }

    public Iterator<Imovel> obterTodosImoveis(){
        return Collections.unmodifiableList(this.imoveis).iterator();
    }

    void incluirImovel(Imovel imovel) {
        this.imoveis.add(imovel);
    }

    void removerImovel(Imovel imovel) {
        this.imoveis.remove(imovel);
    }
}