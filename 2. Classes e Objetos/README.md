# Introdução à Programação Orientada a Objetos

A Programação Orientada a Objetos (POO) é um paradigma de programação que estrutura o código em torno de unidades de software chamadas de 'objetos'. Estes objetos interagem entre si para solucionar problemas.


## Classes e Objetos
Objetos são representações computacionais (domínio da solução) de entidades (concretas ou abstratas) do mundo real (domínio do problema). Os objetos possuem atributos (características, propriedades) e comportamentos (métodos, ações que o objeto pode realizar). 
Por exemplo, se considerarmos um objeto carro, algumas de suas propriedades serão: cor, marca, modelo e ano de fabricação.Já os métodos podem ser acelerar, frear ou virar.

Um outro exemplo: o objeto conta bancária com os atributos número da conta, titular e saldo. Os métodos poderiam ser depositar, sacar, transferir e consultar o saldo.

Os objetos permitem estruturar seu código em módulos autônomos. Cada objeto tem sua lógica interna e pode interagir com outros objetos através de interfaces definidas. Eles podem ser reutilizados em diferentes partes do programa ou mesmo em outros projetos, evitando a necessidade de escrever código repetitivo. Os objetos permitem ocultar detalhes internos de implementação para obter um código claro e consistente. Mais ainda, eles podem ser desenvolvidos de forma independente, o que facilita a colaboração entre programadores. 

Na POO, um objeto é criado a partir de uma classe. Por isso, dizemos que o objeto é uma instância de uma classe. A classe é um modelo que define a estrutura e as características comuns que todos os objetos do mesmo tipo possem. Você pode criar vários objetos a partir de uma única classe, cada um terá seus próprios valores e poderá executar as operações definidas por essa classe.

Exemplo da classe Carro em Java:

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

## Instanciando objetos

Instanciar um objeto significa criar um exemplar concreto de uma classe. Em Java, isso é feito usando a palavra-chave new seguida do método construtor da classe.

```java
Carro carro1 = new Carro();
Carro carro2 = new Carro("IFS-0P10","Fusca", 1990, "branco");
```

## Método construtor
Um construtor é um método especial usado para inicializar objetos de uma classe. Ele é chamado automaticamente quando um novo objeto é criado e sua principal função é configurar o estado inicial do objeto.

Características do Construtor:
* Nome igual ao nome da classe: O nome do construtor deve ser o mesmo da classe onde ele é definido.

* Sem tipo de retorno: Ao contrário de outros métodos, o construtor não tem tipo de retorno, nem mesmo void.

* Pode ser sobrecarregado: Você pode ter múltiplos construtores na mesma classe, desde que cada um tenha uma lista de parâmetros diferente (isso é chamado de sobrecarga de construtores).

Quando você cria uma classe em Java, se não definir explicitamente um construtor, o compilador Java fornece um construtor padrão implicitamente. Este construtor padrão não recebe parâmetros.

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

```

## Modificadores de acesso
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

## Encapsulamento
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

## Métodos _getters_ e _setters_
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

### Sobrecarga de método (_method overloading_)
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

### Atributos e métodos _static_
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