# FAQ sobre Programação Orientada a Objetos


### O que é Programação Orientada a Objetos (POO)?
A Programação Orientada a Objetos (POO) é um estilo de programação que estrutura o código em torno de 'objetos', unidades de software que colaboram entre si para solucionar problemas.

### Quais os pilares da POO?
São 4 pilares:

* Abstração: Refere-se à capacidade de esconder a complexidade e mostrar apenas as informações essenciais. 
* Encapsulamento: Refere-se ao conceito de esconder os detalhes internos de um objeto e fornecer métodos públicos para interagir com ele, garantindo maior controle sobre como os dados são acessados ou modificados.
* Herança: Permite que uma classe herde atributos e métodos de outra classe. A classe que herda é chamada de classe filha, e a classe original é a classe mãe.
* Polimorfismo: Permite que diferentes classes implementem o mesmo método de maneira distinta. O polimorfismo permite que o código trate objetos de diferentes tipos de maneira uniforme.

### O que são objetos?
Objetos são representações computacionais (domínio da solução) de entidades (concretas ou abstratas) do mundo real (domínio do problema). Possuem atributos e comportamentos. Um objeto é uma instância de uma classe.

### O que é uma classe?
uma classe é como um molde ou um modelo para criar objetos. Ela define a estrutura e o comportamento que os objetos terão. Pense em uma classe como uma planta de construção para casas: a planta descreve como as casas serão construídas, mas não é uma casa em si. Os objetos são as casas reais construídas a partir da planta.

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

### O que são métodos getters e setters?
Getters e Setters são métodos usados para acessar e modificar, respectivamente, os atributos privados de uma classe, seguindo o princípio de encapsulamento.
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

### O que é sobrecarga de método (method overloading)?
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

### O que são atributos e métodos static?
São atributos e métodos que pertencem à classe e não a um objeto específico. Eles são compartilhados por todas as instâncias da classe. Atributos estáticos são úteis para armazenar informações que são comuns a todos os objetos da classe. Métodos estáticos são úteis para operações que não dependem do estado de um objeto. São invocados diretamente pela classe, sem a necessidade de criar uma instância. 

### O que é associação entre classes?
Associação é um relacionamento entre duas ou mais classes, indicando que objetos dessas classes se comunicam ou interagem entre si. É uma forma de modelar dependências e conexões no sistema.

### O que é multiplicidade em uma associação?
Multiplicidade especifica o número de objetos de uma classe que podem se relacionar com um objeto de outra classe. As multiplicidades mais comuns são:

* 1: Um objeto se relaciona com exatamente um objeto.
* 0..1: Um objeto se relaciona com zero ou um objeto.
* \* (ou 0..*): Um objeto se relaciona com zero ou muitos objetos.
* 1..*: Um objeto se relaciona com um ou muitos objetos.
* n..m: Um objeto se relaciona com no mínimo "n" e no máximo "m" objetos.

### O que é navegabilidade em uma associação?
Navegabilidade define a direção em que a associação pode ser percorrida. Em outras palavras, indica se um objeto de uma classe pode acessar ou "conhecer" objetos da outra classe. A navegabilidade pode ser unidirecional ou bidirecional.
