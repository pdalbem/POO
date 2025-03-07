public class Main {
    public static void main(String[] args) {
        String texto = null;
        int divisor = 0;
        int[] numeros = {1, 2, 3};

        try {
            // Tentando acessar um metodo em um objeto null
            System.out.println(texto.length());

            // Tentando dividir por zero
            int resultado = 10 / divisor;

            // Tentando acessar um índice fora do limite do array
            System.out.println(numeros[5]);
        } catch (NullPointerException e) {
            System.out.println("Erro: A variável texto é null.");
        } catch (ArithmeticException e) {
            System.out.println("Erro: Não é possível dividir por zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Índice fora dos limites do array.");
        } catch (Exception e) {
            // Captura outras exceções gerais
            System.out.println("Erro: Ocorreu um erro inesperado.");
        }
    }
}
