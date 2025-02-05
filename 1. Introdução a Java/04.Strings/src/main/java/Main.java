public class Main {
    public static void main(String[] args) {

        String nomeCurso = "Programação Orientada a Objetos";
        System.out.println("O nome do curso é: "+ nomeCurso);

        for (char c : nomeCurso.toCharArray())
            System.out.print(c); // imprime Programação Orientada a Objetos,  caractere por caractere

        System.out.println("Char no index 4: " + nomeCurso.charAt(4)); // mostra 'r'
        System.out.println("Index de 'o': " + nomeCurso.indexOf('o')); // mostra 2
        System.out.println("Length da string: " + nomeCurso.length()); // mostra o comprimento da string
        System.out.println(nomeCurso.toUpperCase()); // PROGRAMAÇÃO ORIENTADA A OBJETOS
        System.out.println(nomeCurso.toLowerCase()); // programação orientada a objetos
        System.out.println(nomeCurso.substring(0, 11)); // Programação - substring from indexes 0 to 1

        String a = "POO";
        String b = a;  //variável b recebe a, portanto b="POO"
        String c = "BD";
        String d = "POO";

        //Comparar Strings
        boolean iguais;
        iguais = a.equals(b); //retorna true
        iguais = a.equals(c); //retorna false
        iguais = a.equals(d); //retorna true


        String literalA = "Object-oriented";
        String literalB = "Object-oriented";
        String objectA = new String("Object-oriented");
        String objectB = new String("Object-oriented");

        System.out.println(literalA == literalB); // true, apontam para o mesmo objeto no pool de string
        System.out.println(objectA == objectB);  // false, apontam para objetos diferentes no heap
        System.out.println(literalA == objectA); // false, um objeto está no pool de string e outro no heap
        System.out.println(literalA.equals(objectA)); // true, equals compara o conteúdo e não a referência à memória


        // Concatenar Strings
        String primeiroNome = "Maria ";
        String segundoNome = "Silva";
        String nomeCompleto = primeiroNome.concat(segundoNome);
        //OU assim:
        //String nomeCompleto = primeiroNome+" "+segundoNome
        System.out.println(nomeCompleto);


        //Tamanho da String
        String nomeFaculdade = "IFSP";
        int tamanhoString = nomeFaculdade.length(); //retorna 4

        

        //Veja o material EAD1


    }
}