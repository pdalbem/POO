# FAQ sobre Programação Orientada a Objetos


### O que é Programação Orientada a Objetos (POO)?
A Programação Orientada a Objetos (POO) é um estilo de programação que estrutura o código em torno de 'objetos', unidades de software que colaboram entre si para solucionar problemas. A POO visa tornar o código mais modular, reutilizável e fácil de manter, permitindo que os desenvolvedores criem sistemas mais robustos e flexíveis.

### Quais os pilares da POO?
São 4 pilares:

* Abstração: Refere-se à capacidade de esconder a complexidade e mostrar apenas as informações essenciais. 
* Encapsulamento: Refere-se ao conceito de esconder os detalhes internos de um objeto e fornecer métodos públicos para interagir com ele, garantindo maior controle sobre como os dados são acessados ou modificados.
* Herança: Permite que uma classe herde atributos e métodos de outra classe. A classe que herda é chamada de classe filha, e a classe original é a classe mãe.
* Polimorfismo: Permite que diferentes classes implementem o mesmo método de maneira distinta. O polimorfismo permite que o código trate objetos de diferentes tipos de maneira uniforme.

### O que são objetos?
Objetos são representações computacionais (domínio da solução) de entidades (concretas ou abstratas) do mundo real (domínio do problema). Os objetos possuem **atributos** (características, propriedades) e **comportamentos** (ações que o objeto pode realizar). Por exemplo, um objetco carro possui os atributos placa, marca, ano e cor, e os comportamentos ligar, acelerar, frear, desligar.

Um objeto é uma instância de uma classe.

### O que é uma classe?
Uma classe é como um molde ou um modelo para criar objetos. Ela define a estrutura e o comportamento que os objetos terão. Pense em uma classe como uma planta de construção para casas: a planta descreve como as casas serão construídas, mas não é uma casa em si. Os objetos são as casas reais construídas a partir da planta.

Por exemplo, uma classe Carro pode ter atributos como placa, modelo, ano e cor, e métodos como acelerar() e frear().

```java
public class Carro {
    String placa;
    String modelo;
    int ano;
    String cor;
    
    public void acelerar(){
    // TODO
    }
    
    public void frear(){
    // TODO
    }
}
```

### O que é método construtor?
Um construtor é um método especial usado para inicializar objetos de uma classe. Ele é chamado automaticamente quando um novo objeto é criado. 
Em Java, o método construtor deve possuir o mesmo nome da classe e não deve ter retorno de valor.
Construtores podem ter parâmetros para permitir a inicialização com valores específicos.
Uma classe pode ter quantos métodos construtores forem necessários (sobrecarga de método, veremos adiante).

```java
public class Carro {
    String placa;
    String modelo;
    int ano;
    String cor;
    
    public Carro(){}
    
    public Carro(String placa, String modelo, int ano, String cor){
        this.placa=placa;
        this.modelo=modelo;
        this.ano=ano;
        this.cor=cor;
    }
    
    public Carro(String placa, String modelo){
        this.placa=placa;
        this.modelo=modelo;
    }
    
    public void acelerar(){
    }
    
    public void frear(){
    }
}
```

### Como instanciar um objeto?
Instanciar um objeto significa criar um exemplar concreto de uma classe. Em Java, isso é feito usando a palavra-chave `new` seguida do método construtor da classe.

```java
Carro carro1 = new Carro();
Carro carro2 = new Carro("IFS-0P10","Fusca", 1990, "branco");
```

### Em Java, o que significa a palavra reservada `this`?
Em Java, a palavra-chave `this` refere-se ao objeto atual da classe onde o código está sendo executado. Ela é usada para distinguir entre variáveis de instância e parâmetros com o mesmo nome, referenciar o objeto atual ou chamar um construtor da mesma classe.

```java
public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome) {
        this(nome, 0); // Chama o construtor com dois parâmetros.
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome; // 'this.nome' refere-se à variável de instância, enquanto 'nome' refere-se à variável local (parâmetro).
        this.idade = idade; // 'this.idade' refere-se à variável de instância, enquanto 'idade' refere-se à variável local (parâmetro).
    }
}
```


### O que são modificadores de acesso?
Modificadores de acesso são palavras-chave que controlam a visibilidade (acesso) de classes, atributos e métodos dentro de um programa. Eles definem quem pode acessar ou modificar esses elementos.

* public: Acesso de qualquer classe, mesmo de pacotes diferentes.
* private: 	Acesso apenas dentro da própria classe.
* protected: Acesso na mesma classe, nas subclasses e no mesmo pacote.
* default:	Acesso apenas dentro do mesmo pacote.

