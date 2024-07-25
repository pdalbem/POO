public class Main {
    public static void main(String[] args) {
        int a; //declaração da variável
        a = 5; //atribuição do valor à variável

        //declarando e inicializando a variável
        int b = 3;
        int soma = a + b;

        long inteiroLongo = 9223372036854775807L;

        boolean clienteAtivo=true;

        char letra = 'a';
        char simbolo = '@';

        float saldo = 123.45F;

        double taxa = 15.75;

        // Conversão de tipo de dados

        //Conversão implícita - do menor para o maio
        int numInteiro = 10;
        long numInteiroLongo = numInteiro;

        float numfloat = 9.5F;
        double numDouble =  numfloat;

        //Conversão explícita - do maior para o menor
        long varNumLong = 9223372036854775807L;
        int varNumInt = (int) varNumLong; // é preciso fazer o cast (int)

        double varDouble = 9.5;
        float varNumFloat = (float) varDouble;
        int varNumInt2 = (int) varDouble;

    }
}