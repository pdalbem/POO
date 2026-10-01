package model;

public class Corretor extends Pessoa{
    private String creci;
    private double totalComissoes;
    private static final double PERCENTUAL_COMISSAO = 0.06;

    public void calcularComissao(double valorAluguel) {
        this.totalComissoes += valorAluguel * PERCENTUAL_COMISSAO;
    }

    @Override
    public void exibirInfo() {
      super.exibirInfo();
      System.out.println("\nCRECI: " + this.getCreci()
                          +"\nComissão: "+this.getTotalComissoes());
    }

    public Corretor(String cpf, String nome, String creci) {
        super(cpf, nome);
        this.creci = creci;
    }

    public String getCreci() {
        return creci;
    }

    public double getTotalComissoes() {
        return totalComissoes;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }
}