```java
public class Exemplo {
    public int atributoPublico;
    private int atributoPrivado;
    protected int atributoProtegido;
    int atributoPadrao; // Acesso default (package-private)

}    
```

### O que é encapsulamento?
Encapsulamento é o princípio de esconder os detalhes internos de uma classe e fornecer métodos públicos para acessar e modificar os dados de forma controlada. Isso garante que o estado do objeto seja protegido e modificado de maneira segura.
```java
public class ContaBancaria {
    private double saldo;

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
```

### O que são métodos _getters_ e _setters_?
_Getters_ e _Setters_ são métodos usados para acessar e modificar, respectivamente, os atributos privados de uma classe, seguindo o princípio de encapsulamento.
```java
public class Pessoa {
    // Atributos privados
    private String nome;
    private int idade;

    // Getter para o atributo nome
    public String getNome() {
        return nome;
    }

    // Setter para o atributo nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o atributo idade
    public int getIdade() {
        return idade;
    }

    // Setter para o atributo idade
    public void setIdade(int idade) {
        // Podemos adicionar validações dentro do setter
        if (idade > 0) {
            this.idade = idade;
        } else {
            System.out.println("Idade inválida");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando um objeto Pessoa
        Pessoa p = new Pessoa();

        // Usando o setter para definir o nome e idade
        p.setNome("João");
        p.setIdade(25);

        // Usando os getters para acessar o nome e a idade
        System.out.println("Nome: " + p.getNome());
        System.out.println("Idade: " + p.getIdade());
    }
}

```

### O que é sobrecarga de método (_method overloading_)?
Sobrecarga de método ocorre quando a classe possui vários métodos com o mesmo nome, mas com listas de parâmetros diferentes. Isso permite que um método execute ações diferentes dependendo dos argumentos fornecidos. Uma classe que possui mais de um método construtor, já faz sobrecarga de método.

```java
public class Aluno {
    private String nome;
    private String curso;
    private double[] notas = new double[3];

    //sobrecarga de metodo
    public double calcularMedia(){
        double soma=0;
        for (double nota: getNotas())
            soma+=nota;
        return soma/ getNotas().length;
    }

    public double calcularMedia(double[] pesos){
       if (getNotas().length!= pesos.length)
           throw new IllegalArgumentException("ERRO: A quantidade de notas deve ser igual a quantidade de pesos");

        double soma=0;
        double totalPeso=0;
        for (int i = 0; i< getNotas().length; i++){
            soma+= getNotas()[i]*pesos[i];
            totalPeso+=pesos[i];
        }
        if (totalPeso==0)
            throw new ArithmeticException("ERRO: divisão por zero");

        return soma/totalPeso;
    }

    public Aluno() {
        quantidadeAlunos++;
    }

    public Aluno(String nome, String curso) {
        this.setNome(nome);
        this.setCurso(curso);
        quantidadeAlunos++;
    }

    public Aluno(String nome, String curso, double[] notas) {
        this.setNome(nome);
        this.setCurso(curso);
        this.setNotas(notas);
        quantidadeAlunos++;
    }
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
}
```

### O que são atributos e métodos _static_?
São atributos e métodos que pertencem à classe e não a um objeto específico. Eles são compartilhados por todas as instâncias da classe. Atributos estáticos são úteis para armazenar informações que são comuns a todos os objetos da classe. Métodos estáticos são úteis para operações que não dependem do estado de um objeto. São invocados diretamente pela classe, sem a necessidade de criar uma instância. 

```java
class Contador {
    // Atributo static, compartilhado por todas as instâncias da classe
    private static int count = 0;

    public Contador() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        Contador c3 = new Contador();
      
        System.out.println("Número de instâncias de Contador: " + Contador.getCount());
    }
}

```

### O que é associação entre classes?
Associação é um relacionamento entre duas ou mais classes, indicando que objetos dessas classes se comunicam ou interagem entre si. É uma forma de modelar dependências e conexões no sistema.

```java
public class Aluno {
    private String nome;
    private String pontuario;
    private Curso cursos; 
    ...
}    

public class Curso {
    private String nome;
    private List<Aluno> alunos; 
    ...
}    
```

### O que é multiplicidade em uma associação?
Multiplicidade especifica o número de objetos de uma classe que podem se relacionar com um objeto de outra classe. As multiplicidades mais comuns são:

* 1: Um objeto se relaciona com exatamente um objeto.
* 0..1: Um objeto se relaciona com zero ou um objeto.
* \* (ou 0..*): Um objeto se relaciona com zero ou muitos objetos.
* 1..*: Um objeto se relaciona com um ou muitos objetos.
* n..m: Um objeto se relaciona com no mínimo "n" e no máximo "m" objetos.

