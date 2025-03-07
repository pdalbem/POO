public class Main {
    public static boolean validarEmail(String email) throws EmailInvalidoException {
        if (email == null || email.isEmpty() || !email.contains("@") || !email.contains(".")) {
            throw new EmailInvalidoException("Endereço de e-mail inválido: " + email);
        }
        return true;
    }

    public static void main(String[] args) {
        String email1 = "usuario@dominio.com";
        String email2 = "usuario.dominio";

        try {
            validarEmail(email1);
            System.out.println("E-mail válido: " + email1);

            validarEmail(email2);
            System.out.println("E-mail válido: " + email2); // Esta linha não será executada
        } catch (EmailInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
