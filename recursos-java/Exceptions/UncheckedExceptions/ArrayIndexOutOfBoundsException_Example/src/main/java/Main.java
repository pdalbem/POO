public class Main {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3};

        try {
            // Tentando acessar um índice fora do limite do array
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Tratando a exceção
            System.out.println("Erro: Índice fora dos limites do array.");
        }
    }
}
