import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void lerArquivo() throws IOException {
        FileReader arquivo = new FileReader("arquivo.txt"); //arquivo inexistente, para gerar erro
        BufferedReader br = new BufferedReader(arquivo);
        br.readLine();
        br.close();
    }

    public static void main(String[] args) {
        try {
            lerArquivo();
        } catch (IOException e) {
            System.out.println("Erro ao tentar ler o arquivo: " + e.getMessage());
        }
    }
}