### O que é navegabilidade em uma associação?
Navegabilidade define a direção em que a associação pode ser percorrida. Em outras palavras, indica se um objeto de uma classe pode acessar ou "conhecer" objetos da outra classe. A navegabilidade pode ser unidirecional ou bidirecional.

### O que é Herança?
Herança é um mecanismo que permite a criação de uma nova classe baseada em uma classe existente. A nova classe (chamada subclasse ou classe filha) herda os atributos e métodos da classe existente (chamada superclasse ou classe pai), permitindo a reutilização de código.

```java
// Classe base (superclasse)
public class Pessoa {
    private String nome;
    private String documento;

    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }
    ...
}

// Subclasse
public class Aluno extends Pessoa {
    private String curso;

    public Aluno(String nome, String documento, String curso) {
        super(nome, documento);
        this.curso = curso;
    }
    ...
}

// Outra subclasse
public class Professor extends Pessoa {
    private String disciplina;

    public Professor(String nome, String documento, String disciplina) {
        super(nome, documento);
        this.disciplina = disciplina;
    }
    ...
}

public class Main {
    public static void main(String[] args) {
        Pessoa aluno = new Aluno("Joaquim", "12345", "ADS");
        Pessoa professor = new Professor("Pablo", "98765", "POO");
    }
}

```

### Em Java, o que significa a palavra reservada _super_?
A palvra reservada _super_ é utilizada para se referir à superclasse(classe base) de um objeto. Por meio dela, podemos acessar os atributos e métodos da superclasse.

```java
public class Pessoa {
    private String nome;
    private String documento;

    // Construtor da classe Pessoa
    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    // Métodos para acessar os valores de nome e documento
    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    // Método para exibir informações de uma pessoa
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Documento: " + documento);
    }
}

// Subclasse (Aluno)
public class Aluno extends Pessoa {
    private String curso;

    // Construtor da classe Aluno
    public Aluno(String nome, String documento, String curso) {
        // Chama o construtor da classe Pessoa usando super(nome, documento)
        super(nome, documento);
        this.curso = curso;
    }

    // Método para exibir as informações do aluno
    @Override
    public void exibirInformacoes() {
        // Chama o método exibirInformacoes() da classe Pessoa
        super.exibirInformacoes(); // Exibe nome e documento
        System.out.println("Curso: " + curso);
    }
}

```

### O que é Sobrescrita de Método (_method overriding_)?
A sobrescrita de método (ou override) ocorre quando uma subclasse fornece sua própria implementação de um método que foi declarado na superclasse. A sobrescrita permite que a subclasse modifique o comportamento do método herdado.


```java
// Classe base (superclasse)
public class Pessoa {
    private String nome;
    private String documento;

    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public void apresentar() {
        System.out.println("Meu nome é " + nome + " e meu documento é " + documento);
    }
}

// Subclasse
public class Aluno extends Pessoa {
    private String curso;

    public Aluno(String nome, String documento, String curso) {
        super(nome, documento);
        this.curso = curso;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Eu sou aluno do curso de " + curso);
    }
}

// Outra subclasse
public class Professor extends Pessoa {
    private String disciplina;

    public Professor(String nome, String documento, String disciplina) {
        super(nome, documento);
        this.disciplina = disciplina;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Eu sou professor de " + disciplina);
    }
}

public class Main {
    public static void main(String[] args) {
        Pessoa aluno = new Aluno("Joaquim", "12345", "ADS");
        Pessoa professor = new Professor("Pablo", "98765", "POO");

        aluno.apresentar();  // Saída: Meu nome é Joaquim e meu documento é 12345 | Eu sou aluno do curso de ADS
        professor.apresentar();  // Saída: Meu nome é Pablo e meu documento é 98765 | Eu sou professor de POO
    }
}

```

### Em Java, o que significa a palavra reservada _final_?
Em Java, a palavra reservada _final_ tem vários usos, dependendo de onde ela é aplicada.
* Variável final: Quando uma variável é declarada como `final`, ela se torna uma constante. Ou seja, seu valor não pode ser alterado após a inicialização.
```java
final int NUMERO_MAXIMO = 100;
// NUMERO_MAXIMO = 101; // Isso geraria um erro de compilação
```
* Método final: Quando um método é declarado como `final`, ele não pode ser sobrescrito (_overridden_) nas classes filhas.
```java
class ClassePai {
    final void metodoFinal() {
        // Implementação do método
    }
}

class ClasseFilha extends ClassePai {
    // void metodoFinal() { } // Isso geraria um erro de compilação
}
```
* Classe final: Quando uma classe é declarada como `final{ , ela não pode ser herdada (não pode ser estendida por outras classes).

```java
final class ClasseFinal {
    // Implementação da classe
}

