public class Main {
    public static void main(String[] args) {
        /// ////////////////////////
        // CRIAçÂO DE STRINGS
        ///////////////////////////

        // Literal
        String s1 = "Welcome";
        System.out.println(s1);

        //Cada vez que você cria uma string literal, a JVM verifica primeiro o "String Pool".
        // Se a cadeia de caracteres já existir no pool, será retornada uma referência à instância em pool.
        // Se a string não existir no pool, uma nova instância de string será criada e colocada no pool

        String s2 = "Welcome"; // JVM não cria outro objeto, pois "Welcome" já existe no String Pool.
                               // Assim, s2 irá apontar para a mesma referễncia

        // Usando new
        // É criado, explicitamente, um novo objeto String na memória heap (fora do pool de strings),
        // mesmo que a string "Welcome" já exista no pool de strings.
        String cursoNew = new String("Programação Orientada a Objetos");
        System.out.println("O nome do curso é: "+ cursoNew);

        // a partir de um array usando new
        char[] ch={'h','e','l','l','o'};
        String s=new String(ch);
        System.out.println(s); //mostra hello


        /////////////////////
        // ALGUNS MÉTODOS
        ////////////////////
        String nomeCurso = "Programação Orientada a Objetos";
        for (char c : nomeCurso.toCharArray())
            System.out.print(c); // imprime Programação Orientada a Objetos,  caractere por caractere

        // cgarAt, indexOf, length, toUpperCase, to LowerCase e substring
        System.out.println("Char no index 4: " + nomeCurso.charAt(4)); // mostra 'r'
        System.out.println("Index de 'o': " + nomeCurso.indexOf('o')); // mostra 2
        System.out.println("Length da string: " + nomeCurso.length()); // mostra o comprimento da string
        System.out.println(nomeCurso.toUpperCase()); // PROGRAMAÇÃO ORIENTADA A OBJETOS
        System.out.println(nomeCurso.toLowerCase()); // programação orientada a objetos
        System.out.println(nomeCurso.substring(0, 11)); // Programação - substring from indexes 0 to 1

        /////////////////////
        //COMPARAR STRINGS
        /////////////////////
        String a = "POO";
        String b = a;  //variável b recebe a, portanto b="POO"
        String c = "BD";
        String d = "POO";

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

        /////////////////////
        // CONCATENAR STRINGS
        /////////////////////
        String primeiroNome = "Maria ";
        String segundoNome = "Silva";
        String nomeCompleto1 = primeiroNome+" "+segundoNome;
        System.out.println(nomeCompleto1);
        //OU assim:
        String nomeCompleto2 = primeiroNome.concat(segundoNome); //concat só aceita Strings, não lida com null
        System.out.println(nomeCompleto2);




        //  Vamos concatenar 65536 vezes o caractere 'a'. A cada vez que passarmos no laço,
        //  JVM irá criar um novo objeto em memória. Isso porque String em Java é imutável!
        // Muito ineficiente!
        String strFinal = "";
        for(int i = 0; i < 65536; i ++){
            strFinal += "a";
        }

        // Maneira correta usando StringBuilder
        // o StringBuilder é mutável, ou seja, a cada “append(valor)” que fizemos no laço,
        // concatenamos de fato um novo valor a String já existente, sem a necessidade da criação de um novo objeto em memória.
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < 100000; i ++)
            strBuilder.append("a");


        // Concatenando de forma sincronizada usando o StringBuffer.
        // Assim, você garante a consistência do seu código quando há diversas threads lendo ou modificando a mesma String
        StringBuffer strBuffer = new StringBuffer();
        for(int i = 0; i < 100000; i ++)
            strBuffer.append("a");
        
    }
}