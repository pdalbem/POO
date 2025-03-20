import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Compra {
    private String numeroCompra;
    private LocalDate dataCompra;
    private double valorTotalCompra;
    private double desconto;
    private double valorPagar;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<ItemCompra> itemCompras = new ArrayList<>();

    private void calcularValorTotalCompra(){
        double soma=0;
        for (ItemCompra itemCompra:itemCompras)
            soma+=itemCompra.getValorTotal();
        this.valorTotalCompra=soma;
        if (this.valorTotalCompra>1000)
            this.desconto=this.valorTotalCompra * 0.05;
        this.valorPagar = this.valorTotalCompra - this.desconto;
    }

    public void adicionarItemCompra(ItemCompra...itemCompra){
        for (ItemCompra item:itemCompra)
            if (item==null)
                throw new IllegalArgumentException("Item de compra "+numeroCompra+" não pode ser nulo.");

        Collections.addAll(this.itemCompras,itemCompra);
        calcularValorTotalCompra();
    }

    // SObrecarga de metodo para permitir instanciação dentro da classe.
    // Repare que este metodo faz uso do metodo acima
    public void adicionarItemCompra(Produto p, int qtd){
        this.adicionarItemCompra(new ItemCompra(p,qtd));
    }

    public void removerItemCompra(ItemCompra itemCompra){
        this.itemCompras.remove(itemCompra);
        calcularValorTotalCompra();
    }

    public Iterator<ItemCompra> iterator(){
        return this.itemCompras.iterator();
    }

    public Compra(String numeroCompra, LocalDate dataCompra, Cliente cliente, Vendedor vendedor) {
        if (cliente == null)
            throw new IllegalArgumentException("Cliente da compra nro " +numeroCompra+" não pode ser nulo.");
        if (dataCompra == null)
            throw new IllegalArgumentException("Data da compra nro " +numeroCompra+" não pode ser nula.");
        this.numeroCompra = numeroCompra;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    // Alguns atributos não possuem metodo set, para evitar inconsistências
    public String getNumeroCompra() {
        return numeroCompra;
    }

    public void setNumeroCompra(String numeroCompra) {
        this.numeroCompra = numeroCompra;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorTotalCompra() {
        return valorTotalCompra;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
