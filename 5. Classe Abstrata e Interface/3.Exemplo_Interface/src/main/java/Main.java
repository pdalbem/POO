public class Main {
    public static void main(String[] args) {
        Pagamento cartao = new CartaoCredito("4444.5555.6666.7777");
        Pagamento pix = new Pix("987456");

        cartao.processarPagamento(1500.00);
        pix.processarPagamento(300.00);
    }
}
