import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cliente {
    private String cpf;
    private String nome;
    private List<Compra> listaCompras=new ArrayList<>();

    public void exibirHistoricoCompras(LocalDate dataInicio, LocalDate dataFinal){
        if (listaCompras.isEmpty())
            System.out.println("\nCliente ainda não fez compras");
        else
            for (Compra c: listaCompras)
                if (c.getDataCompra().isAfter(dataInicio) && c.getDataCompra().isBefore(dataFinal)) {
                    System.out.println("\nNúmero da compra: " + c.getNumeroCompra()
                            + "\nData da compra: " + c.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                            + "\nValor Total: " + c.getValorTotalCompra()
                            + "\nDesconta: " + c.getDesconto()
                            + "\nValor a pagar: " + c.getValorPagar());
                    System.out.println("Itens desta compra:");
                    Iterator<ItemCompra> it = c.obterItensCompra();
                    while (it.hasNext()){
                        ItemCompra item=it.next();
                        System.out.println("Produto: "+item.getProduto().getDescricao()+ " - Qtd: "+item.getQuantidadeComprada() + " - Valor: "+item.getValorTotal());

                    }
                }
                else
                    System.out.println("\nCliente não possui compras no período");

    }

    public void incluirCompra(Compra... compra){
        Collections.addAll(this.listaCompras,compra);
    }

    public void removerCompra(Compra compra){
        this.listaCompras.remove(compra);
    }

    public Iterator<Compra> obterCompras(){
        return this.listaCompras.iterator();
    }

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
