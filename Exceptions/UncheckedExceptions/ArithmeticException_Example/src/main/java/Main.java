public class Main {
    public static void main(String[] args) {
        int divisor = 0;

        try {
            // Tentando dividir por zero
            int resultado = 10 / divisor;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            // Tratando a exceção
            System.out.println("Erro: Não é possível dividir por zero.");
        }
    }
}
