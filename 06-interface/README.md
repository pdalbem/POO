# Interface
Uma interface é um contrato que define um conjunto de métodos (e, em algumas linguagens, constantes) que uma classe deve implementar. Ela especifica o que uma classe deve fazer, mas não como ela deve fazer. Em outras palavras, uma interface define um comportamento que as classes que a implementam devem seguir.

Aqui estão os pontos chave sobre interfaces:

* Define um contrato: Uma interface atua como um contrato entre a interface e as classes que a implementam. Qualquer classe que "assina" esse contrato (implementa a interface) garante que fornecerá implementações para todos os métodos definidos na interface.
* Contém apenas declarações de métodos (geralmente): Tipicamente, uma interface contém apenas as assinaturas dos métodos (nome, parâmetros, tipo de retorno) sem qualquer corpo de implementação. Em algumas linguagens mais modernas, interfaces podem incluir métodos com implementação padrão (default methods).
* Não pode ser instanciada: Assim como classes abstratas, interfaces não podem ser instanciadas diretamente. Seu propósito é ser implementado por outras classes.
* Uma classe pode implementar múltiplas interfaces: Uma das vantagens das interfaces sobre a herança múltipla de classes é que uma classe pode implementar várias interfaces. Isso permite que uma classe adote comportamentos de diferentes "tipos" ou "contratos".
* Foco no "o quê", não no "como": Interfaces se concentram em definir o que uma classe deve ser capaz de fazer, sem se preocupar com os detalhes de como essa funcionalidade é implementada.
* Promove o acoplamento fraco: Ao programar para uma interface em vez de uma implementação concreta, você reduz a dependência entre os componentes do seu sistema, tornando-o mais flexível e fácil de manter.

### Propósito e Benefícios das Interfaces:

* Definir um comportamento comum: Interfaces estabelecem um conjunto de métodos que diferentes classes podem implementar, garantindo um comportamento comum para aqueles que compartilham essa interface.
* Alcançar herança múltipla (de comportamento): Em linguagens que não suportam herança múltipla de classes, interfaces permitem que uma classe herde múltiplos conjuntos de métodos (comportamentos) de diferentes interfaces.
* Promover o polimorfismo: Objetos de classes diferentes que implementam a mesma interface podem ser tratados de forma uniforme através da referência da interface. Isso permite escrever código mais genérico e flexível.
* Separar a especificação da implementação: Interfaces separam a definição do comportamento da sua implementação concreta. Isso facilita a troca de implementações sem afetar o código que depende da interface.
* Testabilidade: Interfaces facilitam a criação de mocks e stubs para testes unitários, pois você pode criar implementações falsas da interface para isolar o componente que está sendo testado.
* Design flexível e extensível: Interfaces tornam o design do sistema mais flexível e extensível, permitindo adicionar novas funcionalidades implementando interfaces existentes em novas classes.

Exemplo:
```java
public interface Pagamento {
    void processarPagamento(double valor);
}

public class CartaoCredito implements Pagamento{
    private String numeroCartao;

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando o pagamento no valor de "+valor+" via cartão de crédito número "+numeroCartao);
    }

    public CartaoCredito(String numeroCartao) {
        this.setNumeroCartao(numeroCartao);
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}

public class Pix implements Pagamento{
    private String chavePix;

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando o pagamento no valor de "+valor+" via PIX chave "+chavePix);
    }

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}

public class Main {
    public static void main(String[] args) {
        Pagamento cartao = new CartaoCredito("4444.5555.6666.7777");
        Pagamento pix = new Pix("987456");

        cartao.processarPagamento(1500.00);
        pix.processarPagamento(300.00);
    }
}
```
# Classe abstrata __vs__ Interface
A escolha entre uma classe abstrata e uma interface depende dos requisitos específicos do seu design e dos relacionamentos entre as classes em seu sistema.
Na tabela abaixo podemos ver um comparativo entre classes abstrata e interface.

| Característica         | Classe Abstrata                                                     | Interface                                                                 |
|------------------------|----------------------------------------------------------------------|---------------------------------------------------------------------------|
| **Instanciação** | Não pode ser instanciada diretamente.                                 | Não pode ser instanciada diretamente.                                     |
| **Métodos** | Pode conter métodos abstratos (sem implementação) e concretos (com implementação). | Geralmente contém apenas declarações de métodos abstratos (sem implementação). Em algumas linguagens modernas, pode ter métodos com implementação padrão (default methods). |
| **Atributos** | Pode conter atributos (variáveis de instância).                       | Geralmente não contém atributos de instância (apenas constantes estáticas finais em algumas linguagens). |
| **Construtores** | Pode ter construtores (usados pelas subclasses via `super()`).        | Não pode ter construtores.                                                |
| **Herança** | Uma classe pode herdar de **apenas uma** classe abstrata (herança única). | Uma classe pode implementar **múltiplas** interfaces (herança múltipla de tipo). |
| **Propósito Principal** | Fornecer uma **base comum com alguma implementação** para subclasses relacionadas. Define um "é-um" (is-a) parcial. | Definir um **contrato de comportamento** que classes não relacionadas podem implementar. Define um "é capaz de" (can-do) ou "tem a capacidade de" (has-the-ability-to). |
| **Estado** | Pode manter estado através de seus atributos.                         | Geralmente não mantém estado diretamente (o estado é mantido pelas classes que a implementam). |
| **Evolução** | Adicionar um novo método concreto em uma classe abstrata não quebra necessariamente as subclasses existentes. Adicionar um novo método abstrato geralmente quebra as subclasses a menos que elas sejam abstratas também. | Adicionar um novo método a uma interface pode quebrar todas as classes que a implementam (a menos que a linguagem suporte métodos padrão). |
| **Uso Comum** | Usada quando há um relacionamento "é-um" forte entre as classes e algum comportamento comum pode ser implementado na classe base. | Usada para definir funcionalidades que classes de diferentes hierarquias podem compartilhar. Foco no comportamento. |

