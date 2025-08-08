public class Main {
    // Método principal onde chamamos os outros métodos
    public static void main(String[] args) {
       Main obj = new Main(); //preciso instanciar objeto da classe para invocar os métodos não static

        // Chamando o método que não retorna valor
        obj.exibirMensagem();

        // Chamando o método que retorna valor e armazenando-o
        int somaFinal = obj.somar(10, 5);
        System.out.println("A soma é: " + somaFinal);
    }
 
    // Método não static que não recebe parâmetros e não retorna valor (void)
    public void exibirMensagem() {
        System.out.println("Olá, seja bem-vindo!");
    }

    // Método não static que recebe dois parâmetros (int) e retorna um valor (int)
    public int somar(int numero1, int numero2) {
        int resultado = numero1 + numero2;
        return resultado;
    }
}
