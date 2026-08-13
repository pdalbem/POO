import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // IntStream.range: gera uma sequência de inteiros (exclusivo no fim)
        int somaDe1a10 = java.util.stream.IntStream.rangeClosed(1, 10).sum();
        System.out.println("Soma de 1 a 10: " + somaDe1a10); // 55

        List<Integer> notas = Arrays.asList(7, 8, 5, 9, 6, 10, 4);

        // mapToInt: converte Stream<Integer> em IntStream para usar métodos numéricos
        double media = notas.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Média: " + media);

        int maiorNota = notas.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        System.out.println("Maior nota: " + maiorNota);

        int menorNota = notas.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
        System.out.println("Menor nota: " + menorNota);

        // IntSummaryStatistics: pega tudo de uma vez (min, max, avg, sum, count)
        IntSummaryStatistics stats = notas.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Estatísticas -> min: " + stats.getMin()
                + ", max: " + stats.getMax()
                + ", média: " + stats.getAverage()
                + ", soma: " + stats.getSum()
                + ", total: " + stats.getCount());
    }
}