// class OutraClasse extends ClasseFinal { } Isso geraria um erro de compilação
```

### O que é uma Classe Abstrata?
Uma classe abstrata é uma classe que não pode ser instanciada diretamente. Ela é usada como base para outras classes. Ela pode ter métodos abstratos (sem implementação) e métodos concretos (com implementação). Uma classe abstrata serve para garantir que certas funcionalidades sejam implementadas pelas subclasses.

```java
// Classe abstrata
public abstract class Pessoa {
    private String nome;
    private String documento;

    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }
}
```

### O que é um Método Abstrato?
Um método abstrato é um método declarado em uma classe abstrata, mas sem uma implementação. A implementação do método abstrato é fornecida pelas subclasses da classe abstrata.


```java
// Classe abstrata
public abstract class Pessoa {
    private String nome;
    private String documento;

    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    // Método abstrato
    public abstract void trabalhar(); 

    public void apresentar() {
        System.out.println("Meu nome é " + nome + " e meu documento é " + documento);
    }
}

// Subclasse que implementa o método abstrato
public class Aluno extends Pessoa {
    public Aluno(String nome, String documento) {
        super(nome, documento);
    }

    @Override
    public void trabalhar() {
        System.out.println("Estudando para as provas...");
    }
}

// Subclasse que implementa o método abstrato
public class Professor extends Pessoa {
    public Professor(String nome, String documento) {
        super(nome, documento);
    }

    @Override
    public void trabalhar() {
        System.out.println("Ministrando aulas...");
    }
}

public class Main {
    public static void main(String[] args) {
        Pessoa aluno = new Aluno("João", "12345");
        Pessoa professor = new Professor("Dr. Silva", "98765");

        aluno.trabalhar();  // Saída: Estudando para as provas...
        professor.trabalhar();  // Saída: Ministrando aulas...
    }
}

```

### O que são interfaces?
Interfaces definem um conjunto de métodos abstratos que uma classe deve implementar. Interfaces permitem criar contratos entre classes e promover a flexibilidade e a extensibilidade do código.

### Qual a diferença entre classe abstrata e interface?
* Classe abstrata: Pode conter métodos abstratos e métodos concretos (com implementação). Uma classe pode herdar apenas de uma classe abstrata.
* Interface: Contém apenas métodos abstratos (a partir do Java 8, pode conter métodos _default_ e _static_). Uma classe pode implementar múltiplas interfaces.

### O que é polimorfismo?
Polimorfismo é a capacidade de um objeto assumir diferentes formas ou comportamentos. Isso permite que um método seja chamado em objetos de diferentes classes, desde que eles compartilhem uma interface comum ou sejam subclasses de uma mesma superclasse

### O que são os princípios SOLID?
SOLID é uma sigla que representa cinco princípios muito importantes quando desenvolvemos com o paradigma orientado a objetos. Compreender e aplicar esses princípios permitirá  escrever código de melhor qualidade, fácil de entender, manter, testar e escalar. OS princípios são:
* Single responsibility (Responsabilidade única): Uma classe deve ter apenas uma única responsabilidade. Se uma classe tem uma única responsabilidade, ela tem um único motivo para mudar. Se você precisa alterar uma classe pelos mais variados motivos, você está violando este princípio.
* Open/closed (Aberto/Fechado): Entidades de software devem estar abertas para extensão, mas fechadas para modificação. As classes NÃO devem ser modificadas se já estiverem bem definidas, mas devem permitir que outras classes herdem suas propriedades. 
Trata-se também de projetar componentes onde você não precisaria modificá-los ao incluir novas funcionalidades. 
Assim, é possível adicionar novos comportamentos às classes existentes sem alterar seu código original. Geralmente, isto é feito por meio de herança ou interfaces.
* Liskov substitution (Substituição de Liskov): Estabelece que os objetos de uma classe base podem ser substituídos por objetos de suas subclasses, sem alterar o comportamento do sistema.
* Interface segregation (Segregação de interfaces): Nenhuma classe cliente deve ser forçada a implementar métodos que ela não vai usar!!!
É melhor ter várias interfaces específicas do que uma única interface genérica. 
Isso permite que as classes implementem apenas os métodos que realmente utilizam, evitando dependências desnecessárias e melhorando a coesão.
* Dependency inversion (Inversão de dependência): O código deve depender de abstrações (classes abstratas e interfaces) e não de classes concretas. Além disso, as abstrações não devem depender de detalhes. São os detalhes que devem depender das abstrações. Isso promove um design mais flexível e menos acoplado.

