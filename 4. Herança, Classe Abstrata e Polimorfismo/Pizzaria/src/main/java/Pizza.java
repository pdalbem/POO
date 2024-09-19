import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza extends Produto{
    private boolean bordaRecheada;
    private List<Ingrediente> ingredientes = new ArrayList<>();

    @Override
    public String obterDados() {
        StringBuilder ing= new StringBuilder();
        for (Ingrediente i: ingredientes)
            ing.append("\n ").append(i.getNome());

        return "\n Descrição: "+getDescricao()
                +"\n Preço: " + getPreco()
                + "\n Borda recheada: "+ (isBordaRecheada()?"Sim":"Não")
                + "\n Ingredientes: " + ing;

    }

    public void adicionarIngredientes(Ingrediente... ingredientes){
        Collections.addAll(this.ingredientes,ingredientes);
    }

    public void removerIngrediente(Ingrediente ingrediente){
        this.ingredientes.remove(ingrediente);
    }

    public Pizza(String descricao, double preco, boolean bordaRecheada) {
        super(descricao, preco);
        this.setBordaRecheada(bordaRecheada);
    }

    public boolean isBordaRecheada() {
        return bordaRecheada;
    }

    public void setBordaRecheada(boolean bordaRecheada) {
        this.bordaRecheada = bordaRecheada;
    }



    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
