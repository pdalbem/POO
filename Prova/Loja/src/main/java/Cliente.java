import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Cliente implements InfoProvider {
    private final int id;
    private String endereco;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(int id, String endereco) {
        this.id = id;
        this.endereco = endereco;
    }


    public Iterator<Pedido> obterPedidos(){
        return pedidos.iterator();
    }

    public void adicionarPedido(Pedido... pedido){
        Collections.addAll(pedidos,pedido);
    }

    public void removerPedido(Pedido pedido){
        this.pedidos.remove(pedido);
    }

    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
