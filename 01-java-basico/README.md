# Introdução à Linguagem Java


## Estrutura Básica de um Programa Java

Todo programa Java precisa estar dentro de uma **classe**, e a execução começa pelo método `main`.

```java
public class MeuPrograma {
    public static void main(String[] args) {
        System.out.println("Olá, mundo!");
    }
}
```

### Explicando cada parte:

| Elemento | Significado |
|---|---|
| `public class MeuPrograma` | Declara uma classe pública chamada `MeuPrograma`. O nome do arquivo deve ser `MeuPrograma.java` |
| `public static void main(String[] args)` | Método principal, ponto de entrada do programa |
| `System.out.println(...)` | Imprime uma mensagem no console, seguida de quebra de linha |
| `{ }` | Delimitam o início e o fim de blocos de código |
| `;` | Finaliza cada instrução |

> **Dica:** Java é *case-sensitive* (diferencia maiúsculas de minúsculas) e o nome da classe pública deve ser idêntico ao nome do arquivo `.java`.

### Comentários no código

```java
// Comentário de uma linha

/* Comentário
   de múltiplas linhas */

/** Comentário de documentação (Javadoc) */
```

---

## Tipos de Dados

Java é uma linguagem **fortemente tipada**, ou seja, toda variável precisa ter um tipo definido.

### Tipos primitivos

| Tipo | Descrição | Tamanho | Exemplo |
|---|---|---|---|
| `byte` | Número inteiro pequeno | 8 bits | `byte idade = 25;` |
| `short` | Número inteiro curto | 16 bits | `short ano = 2026;` |
| `int` | Número inteiro (mais usado) | 32 bits | `int quantidade = 100;` |
| `long` | Número inteiro grande | 64 bits | `long populacao = 8000000000L;` |
| `float` | Número decimal (precisão simples) | 32 bits | `float preco = 19.99f;` |
| `double` | Número decimal (precisão dupla, mais usado) | 64 bits | `double salario = 3500.75;` |
| `char` | Um único caractere | 16 bits | `char letra = 'A';` |
| `boolean` | Verdadeiro ou falso | 1 bit (lógico) | `boolean ativo = true;` |

### Declaração e atribuição de variáveis

```java
int contador;           // declaração
contador = 1000;        // atribuição

float altura = 1.75f;  // declaração + atribuição na mesma linha

double PI = 3.14159; // sufixo d é opcional para double

char c = 'A';  //aspas simples

boolean contaAtiva = true;

byte idade = 22;

short quantidadeProdutos = 3200;

long populacaoMundial = 7800000000L;

double pi = 3.141592653589793;
```

Ao escrever valores diretamente no código-fonte, estamos utilizando literais. O Java possui regras que determinam o tipo de cada literal.


#### 1. Literais inteiros

Um número inteiro escrito normalmente é considerado um literal do tipo `int`.

```java
int a = 10;
```

Nesse caso, `10` é um literal `int`.

Para indicar que um literal inteiro é do tipo `long`, podemos utilizar o sufixo `L`:

```java
long b = 10L;
```

Também pode ser utilizado `l`, mas recomenda-se usar `L`, pois o `l` minúsculo pode ser confundido visualmente com o número `1`.


#### Por que o `L` é necessário em alguns casos?

O Java considera inicialmente os literais inteiros como `int`. Assim:

```java
long a = 1000;
```

funciona porque o valor `1000` cabe em um `int`, que pode ser convertido automaticamente para `long`.

Porém:

```java
long b = 3000000000;
```

produz erro.

Isso ocorre porque `3000000000` é interpretado inicialmente como um literal `int`, mas esse valor não cabe em um `int`.

Nesse caso, devemos indicar explicitamente que o literal é `long`:

```java
long b = 3000000000L;
```

Portanto:

> O sufixo `L` informa ao compilador que o literal inteiro deve ser tratado como `long`.

---

#### 2. Literais de ponto flutuante

Os números com parte decimal, como `3.5` e `8.25`, são tratados como `double` por padrão.

```java
double x = 3.5;
```

Portanto:

```text
3.5 → double
```

Para indicar que o literal é do tipo `float`, devemos utilizar o sufixo `f` ou `F`:

```java
float a = 3.5f;
float b = 3.5F;
```

Já:

```java
float c = 3.5;
```

produz erro, pois `3.5` é um `double`, e não pode ser atribuído implicitamente a um `float`.

Também é possível realizar uma conversão explícita:

```java
float c = (float) 3.5;
```

Entretanto, normalmente é preferível utilizar o sufixo `f`:

```java
float c = 3.5f;
```

---

#### 3. O sufixo `d`

O sufixo `d` ou `D` pode ser utilizado para indicar que um literal é `double`:

```java
double x = 3.5d;
double y = 3.5D;
```

Porém, esse sufixo é **opcional**, pois `double` já é o tipo padrão para literais de ponto flutuante.

