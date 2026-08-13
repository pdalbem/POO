public class Main {
    public static void validarIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Idade não permitida. Deve ser maior ou igual a 18.");
        } else {
            System.out.println("Idade válida.");
        }
    }

    public static void main(String[] args) {
        try {
            validarIdade(16);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
