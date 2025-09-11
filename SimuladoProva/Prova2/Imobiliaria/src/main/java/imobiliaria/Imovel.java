package imobiliaria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Imovel implements ExibeDados{
    private String endereco;
    private double valorAluguel;
    private Proprietario proprietario;
    private boolean alugado;
    private final List<Aluguel> alugueis = new ArrayList<>();

    public Imovel(String endereco, double valorAluguel, Proprietario proprietario) {
        if (proprietario==null)
            throw new IllegalArgumentException("Proprietário do imóvel não pode ser nulo");

        this.endereco = endereco;
        this.valorAluguel = valorAluguel;
        this.proprietario = proprietario;
        this.proprietario.incluirImovel(this);
    }

    public String getEndereco() {
        return endereco;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public boolean estaAlugado() {
        return alugado;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    protected void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public Inquilino obterInquilinoAtual() {
         for (Aluguel aluguel:alugueis)
            if (aluguel.isAtivo())
                return aluguel.getInquilino();
        return null;
    }

    public void incluirAluguel(Aluguel aluguel) {
        this.alugueis.add(aluguel);
        this.alugado = true;
    }

    public Iterator<Aluguel> obterAlugueis() {
        return alugueis.iterator();
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
