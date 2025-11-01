import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Tributavel, InfoProvider {
    private final int           id;
    private final LocalDate     dataPedido;
    private double              valorTotalPedido;
    private SituacaoPedido      situacao;
    private Cliente             cliente;
    private List<Produto>       itensPedido = new ArrayList<>();
    public static List<Pedido>  historicoPedidos = new ArrayList<>();

    public Pedido(int id, LocalDate dataPedido, Cliente cliente) {
        if(dataPedido == null)
            throw new IllegalArgumentException("Data do pedido não pode ser nula.");
        if (dataPedido.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Data do pedido não pode ser maior que a data de hoje.");

        this.id = id;
        this.dataPedido = dataPedido;
        this.situacao = SituacaoPedido.ABERTO;
        this.cliente = cliente;
        cliente.adicionarPedido(this);
        historicoPedidos.add(this);
    }

    public void adicionarProduto(Produto produto) {
        if (produto.getQuantidadeEstoque() > 0) {
            produto.removerEstoque(1);
            itensPedido.add(produto);
        } else {
            throw new IllegalStateException("Produto sem estoque disponível: " + produto.getNome());
        }
    }

    public void removerProduto(Produto produto) {
        itensPedido.remove(produto);
        produto.adicionarEstoque(1);
    }

    private double calcularValorTotal() {
        double soma = 0;
        for (Produto prod : itensPedido) {
            soma += prod.getPreco();
        }
        return soma;
    }

    public void finalizarPedido() {
        if (this.situacao.equals(SituacaoPedido.ABERTO)) {
            this.valorTotalPedido = calcularValorTotal();
            this.situacao = SituacaoPedido.FINALIZADO;
        }
    }

    public void cancelarPedido() {
       if (this.situacao.equals(SituacaoPedido.CANCELADO))
           throw new IllegalArgumentException("O pedido já se encontra cancelado");

        if (this.situacao.equals(SituacaoPedido.FINALIZADO))
            throw new IllegalArgumentException("O pedido está finalizado não pode ser cancelado");

        this.situacao = SituacaoPedido.CANCELADO;
        for (Produto prod : itensPedido)
            prod.adicionarEstoque(1);
    }

    @Override
    public double calcularTributo() {
        if (!this.situacao.equals(SituacaoPedido.FINALIZADO))
            throw new IllegalStateException("Finalize o pedido primeiro");

        if (cliente instanceof PessoaFisica)
                return this.valorTotalPedido * 0.1;
        else
                return this.valorTotalPedido * 0.15;
    }

    @Override
    public String obterDados() {
        return "---- Dados do pedido ----" +
                "\nID: " + this.id +
                "\nData: " + this.dataPedido.toString() +
                "\nValor total: " + this.valorTotalPedido +
                "\nSituação: " + this.situacao +
                "\n--------------------------";
    }

}
