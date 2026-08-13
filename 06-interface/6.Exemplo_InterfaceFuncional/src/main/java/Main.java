public class Main {
    public static void main(String[] args) {
        // Expressão lambda implementando a interface Operacao
        Operacao soma = (x, y) -> x + y;
        Operacao subtracao = (x, y) -> x - y;
        Operacao multiplicacao = (x,y) -> x * y;
        Operacao divisao = (x,y) -> x/y;

        System.out.println("Soma: " + soma.executar(5, 3));
        System.out.println("Subtração: " + subtracao.executar(5, 3));
        System.out.println("Multiplicação: " + multiplicacao.executar(5, 3));
        System.out.println("Divisão: " + divisao.executar(10, 2));
    }
}