* Use classes abstratas quando você tem uma hierarquia de classes relacionadas e quer fornecer alguma implementação base compartilhada, além de forçar subclasses a implementar certos métodos. Há um forte senso de "é-um".
* Use interfaces para definir um contrato de comportamento que classes não necessariamente relacionadas podem implementar. O foco está no "o que" as classes podem fazer, independentemente de sua posição na hierarquia de herança. Permite alcançar um tipo de "herança múltipla" de comportamento.

# Interface Funcional
Uma interface funcional é uma interface que contém exatamente um método abstrato (além de outros métodos padrão ou estáticos que possam existir). O conceito de interface funcional é particularmente relevante em linguagens de programação que suportam expressões lambda ou closures (como Java 8 e posterior, Kotlin, Scala, etc.), pois essas expressões podem ser usadas para fornecer implementações concisas para o único método abstrato da interface.

### Características Principais de uma Interface Funcional:

* Exatamente um método abstrato: Esta é a característica definidora. A interface pode ter outros métodos, mas apenas um deles não pode ter uma implementação padrão.
* Pode ter métodos padrão (default methods): Introduzidos no Java 8, os métodos padrão fornecem uma implementação padrão para um método dentro da própria interface. Eles não contam como métodos abstratos.
* Pode ter métodos estáticos: Interfaces também podem conter métodos estáticos com implementação. Estes também não contam como métodos abstratos.
* Pode herdar de outras interfaces: Se uma interface herda de outra, e a interface pai tiver métodos abstratos, a interface filha só será funcional se, após a herança, ela ainda tiver exatamente um método abstrato não implementado.
* Anotação ```@FunctionalInterface``` (em Java): Em Java, a anotação @FunctionalInterface é uma anotação opcional que pode ser usada para indicar que uma interface pretende ser uma interface funcional. O compilador Java verifica se a interface anotada realmente atende aos requisitos de uma interface funcional e gera um erro se não.

### Propósito e Benefícios das Interfaces Funcionais:

* Suporte para expressões lambda e closures: O principal propósito das interfaces funcionais é serem o tipo de destino para expressões lambda e referências de métodos. Uma expressão lambda fornece uma maneira concisa de implementar o único método abstrato de uma interface funcional.
* Programação funcional: Elas são um pilar da programação funcional em linguagens orientadas a objetos, permitindo tratar funções como cidadãos de primeira classe.
* Código mais conciso e legível: O uso de expressões lambda com interfaces funcionais pode levar a um código mais curto, direto e fácil de entender, especialmente ao lidar com operações como callbacks, eventos ou processamento de dados.
* APIs mais expressivas: Muitas APIs modernas utilizam interfaces funcionais para definir comportamentos que podem ser personalizados pelo usuário de forma elegante. Exemplos incluem Runnable, Callable, Predicate, Function, Consumer em Java.

Exemplo:
```java
@FunctionalInterface
interface Operacao {
    int executar(int a, int b); // Único método abstrato
}

public class Main {
    public static void main(String[] args) {
        // Implementação da interface funcional usando uma expressão lambda
        Operacao adicao = (x, y) -> x + y;
        Operacao subtracao = (x, y) -> x - y;

        System.out.println("Adição: " + adicao.executar(5, 3)); // Saída: Adição: 8
        System.out.println("Subtração: " + subtracao.executar(5, 3)); // Saída: Subtração: 2

        // Exemplo com uma interface funcional predefinida
        java.util.function.Predicate<Integer> isPar = n -> n % 2 == 0;
        System.out.println("5 é par? " + isPar.test(5)); // Saída: 5 é par? false
        System.out.println("4 é par? " + isPar.test(4)); // Saída: 4 é par? true
    }
}
```
A interface Operacao define um único método abstrato executar, que é implementado usando expressões lambda para realizar adição e subtração.
A interface java.util.function.Predicate é um exemplo de uma interface funcional predefinida na API Java.

Em resumo, interfaces funcionais são um conceito chave para habilitar a programação funcional e o uso de expressões lambda em linguagens orientadas a objetos, promovendo um código mais conciso e expressivo ao lidar com comportamentos como funções.