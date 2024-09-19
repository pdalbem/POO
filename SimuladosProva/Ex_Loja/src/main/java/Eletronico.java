public class Eletronico extends Produto{
    private String voltagem;

    @Override
    public void mostrarDados()
    {
        super.mostrarDados(); //Chama o mostrarDados da classe superior Produto
        System.out.println("Voltagem: " + this.getVoltagem());
    }

    public Eletronico(String descricao, double precoUnitario, String voltagem) {
        super(descricao, precoUnitario);
        this.voltagem = voltagem;
    }

    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }
}
