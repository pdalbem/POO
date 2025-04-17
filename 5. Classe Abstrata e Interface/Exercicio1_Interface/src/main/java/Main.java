public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("123", "Maria");

        Corrente corrente = new Corrente("Conta especial",cliente,"123", 1000, 5000);
        corrente.calcularTributo();

        Poupanca poupanca = new Poupanca("Poupança Ouro", cliente,"456",3000,1);
        poupanca.exibirInfo();

        SeguroVida seguroVida = new SeguroVida("Seguro", cliente, 50000);
        seguroVida.calcularTributo();



    }
}