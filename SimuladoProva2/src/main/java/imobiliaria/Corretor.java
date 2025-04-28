package imobiliaria;

public class Corretor extends Pessoa{
    private String creci;
    private double comissao;

    @Override
    public void exibirInfo() {
        System.out.println("\nCPF: " +this.getCpf()
                          +"\nNome: "+ this.getNome()
                          +"\nCRECI: " + this.getCreci()
                          +"\nComissão: "+this.getComissao());
    }

    public Corretor(String cpf, String nome, String creci) {
        super(cpf, nome);
        this.creci = creci;
    }

    public String getCreci() {
        return creci;
    }

    public double getComissao() {
        return comissao;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

   public void calcularComissao(double valorAluguel) {
        this.comissao += valorAluguel * 0.06;
    }
}
