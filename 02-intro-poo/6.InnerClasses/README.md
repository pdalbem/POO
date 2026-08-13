# Inner Classes (Classes Internas)
No Java, **inner classes** (ou classes internas) são classes declaradas **dentro de outra classe**.  
Elas existem principalmente para **agrupar logicamente classes que só fazem sentido dentro de outra**  
e para facilitar o acesso a membros privados da classe externa.

---

## Tipos de Inner Classes

## 1. **Inner Class (não-estática)**
- Definida dentro de outra classe.
- Tem acesso direto a todos os membros (inclusive `private`) da classe externa.
- Precisa de uma instância da classe externa para ser instanciada.

**Exemplo:**
```java
class Externa {
    private String mensagem = "Olá da classe Externa!";

    class Interna {
        void exibirMensagem() {
            System.out.println(mensagem);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Externa externa = new Externa();
        Externa.Interna interna = externa.new Interna();
        interna.exibirMensagem();
    }
}
```

## 1. **Inner Class (estática)**

- Declarada com o modificador `static`.  
- **Não** tem acesso direto a membros de instância da classe externa.  
- Pode ser instanciada **sem** criar um objeto da classe externa.  

**Exemplo:**
```java
class Externa {
    static class Interna {
        void exibirMensagem() {
            System.out.println("Sou uma inner class estática!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Externa.Interna interna = new Externa.Interna();
        interna.exibirMensagem();
    }
}
```

## 3. Local Inner Class

- Definida dentro de um **método**, **construtor** ou **bloco**.  
- Só é visível dentro do **escopo onde foi criada**.  
- Pode acessar variáveis locais do método se forem `final` ou **efetivamente finais**.  

**Exemplo:**
```java
class Externa {
    void metodoComClasseInterna() {
        class Interna {
            void exibir() {
                System.out.println("Classe interna local dentro de um método!");
            }
        }
        Interna interna = new Interna();
        interna.exibir();
    }
}

public class Main {
    public static void main(String[] args) {
        new Externa().metodoComClasseInterna();
    }
}
```

## 4. Anonymous Inner Class

- Classe **sem nome** usada para sobrescrever métodos ou implementar interfaces **rapidamente**.  
- Muito utilizada com **interfaces funcionais** ou **classes abstratas**.  

**Exemplo:**
```java
abstract class Saudacao {
    abstract void dizerOla();
}

public class Main {
    public static void main(String[] args) {
        Saudacao s = new Saudacao() {
            @Override
            void dizerOla() {
                System.out.println("Olá de uma classe interna anônima!");
            }
        };
        s.dizerOla();
    }
}
```

## Vantagens das Inner Classes

- Organização lógica de classes que só fazem sentido dentro de outra.  
- Melhor encapsulamento, podendo acessar membros privados da classe externa.  
- Úteis para **callbacks**, **eventos** e **simplificação de código**.  

---

## Quando usar?

- Quando uma classe é usada **apenas por outra**.  
- Quando se deseja **encapsular lógica** dentro de um método.  
- Quando for necessário criar rapidamente uma implementação de uma interface ou classe abstrata.  

---

## Resumo

| Tipo                 | Onde é declarada                 | Precisa de instância externa? | Acessa membros privados? |
|-----------------------|----------------------------------|--------------------------------|---------------------------|
| Inner Class           | Dentro da classe                | Sim                            | Sim                       |
| Static Nested Class   | Dentro da classe (com `static`) | Não                            | Não (apenas membros estáticos) |
| Local Inner Class     | Dentro de um método/construtor  | Sim                            | Sim (variáveis `final`/efetivamente finais) |
| Anonymous Inner Class | Expressão única                 | Sim                            | Sim                       |


