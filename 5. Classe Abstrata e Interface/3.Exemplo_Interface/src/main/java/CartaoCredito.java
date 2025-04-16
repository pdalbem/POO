public class CartaoCredito implements Pagamento{
    private String numeroCartao;

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando o pagamento no valor de "+valor+" via cartão de crédito número "+numeroCartao);
    }

    public CartaoCredito(String numeroCartao) {
        this.setNumeroCartao(numeroCartao);
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