Assim, estas duas declarações são equivalentes:

```java
double x = 3.5;
double y = 3.5d;
```

Na prática, é mais comum escrever:

```java
double x = 3.5;
```

---

#### 4. Resumo dos principais sufixos

| Literal | Tipo |
|---|---|
| `10` | `int` |
| `10L` | `long` |
| `3.5` | `double` |
| `3.5d` | `double` |
| `3.5f` | `float` |
| `'A'` | `char` |
| `true` | `boolean` |

Os sufixos mais importantes são:

- `L` → `long`
- `F` → `float`
- `D` → `double`

O `D` é normalmente desnecessário, pois `double` já é o padrão.



### `String` em Java

Em Java, o tipo de dado String é usado para representar sequências de caracteres.
Não é um tipo primitivo, mas uma classe que define objetos que armazenam texto.
A maneira mais comum de criar uma String é usando um literal de string, que é
simplesmente o texto entre aspas duplas:

```java
String nome = "Maria da Silva"; //aspas duplas para String
```


### Inferência de tipos com `var`

O `var` permite que o compilador infira o tipo da variável a partir do valor utilizado na inicialização.

Por exemplo:

```java
var a = 10; // inferido como int
var b = 10L; //inferido como long
var c = 3.5;  //inferido como double
var d = 3.5f; //inferido como float
var e = "Java"; //inferido como String
var numeros = new int[10]; //array de int
var pessoa = new Pessoa(); //tipo Pessoa
var lista = new ArrayList<String>(); //tipo ArrayList
```

Podemos pensar que o compilador transforma conceitualmente essas declarações em:

```java
int a = 10;
long b = 10L;
double c = 3.5;
float d = 3.5f;
String e = "Java";
```


A inferência de tipos não se limita a literais. O compilador também utiliza o tipo da expressão que inicializa a variável.
Por exemplo:

```java
var resultado = Math.pow(2, 3); 
```

O tipo da variável resultado é inferido como double, já que 
`Math.pow()` retorna `double`.



Portanto, o `var` **não define um tipo novo**. Ele apenas permite que o compilador descubra o tipo a partir da expressão de inicialização.

Variável declarada com var deve ser imediatamente inicializada.

A palavra reservada var só pode ser usada para declarar variáveis locais dentro de
métodos. Não pode ser usada em campos (atributos de classes) ou como tipo de retorno
de métodos.

O tipo da variável é definido no momento da compilação e não pode ser alterado durante
a execução do programa.


### Conversão de tipos (casting)
A conversão de tipos (type casting) em Java é o processo de transformar um valor de um tipo de dado para outro. 

#### Conversão Implícita (Widening Conversion)
Ocorre automaticamente quando um tipo menor é atribuído a um tipo maior, sem perda de dados.

```java
int numero = 10;
double numeroDouble = numero; // conversão implícita -> 10.0

byte b = 10;
short s = b;      // byte para short
int i = s;        // short para int
long l = i;       // int para long
float f = l;      // long para float
double d = f;     // float para double
```



#### Conversão Explícita (Narrowing Conversion)
Quando a conversão pode causar perda de informação, Java normalmente exige que o programador faça a conversão explicitamente.

```java
double valorDecimal = 9.99;
int valorInteiro = (int) valorDecimal; // conversão explícita -> 9
```

```java
public class Main {
    public static void main(String[] args) {
        int a=5, b=2;
        float resultado;

        resultado = a/b;
        System.out.println("Resultado SEM casting: " + resultado);

        resultado = (float) a/b;
        System.out.println("Resultado COM casting: " + resultado);
    }
}
```

---

## Entrada e Saída de Dados

### Saída de dados

```java
System.out.println("Com quebra de linha ao final");
System.out.print("Sem quebra de linha ao final");
System.out.printf("Nome: %s, Idade: %d%n", "Ana", 28); // saída formatada
```

### Entrada de dados

Para ler dados digitados pelo usuário, utilizamos a classe `Scanner`.

```java
import java.util.Scanner;

public class LeituraDados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("Olá, " + nome + "! Você tem " + idade + " anos.");

        scanner.close(); // boa prática: fechar o Scanner ao final
    }
}
```

### Principais métodos do `Scanner`

| Método | Tipo lido |
|---|---|
| `nextInt()` | `int` |
| `nextDouble()` | `double` |
| `nextLong()` | `long` |
| `nextBoolean()` | `boolean` |
| `next()` | `String` (uma palavra, sem espaços) |
| `nextLine()` | `String` (linha inteira) |

> **Atenção:** Após usar `nextInt()`, `nextDouble()` etc., é comum ocorrer um problema ao chamar `nextLine()` em seguida (o "pulo" da leitura), pois esses métodos não consomem a quebra de linha. Uma solução comum é adicionar um `scanner.nextLine()` extra para "limpar" o buffer.

---

## Estruturas de Decisão

Permitem que o programa tome decisões e execute diferentes blocos de código conforme condições.

