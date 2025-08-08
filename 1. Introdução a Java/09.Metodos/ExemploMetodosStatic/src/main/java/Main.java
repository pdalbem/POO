public class Main {
    // Método principal onde chamamos os outros métodos
    public static void main(String[] args) {
        // Chamando o método que não retorna valor
        exibirMensagem();

        // Chamando o método que retorna valor e armazenando-o
        int somaFinal = somar(10, 5);
        System.out.println("A soma é: " + somaFinal);
    }

    // Método que não recebe parâmetros e não retorna valor (void)
    public static void exibirMensagem() {
        System.out.println("Olá, seja bem-vindo!");
    }

    // Método que recebe dois parâmetros (int) e retorna um valor (int)
    public static int somar(int numero1, int numero2) {
        int resultado = numero1 + numero2;
        return resultado;
    }
}
