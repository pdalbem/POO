import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("arquivo.txt"); //arquivo inexistente, para gerar erro
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de I/O: " + e.getMessage());
        }
    }
}
