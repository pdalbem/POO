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

### Tipo referência: `String`

`String` não é um tipo primitivo, mas é extremamente utilizado para representar textos:

```java
String nome = "Maria da Silva";
```

### Declaração e atribuição de variáveis

```java
int idade;        // declaração
idade = 30;        // atribuição

int altura = 175;  // declaração + atribuição na mesma linha

final double PI = 3.14159; // constante (não pode ser alterada)
```

### Conversão de tipos (casting)

```java
double valorDecimal = 9.99;
int valorInteiro = (int) valorDecimal; // conversão explícita -> 9

int numero = 10;
double numeroDouble = numero; // conversão implícita -> 10.0
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