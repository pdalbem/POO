# Generics em Java: Adicionando Segurança de Tipo e Reusabilidade ao seu Código

Generics são um recurso poderoso introduzido no Java 5 que permite parametrizar tipos em classes, interfaces e métodos. Isso proporciona maior segurança de tipo em tempo de compilação e aumenta a reusabilidade do código, eliminando a necessidade de *casts* explícitos e reduzindo o risco de erros de `ClassCastException`.

## O Problema que os Generics Resolvem

Antes dos generics, coleções como `ArrayList` armazenavam objetos do tipo `Object`. Isso exigia que o desenvolvedor realizasse um *cast* (conversão de tipo) ao recuperar elementos da coleção. Essa abordagem apresentava dois principais problemas:

1.  **Falta de Segurança de Tipo em Tempo de Compilação:** Era possível adicionar objetos de qualquer tipo a uma coleção, e erros de tipo só eram descobertos em tempo de execução, quando um *cast* inválido era tentado.
2.  **Código Verboso e Propenso a Erros:** A necessidade constante de realizar *casts* tornava o código mais longo e aumentava a chance de erros de `ClassCastException` se o tipo errado fosse especificado.

## Como Funcionam os Generics

Generics permitem que você defina *tipos de parâmetro* para classes, interfaces e métodos. Esses parâmetros de tipo atuam como placeholders que são substituídos por tipos concretos quando a classe, interface ou método é utilizado.

A sintaxe para declarar e usar generics envolve o uso de colchetes angulares `<>` para especificar o parâmetro de tipo. Por convenção, letras maiúsculas únicas são usadas como nomes de parâmetros de tipo (por exemplo, `T` para Tipo, `E` para Elemento, `K` para Chave, `V` para Valor).

## Exemplos de Uso de Generics

### Classes Genéricas

Você pode criar classes que funcionam com diferentes tipos de dados sem precisar escrever código duplicado.

```java
class Caixa<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public static void main(String[] args) {
        Caixa<Integer> caixaDeInteiro = new Caixa<>();
        caixaDeInteiro.setItem(10);
        int valor = caixaDeInteiro.getItem(); // Não precisa de cast

        Caixa<String> caixaDeString = new Caixa<>();
        caixaDeString.setItem("Olá");
        String texto = caixaDeString.getItem(); // Não precisa de cast
    }
}
```

### Interfaces Genéricas
Interfaces também podem ser parametrizadas com tipos.
```java
interface Par<K, V> {
    K getKey();
    V getValue();
}

class ParImpl<K, V> implements Par<K, V> {
    private K key;
    private V value;

    public ParImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new ParImpl<>("idade", 30);
        String chave = par1.getKey();
        Integer valor = par1.getValue();

        Par<Integer, String> par2 = new ParImpl<>(1, "Um");
        Integer chave2 = par2.getKey();
        String valor2 = par2.getValue();
    }
}
```
### Métodos Genéricos
Você pode definir métodos que são genéricos, mesmo que a classe em que eles estejam não seja genérica.
```java
class Utilitarios {
    public static <T> void imprimirArray(T[] array) {
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] numeros = {1, 2, 3, 4, 5};
        String[] palavras = {"Java", "Generics", "Exemplo"};

        imprimirArray(numeros); // T é inferido como Integer
        imprimirArray(palavras); // T é inferido como String
    }
}
```

## Wildcards
Wildcards (?) são usados para representar tipos desconhecidos em generics. Eles são úteis em situações onde o tipo específico não importa ou quando você quer trabalhar com uma família de tipos. Existem três tipos de wildcards:

* ? (Wildcard Ilimitado): Representa qualquer tipo.
```java
public static void imprimirLista(List<?> lista) {
    for (Object elemento : lista) {
        System.out.println(elemento);
    }
}
```
* ? extends AlgumTipo (Wildcard Superior Limitado): Representa um tipo que é AlgumTipo ou um subtipo de AlgumTipo
```java
public static void imprimirListaDeNumeros(List<? extends Number> lista) {
    for (Number numero : lista) {
        System.out.println(numero);
    }
}
```

* ? super AlgumTipo (Wildcard Inferior Limitado): Representa um tipo que é AlgumTipo ou um supertipo de AlgumTipo
```java
public static void adicionarInteiro(List<? super Integer> lista) {
    lista.add(10);
}
```

## Type Erasure
É importante entender que o compilador Java implementa generics através de um processo chamado type erasure (apagamento de tipo). Durante a compilação, as informações de tipo genérico são removidas e o código é transformado para funcionar com o tipo bruto (geralmente Object). Isso garante a compatibilidade com versões mais antigas do Java. No entanto, a verificação de tipo é realizada em tempo de compilação para garantir a segurança.

## Benefícios dos Generics
* Segurança de Tipo em Tempo de Compilação: Erros de tipo são detectados durante a compilação, evitando ClassCastException em tempo de execução.
* Eliminação de Casts: Você não precisa realizar casts ao recuperar objetos de coleções ou usar instâncias de classes genéricas, tornando o código mais limpo e legível.
* Reusabilidade de Código: Permite escrever código que funciona com diferentes tipos sem duplicação.
* Melhor Legibilidade: A especificação de tipo torna o código mais fácil de entender e manter.

### Conclusão
Generics são uma ferramenta essencial em Java para escrever código mais seguro, eficiente e reutilizável. Ao dominar generics, você pode criar aplicações mais robustas e fáceis de manter, aproveitando os benefícios da verificação de tipo em tempo de compilação e da eliminação de casts desnecessários.

