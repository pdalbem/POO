import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {public static void main(String[] args) {
    BufferedReader reader = null;

    try {
        // Abre o arquivo para leitura
        reader = new BufferedReader(new FileReader("exemplo.txt"));
        String linha;
        while ((linha = reader.readLine()) != null) {
            System.out.println(linha);
        }
    } catch (IOException e) {
        System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    } finally {
        // Garantir que o arquivo seja fechado, independentemente de uma exceção
        try {
            if (reader != null) {
                reader.close();
                System.out.println("Arquivo fechado com sucesso.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
        }
    }
}


}
