package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cliente {
    private final String cpf;
    private String nome;
    private List<Pedido> pedidos = new ArrayList<>();

    public Iterator<Pedido> obterPedidos(LocalDate inicio, LocalDate fim){
        List<Pedido> listaFiltrada = new ArrayList<>();
        for (Pedido p: this.pedidos){
            if (!p.getData().isBefore(inicio) && !p.getData().isAfter(fim))
                listaFiltrada.add(p);
        }
        return listaFiltrada.iterator();
    }

    public void adicionarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public Iterator<Pedido> iterator(){
        return Collections.unmodifiableList(this.pedidos).iterator();
    }

    public void setNome(String nome) {
        if(nome==null || nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        this.nome = nome;
    }

    public Cliente(String cpf, String nome) {
        if (cpf==null || cpf.isBlank())
            throw new IllegalArgumentException("Cpf não pode ser nulo ou vazio");
        if(nome==null || nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");

        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
