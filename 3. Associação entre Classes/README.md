# Associação entre Classes 
Associação é um relacionamento entre duas ou mais classes, indicando que objetos dessas classes podem se comunicar ou interagir entre si. Esse tipo de relacionamento modela como as classes dependem uma da outra, o que é essencial para entender as conexões e interações dentro do sistema.

Por exemplo, se tivermos as classes Aluno e Curso, podemos representar uma associação entre elas, onde um aluno pode estar matriculado em um ou mais cursos, e um curso pode ter vários alunos matriculados.

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
Aqui, temos um exemplo de associação com **navegabilidade** é bidirecional, ou seja, a classe Curso conhece Aluno e vice-versa. 
A **multiplicidade** desta associação é _um-para-muitos_. Curso pode ter muitos alunos e Aluno só pode ter um curso.
A classe Aluno tem um atributo do tipo Curso, indicando que um aluno está associado a um único curso. Já a classe Curso tem um atributo do tipo List<Aluno>, indicando que um curso pode ter vários alunos matriculados.


## Multiplicidade
A multiplicidade especifica o número de objetos de uma classe que podem se relacionar com um objeto de outra classe. Ela descreve quantos objetos de uma classe podem ser associados a um único objeto de outra classe.

As multiplicidades mais comuns são:
* 1: Um objeto se relaciona com exatamente um objeto.
* 0..1: Um objeto se relaciona com zero ou um objeto.
* \* (ou 0..*): Um objeto se relaciona com zero ou muitos objetos.
* 1..*: Um objeto se relaciona com um ou muitos objetos.
* n..m: Um objeto se relaciona com no mínimo "n" e no máximo "m" objetos.

## Navegabilidade
A navegabilidade define a direção em que a associação pode ser percorrida. Em outras palavras, ela indica se um objeto de uma classe pode acessar ou "conhecer" objetos de outra classe.

A navegabilidade pode ser:
* Unidirecional: Quando um objeto de uma classe pode acessar objetos de outra classe, mas não o contrário.
* Bidirecional: Quando ambos os lados da associação podem acessar objetos da outra classe.

Exemplo de associação unidirecional:

No exemplo abaixo, a classe Aluno conhece a classe Curso, mas a classe Curso não conhece a classe Aluno diretamente.
```java
public class Aluno {
    private String nome;
    private Curso curso; // Unidirecional: Aluno conhece Curso

    // Construtores, getters e setters
    public Aluno(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

public class Curso {
    private String nome;

    // Construtores, getters e setters
    public Curso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
```