import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente extends Pessoa{
    private String telefone;
    private List<Compra> compraList = new ArrayList<>();

    void exibirHistoricoCompras(LocalDate dataInicial, LocalDate dataFinal){
        boolean temCompra = false; //flag para dizer se tem compra ou não
        for (Compra c: compraList){
            if (c.getDataCompra().isAfter(dataInicial) &&
                c.getDataCompra().isBefore(dataFinal)){
                System.out.println("\n Compras do Cliente " + this.getNome());
                c.mostrarDados();
                temCompra = true;
            }
        if (!temCompra) //uso da flag para emitir mensagem
            System.out.println("Não existe compra no período");

        }
    }

    void inserirCompras(Compra...compras){
        Collections.addAll(compraList,compras);
        //OU assim:  compraList.addAll(List.of(compras));
    }

    void removerCompras(Compra compra){
        compraList.remove(compra);
    }

    //ATENÇÃO NESTE CONSTRUTOR
    // Ele recebe apenas 3 parâmetros: cpf, nome e telefone
    // A lista de compras não é passada.
    // Isso é feito posteriormente via método incluirCompras
    public Cliente(String cpf, String nome, String telefone) {
        super(cpf, nome);
        this.setTelefone(telefone);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void mostrarDados() {
        System.out.println("\n CPF: "+this.getCpf()
                + "\n Nome: "+ this.getNome()
                + "\n Telefone: "+ this.getTelefone());
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }
}