### `if`, `else if`, `else`

```java
int nota = 75;

if (nota >= 90) {
    System.out.println("Conceito A");
} else if (nota >= 70) {
    System.out.println("Conceito B");
} else if (nota >= 50) {
    System.out.println("Conceito C");
} else {
    System.out.println("Reprovado");
}
```

### Operadores relacionais

| Operador | Significado |
|---|---|
| `==` | Igual a |
| `!=` | Diferente de |
| `>` | Maior que |
| `<` | Menor que |
| `>=` | Maior ou igual a |
| `<=` | Menor ou igual a |

### Operadores lógicos

| Operador | Significado |
|---|---|
| `&&` | E (AND) |
| `\|\|` | OU (OR) |
| `!` | Negação (NOT) |

```java
int idade = 20;
boolean temCarteira = true;

if (idade >= 18 && temCarteira) {
    System.out.println("Pode dirigir.");
}
```

### `switch`

Útil quando há várias comparações de igualdade com a mesma variável.

```java
int diaSemana = 3;
String nomeDia;

switch (diaSemana) {
    case 1:
        nomeDia = "Domingo";
        break;
    case 2:
        nomeDia = "Segunda-feira";
        break;
    case 3:
        nomeDia = "Terça-feira";
        break;
    default:
        nomeDia = "Dia inválido";
}

System.out.println(nomeDia);
```

> A partir do Java 14+, também é possível usar o formato mais moderno:
```java
String nomeDia = switch (diaSemana) {
    case 1 -> "Domingo";
    case 2 -> "Segunda-feira";
    case 3 -> "Terça-feira";
    default -> "Dia inválido";
};
```

---

## Estruturas de Repetição

Permitem executar um bloco de código várias vezes.

### `for`

Ideal quando sabemos o número de repetições.

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Repetição número: " + i);
}
```

- `int i = 1` → inicialização
- `i <= 5` → condição de parada
- `i++` → incremento

### `while`

Ideal quando não sabemos exatamente quantas vezes o laço irá repetir, mas conhecemos a condição de parada.

```java
int contador = 0;

while (contador < 5) {
    System.out.println("Contador: " + contador);
    contador++;
}
```

### `do-while`

Garante que o bloco seja executado **pelo menos uma vez**, pois a condição é verificada ao final.

```java
int numero;
Scanner scanner = new Scanner(System.in);

do {
    System.out.print("Digite um número positivo: ");
    numero = scanner.nextInt();
} while (numero <= 0);
```

### `for-each` (usado com arrays e coleções)

```java
int[] numeros = {10, 20, 30, 40};

for (int numero : numeros) {
    System.out.println(numero);
}
```

### `break` e `continue`

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break; // interrompe totalmente o laço
    }
    System.out.println(i);
}

for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue; // pula apenas essa repetição
    }
    System.out.println(i);
}
```

---

## Array (Vetor)

Um array armazena **múltiplos valores do mesmo tipo** em uma única variável.

### Declaração e inicialização

```java
// Declarando com tamanho fixo
int[] idades = new int[5]; // array com 5 posições (índices 0 a 4)

// Declarando e inicializando com valores
int[] numeros = {10, 20, 30, 40, 50};

String[] nomes = {"Ana", "Bruno", "Carla"};
```

### Acessando e alterando elementos

```java
System.out.println(numeros[0]); // imprime 10 (primeiro elemento)
numeros[1] = 99;                // altera o segundo elemento para 99
```

> **Atenção:** os índices de um array em Java começam em **0**. O último índice válido é `tamanho - 1`.

### Percorrendo um array

```java
int[] numeros = {10, 20, 30, 40, 50};

// Usando for tradicional
for (int i = 0; i < numeros.length; i++) {
    System.out.println("Posição " + i + ": " + numeros[i]);
}

// Usando for-each
for (int numero : numeros) {
    System.out.println(numero);
}
```

### Arrays multidimensionais (matrizes)

```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
    }
    System.out.println();
}
```

---

## Métodos

Métodos são blocos de código reutilizáveis que executam uma tarefa específica.

### Estrutura de um método

```java
modificador tipoRetorno nomeMetodo(parametros) {
    // corpo do método
    return valor; // se houver retorno
}
```

### Exemplo de método sem retorno (void)

```java
public class Exemplo {

    public static void saudacao(String nome) {
        System.out.println("Olá, " + nome + "!");
    }

    public static void main(String[] args) {
        saudacao("João"); // chamada do método
    }
}
```

### Exemplo de método com retorno

```java
public class Calculadora {

    public static int somar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int resultado = somar(5, 3);
        System.out.println("Resultado: " + resultado); // Resultado: 8
    }
}
```

### Por que usar métodos?

- **Reutilização de código** – evita repetição
- **Organização** – facilita a leitura e manutenção
- **Divisão de responsabilidades** – cada método faz uma tarefa específica

---