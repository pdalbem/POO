
# API Stream em Java

A **API Stream**, introduzida no Java 8, permite processar coleções de forma funcional, concisa e eficiente. Com ela, é possível aplicar transformações, filtros e operações de agregação de forma declarativa.

---

## O que é uma Stream?

Uma **Stream** é uma sequência de elementos que pode ser processada em cadeia, sem alterar a coleção original.

- **Não** armazena dados.
- É **imutável**.
- Suporta **operações em pipeline**.
- Pode ser **sequencial** ou **paralela**.

---

## Estrutura de uma Stream

Uma operação com stream geralmente segue esta sequência:

1. **Fonte de dados** (coleção, array, etc.)
2. **Operações intermediárias** (filter, map, sorted, etc.)
3. **Operação terminal** (collect, forEach, count, etc.)

---

## Exemplo básico

```java
List<String> nomes = List.of("Ana", "Carlos", "Amanda", "João");

nomes.stream()
    .filter(nome -> nome.startsWith("A"))
    .map(String::toUpperCase)
    .forEach(System.out::println);
```

# Operações Comuns em Stream (Java)

A API `Stream` do Java oferece diversas operações para processar dados de forma fluente, funcional e eficiente. Elas se dividem em dois tipos:

- **Intermediárias**: retornam outra Stream (lazy — avaliação preguiçosa).
- **Terminais**: encerram a Stream e produzem um resultado.

---

## Operações Intermediárias

Essas operações transformam ou filtram os dados. São **lazy**, ou seja, só são executadas quando uma operação terminal é chamada.

### 1. `filter(Predicate)`

Filtra elementos com base em uma condição.

```java
stream.filter(x -> x > 10);
```

### 2. `map(Function)`

Transforma os elementos da stream.

```java
stream.map(String::toUpperCase);
```

### 3. `flatMap(Function)`

"Achata" estruturas aninhadas (como listas de listas).

```java
List<List<String>> nomes = List.of(
    List.of("Ana", "Carlos"),
    List.of("João", "Amanda")
);

List<String> todosNomes = nomes.stream()
    .flatMap(List::stream)
    .collect(Collectors.toList());

// Resultado: ["Ana", "Carlos", "João", "Amanda"]
```

### 4. `distinct()`

Remove elementos duplicados (com base em `equals`).

```java
stream.distinct();
```

### 5. `sorted()`

Ordena os elementos (usa `Comparable` ou um `Comparator`).

```java
stream.sorted();
stream.sorted(Comparator.reverseOrder());
```

### 6. `limit(n)`

Limita o número de elementos.

```java
stream.limit(5);
```

### 7. `skip(n)`

Ignora os primeiros `n` elementos.

```java
stream.skip(3);
```

---

## Operações Terminais

Essas operações encerram a stream e produzem um resultado.

### 1. `forEach(Consumer)`

Executa uma ação para cada elemento.

```java
stream.forEach(System.out::println);
```

### 2. `collect(Collector)`

Coleta os elementos em uma estrutura como `List`, `Set`, `Map`.

```java
List<String> lista = stream.collect(Collectors.toList());
```

### 3. `reduce(...)`

Reduz os elementos a um único valor (soma, concatenação, etc.).

```java
List<Integer> numeros = List.of(1, 2, 3, 4, 5);

int soma = numeros.stream()
    .reduce(0, Integer::sum); // ou (a, b) -> a + b
```

### 4. `count()`

Conta os elementos da stream.

```java
long total = stream.count();
```

### 5. `anyMatch(Predicate)`

Retorna `true` se **algum** elemento corresponder à condição.

```java
stream.anyMatch(x -> x > 10);
```

### 6. `allMatch(Predicate)`

Retorna `true` se **todos** os elementos corresponderem à condição.

```java
stream.allMatch(x -> x != null);
```

### 7. `noneMatch(Predicate)`

Retorna `true` se **nenhum** elemento corresponder à condição.

```java
stream.noneMatch(String::isEmpty);
```

### 8. `findFirst()`

Retorna o **primeiro** elemento (como `Optional`).

```java
Optional<String> primeiro = stream.findFirst();
```

### 9. `findAny()`

Retorna **algum** elemento (útil em streams paralelos).

```java
Optional<String> qualquer = stream.findAny();
```

---

## Streams Encadeadas

Streams podem ser **encadeadas** para criar pipelines elegantes e legíveis. Exemplo:

```java
List<Integer> lista = List.of(1, 2, 3, 4, 5, 6);

int somaPares = lista.stream()
    .filter(n -> n % 2 == 0)
    .mapToInt(Integer::intValue)
    .sum();
```


## Agrupando com `Collectors.groupingBy`

### Exemplo 1: Agrupando nomes por tamanho

```java
List<String> nomes = List.of("Ana", "Carlos", "João", "Amanda");

Map<Integer, List<String>> agrupadoPorTamanho = nomes.stream()
    .collect(Collectors.groupingBy(String::length));
```

### Exemplo 2: Agrupando com contagem

```java
Map<Integer, Long> contagemPorTamanho = nomes.stream()
    .collect(Collectors.groupingBy(
        String::length,
        Collectors.counting()
    ));
```

### Exemplo 3: Agrupando com transformação dos valores

```java
Map<Integer, Set<String>> agrupadoComSet = nomes.stream()
    .collect(Collectors.groupingBy(
        String::length,
        Collectors.toSet()
    ));
```

---

## Referência

- [Java Streams - Oracle Docs](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)

---