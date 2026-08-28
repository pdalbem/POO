package model;

import java.time.LocalDate;
import java.util.*;

public class Cliente {
    private final String cpf;
    private final String nome;
    private final List<Locacao> locacoes = new ArrayList<>();

    public Cliente(String cpf, String nome) {
        if (cpf==null || cpf.isBlank())
            throw new IllegalArgumentException("CPF do cliente não pode ser nulo/vazio");
        if (nome==null || nome.isBlank())
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo/vazio");

        this.cpf = cpf;
        this.nome = nome;
    }

     public Iterator<Locacao> obterLocacoes(){
        return Collections.unmodifiableList(this.locacoes).iterator();
    }

    public Iterator<Locacao> obterLocacoes(LocalDate dataInicial) {
        List<Locacao> listaFiltrada = new ArrayList<>();
        for (Locacao locacao : this.locacoes)
            if (!locacao.getDataLocacao().isBefore(dataInicial))
                listaFiltrada.add(locacao);

        return listaFiltrada.iterator();
    }

    public boolean possuiLocacaoAtiva() {
        for (Locacao locacao : this.locacoes)
            if (locacao.getStatusLocacao()==StatusLocacao.ATIVA)
                return true;

        return false;
    }

    public void adicionarLocacao(Locacao locacao) {
        this.locacoes.add(locacao);
    }

    public void removerLocacao(Locacao locacao) {
        this.locacoes.remove(locacao);
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
