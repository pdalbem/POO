# Strings em Java

Em Java, a String é uma classe que representa uma sequência de caracteres. 

Strings são imutáveis, ou seja, uma vez criada, uma String não pode ser alterada. 
Se você tentar modificar uma String, o Java cria um novo objeto String para refletir a mudança. 
Isso se deve à natureza de segurança e eficiência das strings no Java, 
especialmente considerando a constante reutilização de strings através do pool de strings.

### Como criar uma String
Existem várias maneiras de criar uma String em Java:
* Usando literais de strings: Quando você usa literais, o Java verifica se a string já existe no pool de strings. Se já existir, ele reutiliza a referência, economizando memória.
```Java
String s1 = "Hello";
```

* Usando o construtor new String(): Esse método cria uma nova String explicitamente na heap (fora do pool de strings). Mesmo que "Hello" já esteja no pool, um novo objeto é criado na memória heap.
```Java
String s2 = new String("Hello");
```

* Usando o String com char[]: cria uma nova String a partir de um array de caracteres.
```Java
char[] chars = {'H', 'e', 'l', 'l', 'o'};
String s3 = new String(chars);
```
### Principais métodos da classe String
Aqui estão alguns dos métodos mais importantes e comuns da classe String:

* `length()`: Retorna o comprimento (número de caracteres) da string.

```java
String s = "Hello";
int len = s.length(); // len = 5
```
* `charAt(int index)`: Retorna o caractere na posição especificada (index baseado em 0).
```java
char c = s.charAt(1); // c = 'e'
```
* `substring(int startIndex)` e `substring(int startIndex, int endIndex)`: Retorna uma parte da string.
```java
String sub = s.substring(1, 4); // sub = "ell"
```

* `equals(String other)`: Compara se o conteúdo das duas strings é igual.
```java
boolean isEqual = s.equals("Hello"); // isEqual = true
```

* `equalsIgnoreCase(String other)`: Compara se o conteúdo das duas strings é igual, ignorando diferenças de maiúsculas e minúsculas.
```java
boolean isEqualIgnoreCase = s.equalsIgnoreCase("hello"); // isEqualIgnoreCase = true
```

* `toUpperCase()` e `toLowerCase()`: Converte todos os caracteres da string para maiúsculas ou minúsculas, respectivamente.
```java
String upper = s.toUpperCase(); // upper = "HELLO"
String lower = s.toLowerCase(); // lower = "hello"
```

* `contains(CharSequence seq)`: Verifica se a string contém a sequência de caracteres fornecida.
```java
boolean hasWorld = s.contains("llo"); // hasWorld = true
```

* `replace(CharSequence old, CharSequence new)`: Substitui todas as ocorrências de uma sequência por outra.
```java
String replaced = s.replace("e", "a"); // replaced = "Hallo"
```

* `trim()`: Remove os espaços em branco no início e no fim da string.
```java
String text = "  Hello  ";
String trimmed = text.trim(); // trimmed = "Hello"
```

* `split(String regex)`: Divide a string em um array com base no padrão regex.
```java
String text = "Java,Python,C++";
String[] languages = text.split(","); // languages = ["Java", "Python", "C++"]
```

### StringBuilder e StringBuffer
Embora as strings em Java sejam imutáveis, há situações em que você precisa modificar ou concatenar muitas strings, como em loops. 
Isso pode ser ineficiente se você continuar criando novas instâncias de String. É aí que entram as classes **StringBuilder** e **StringBuffer**.

A classe **StringBuilder** é usada quando você precisa modificar ou concatenar strings de forma eficiente. Ele permite alterar o conteúdo de uma string sem criar novos objetos a cada operação
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
sb.append("!");
System.out.println(sb.toString());  // Imprime "Hello World!"
```

A classe **StringBuffer** é semelhante ao StringBuilder, mas com a diferença de que é sincronizada (thread-safe). Isso significa que várias threads podem usar um StringBuffer ao mesmo tempo sem causar problemas de concorrência. Porém, isso faz com que o StringBuffer seja ligeiramente mais lento que o StringBuilder, já que ele realiza a sincronização das operações.
```java
StringBuffer sbf = new StringBuffer("Hello");
sbf.append(" World");
sbf.append("!");
System.out.println(sbf.toString());  // Imprime "Hello World!"
```

<img src="./Comparative.png" alt="Comparativo String vs StringBuilder vs StringBuffer" width="1000">
