package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Pedido {
    private final String numero;
    private final Cliente cliente;
    private final LocalDate data;
    private double valorTotal;
    private StatusPedido status;
    private final List<ItemPedido> itens = new ArrayList<>();

    public void confirmarPedido(){
        if (this.itens.isEmpty())
            throw new IllegalStateException("Pedido sem itens. Não é possível confirmar pedido");
        if (this.status!= StatusPedido.PENDENTE)
            throw new IllegalStateException("Pedido já confirmado");

        //Este "for" percorre o ArrayList itens, verificando se todos os produtos do pedido possuem estoque suficiente
        //É para atender a regra: Se algum produto não possuir estoque suficiente,
        // o pedido não deve ser confirmado e nenhuma baixa de estoque deve ser realizada
        for (ItemPedido itemPedido:itens) {
            Produto p = itemPedido.getProduto();
            if (itemPedido.getQuantidadeComprada()> p.getQuantidadeEstoque())
                throw new IllegalStateException("Estoque insuficiente");
        }

        //Este outro "for" percorre o ArrayList itens efetuando baixa no estoque
        for (ItemPedido itemPedido:itens)
            itemPedido.getProduto().baixarEstoque(itemPedido.getQuantidadeComprada());

        this.status= StatusPedido.CONFIRMADO;
    }

    public Iterator<ItemPedido> iterator(){
        return Collections.unmodifiableList(this.itens).iterator();
    }

    //Reparem que removerItem recebe um Produto como parâmetro e não um ItemPedido.
    // Assim, ele precisa percorrer o ArrayList itens, a fim de encontrar o ItemPedido que possui o produto passado no parâmetro
    //Ao encontrar, remove.
    //Não podemos remover um ItemPedido usando um for comum. Isso atrapalha o controle interno da lista
    //Devemos percorrer usando um iterator e remover usando o .remove() dele
    public void removerItem(Produto produto){
        if (status!= StatusPedido.PENDENTE)
            throw new IllegalStateException("Pedido já foi confirmado. Não é possível remover itens");
        if (produto==null)
            throw new IllegalArgumentException("Produto não pode ser nulo");

        Iterator<ItemPedido> it = this.itens.iterator();
        while (it.hasNext()) {
            ItemPedido next =  it.next();
            if (next.getProduto().getNome().equals(produto.getNome())) {
                valorTotal -= next.getSubtotal(); //atualiza valorTotal, conforme pede regra de domínio
                it.remove();
                return;
            }
        }
    }

    public void adicionarItem(Produto produto, int quantidade){
        if (status!= StatusPedido.PENDENTE)
            throw new IllegalStateException("Pedido já confirmado. Não é possível adicionar itens");

        ItemPedido itemPedido = new ItemPedido(produto, quantidade);
        itens.add(itemPedido);
        this.valorTotal += itemPedido.getSubtotal(); //atualiza valorTotal, conforme pede regra de domínio
    }

    public Pedido(String numero, Cliente cliente, LocalDate data) {
        if (numero ==null || numero.isBlank())
            throw new IllegalArgumentException("Número do pedido não pode ser nulo ou vazio");
        if (cliente==null)
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        if (data == null || data.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Data do pedido inválida");

        this.numero = numero;
        this.cliente = cliente;            //Pedido conhece cliente
        this.cliente.adicionarPedido(this); //Faz cliente conhecer o pedido. Navegabilidade bidirecional
        this.data = data;
        this.status = StatusPedido.PENDENTE; //Pedido criado com status PENDENTE
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
