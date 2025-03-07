public class Main {
    public static void main(String[] args) {
        String texto = null;

        try {
            // Tentando acessar um método em uma variável null
            System.out.println(texto.length());
        } catch (NullPointerException e) {
            // Tratando a exceção
            System.out.println("Erro: A variável texto é null, não é possível acessar o método length.");
        }
    }
}
