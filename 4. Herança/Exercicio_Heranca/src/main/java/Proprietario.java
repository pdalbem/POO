import java.util.*;

public class Proprietario extends Pessoa{
    private String telefone;
    private List<Veiculo> veiculos=new ArrayList<>();

   public void incluirVeiculo(Veiculo...veiculo) {
       Collections.addAll(this.veiculos,veiculo);
   }

   public void removerVeiculo(Veiculo veiculo){
       this.veiculos.remove(veiculo);
   }

   public Iterator<Veiculo> obterVeiculos(){
       return this.veiculos.iterator();
   }

    @Override
    public String toString() {
        return super.toString() + ", telefone=" + telefone ;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Proprietario that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getTelefone(), that.getTelefone()) && Objects.equals(veiculos, that.veiculos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTelefone(), veiculos);
    }

    public Proprietario(String nome, String telefone) {
        super(nome);
        this.setTelefone(telefone);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
