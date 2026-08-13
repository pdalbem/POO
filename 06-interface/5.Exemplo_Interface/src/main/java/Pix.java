public class Pix implements Pagamento{
    private String chavePix;

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando o pagamento no valor de "+valor+" via PIX chave "+chavePix);
    }

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
