# Princípios SOLID
Os princípios SOLID são um conjunto de cinco princípios de design de software que visam tornar os projetos orientados a objetos mais compreensíveis, flexíveis e fáceis de manter. Eles foram popularizados por Robert C. Martin (Uncle Bob).

Cada letra de SOLID representa um princípio:

## S — Single Responsibility Principle (Princípio da Responsabilidade Única)
Uma classe deve ter um, e apenas um, motivo para mudar.

❌ Exemplo incorreto:
```java
// Contraexemplo: Uma classe com múltiplas responsabilidades
class Funcionario {
    private String nome;
    private String email;

    public Funcionario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void salvarFuncionarioNoBanco(Funcionario funcionario) {
        // Lógica para salvar o funcionário no banco de dados
        System.out.println("Funcionário " + funcionario.getNome() + " salvo no banco.");
    }

    public void enviarEmailDeBoasVindas(Funcionario funcionario) {
        // Lógica para enviar um e-mail de boas-vindas
        System.out.println("E-mail de boas-vindas enviado para " + funcionario.getEmail());
    }
}
```
Neste exemplo, a classe Funcionario tem duas responsabilidades: gerenciar informações do funcionário e persistir/notificar o funcionário. Se a lógica de persistência mudar (por exemplo, mudar o banco de dados) ou a lógica de envio de e-mail mudar, essa classe precisará ser modificada.


✅ Exemplo correto:
```java
// Classe para representar o funcionário
class Funcionario {
    private String nome;
    private String email;

    public Funcionario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}

// Classe para persistir o funcionário
class FuncionarioRepository {
    public void salvar(Funcionario funcionario) {
        System.out.println("Funcionário " + funcionario.getNome() + " salvo no banco.");
    }
}

// Classe para enviar e-mails relacionados a funcionários
class NotificadorDeFuncionario {
    public void enviarEmailDeBoasVindas(Funcionario funcionario) {
        System.out.println("E-mail de boas-vindas enviado para " + funcionario.getEmail());
    }
}
```
Agora, cada classe tem uma única responsabilidade. Mudanças na persistência não afetarão a lógica de notificação e vice-versa.

## O — Open/Closed Principle (Princípio Aberto/Fechado)
Classes devem estar abertas para extensão, mas fechadas para modificação. Isso significa que você deve ser capaz de adicionar novas funcionalidades sem alterar o código existente.


❌ Exemplo incorreto:
```java
// Contraexemplo: Classe que precisa ser modificada para adicionar novas formas
class Desenho {
    public void desenharForma(String tipo) {
        if (tipo.equals("circulo")) {
            desenharCirculo();
        } else if (tipo.equals("retangulo")) {
            desenharRetangulo();
        }
        // Se adicionarmos um triângulo, precisamos modificar essa classe
    }

    private void desenharCirculo() {
        System.out.println("Desenhando um círculo.");
    }

    private void desenharRetangulo() {
        System.out.println("Desenhando um retângulo.");
    }
}
```
Para adicionar o desenho de um triângulo, precisaríamos modificar a classe Desenho, violando o princípio Open-Closed.



✅ Exemplo correto:
```java
// Interface para representar uma forma
interface Forma {
    void desenhar();
}

// Implementação para círculo
class Circulo implements Forma {
    @Override
    public void desenhar() {
        System.out.println("Desenhando um círculo.");
    }
}

// Implementação para retângulo
class Retangulo implements Forma {
    @Override
    public void desenhar() {
        System.out.println("Desenhando um retângulo.");
    }
}

// Implementação para triângulo (nova funcionalidade sem modificar o código existente)
class Triangulo implements Forma {
    @Override
    public void desenhar() {
        System.out.println("Desenhando um triângulo.");
    }
}

// Classe que trabalha com qualquer forma através da interface
class Desenho {
    public void desenharForma(Forma forma) {
        forma.desenhar();
    }
}

public class Main {
    public static void main(String[] args) {
        Desenho desenho = new Desenho();
        desenho.desenharForma(new Circulo());
        desenho.desenharForma(new Retangulo());
        desenho.desenharForma(new Triangulo()); // Adicionando nova forma sem modificar Desenho
    }
}
```
Agora, para adicionar uma nova forma, apenas criamos uma nova classe que implementa a interface Forma sem modificar a classe Desenho.

## L — Liskov Substitution Principle (Princípio da Substituição de Liskov)
Subtipos devem ser substituíveis por seus tipos base, sem quebrar o programa. Isso significa que se uma classe B é um subtipo de uma classe A, então objetos de B devem poder ser usados em qualquer lugar onde objetos de A são esperados, sem que o programa quebre.


❌ Exemplo incorreto:
```java
// Contraexemplo: Violando o LSP
public class Retangulo {
    protected int largura;
    protected int altura;

    public void setLargura(int l) { this.largura = l; }
    public void setAltura(int a) { this.altura = a; }

    public int getArea() {
        return largura * altura;
    }
}

public class Quadrado extends Retangulo {
    @Override
    public void setLargura(int l) {
        this.largura = l;
        this.altura = l;
    }

    @Override
    public void setAltura(int a) {
        this.largura = a;
        this.altura = a;
    }
}
```
O Quadrado quebra a lógica do Retangulo, pois assume que os lados são iguais, o que pode causar comportamento inesperado.


✅ Exemplo correto:
```java
public interface Forma {
    int getArea();
}

public class Retangulo implements Forma {
    private int largura;
    private int altura;

    public Retangulo(int l, int a) {
        this.largura = l;
        this.altura = a;
    }

    public int getArea() {
        return largura * altura;
    }
}

public class Quadrado implements Forma {
    private int lado;

    public Quadrado(int lado) {
        this.lado = lado;
    }

    public int getArea() {
        return lado * lado;
    }
}
```
Agora, Quadrado e Retangulo são tratados separadamente, respeitando o contrato da interface Forma.

## I — Interface Segregation Principle (Princípio da Segregação de Interface)
Nenhuma classe deve ser forçada a depender de métodos que não usa. Isso significa que interfaces devem ser pequenas e específicas para os clientes que as usam. Interfaces grandes e genéricas levam a classes que implementam métodos que não são relevantes para elas.

❌ Exemplo incorreto:
```java
// Contraexemplo: Interface "gorda" com métodos que nem todos os dispositivos precisam
interface DispositivoMultifuncional {
    void imprimir(String documento);
    void digitalizar(String documento);
    void enviarFax(String numero, String documento);
}

class ImpressoraSimples implements DispositivoMultifuncional {
    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimindo: " + documento);
    }

    @Override
    public void digitalizar(String documento) {
        // Uma impressora simples não digitaliza, mas precisa implementar o método (viola ISP)
        throw new UnsupportedOperationException("Impressora simples não pode digitalizar.");
    }

    @Override
    public void enviarFax(String numero, String documento) {
        // Uma impressora simples não envia fax, mas precisa implementar o método (viola ISP)
        throw new UnsupportedOperationException("Impressora simples não pode enviar fax.");
    }
}

class DispositivoAvancado implements DispositivoMultifuncional {
    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimindo (avançado): " + documento);
    }

    @Override
    public void digitalizar(String documento) {
        System.out.println("Digitalizando (avançado): " + documento);
    }

    @Override
    public void enviarFax(String numero, String documento) {
        System.out.println("Enviando fax (avançado) para " + numero + ": " + documento);
    }
}
```
Neste exemplo, a interface DispositivoMultifuncional força a classe ImpressoraSimples a implementar os métodos digitalizar e enviarFax, mesmo que uma impressora simples não possua essas funcionalidades. Isso viola o ISP, pois a classe ImpressoraSimples está sendo forçada a depender de métodos que não usa.

✅ Exemplo correto:
Para seguir o ISP, podemos segregar a interface em interfaces menores e mais específicas para cada funcionalidade.
```java
// Interfaces segregadas por funcionalidade
interface Impressora {
    void imprimir(String documento);
}

interface Scanner {
    void digitalizar(String documento);
}

interface Fax {
    void enviarFax(String numero, String documento);
}

// Uma impressora simples implementa apenas a interface de impressão
class ImpressoraSimples implements Impressora {
    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimindo: " + documento);
    }
}

// Um dispositivo multifuncional avançado implementa todas as interfaces relevantes
class DispositivoAvancado implements Impressora, Scanner, Fax {
    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimindo (avançado): " + documento);
    }

    @Override
    public void digitalizar(String documento) {
        System.out.println("Digitalizando (avançado): " + documento);
    }

    @Override
    public void enviarFax(String numero, String documento) {
        System.out.println("Enviando fax (avançado) para " + numero + ": " + documento);
    }
}

// Podemos até ter um dispositivo que apenas digitaliza
class ScannerDedicado implements Scanner {
    @Override
    public void digitalizar(String documento) {
        System.out.println("Digitalizando (dedicado): " + documento);
    }
}
```
Nesta implementação, cada classe implementa apenas as interfaces que correspondem às suas funcionalidades. A ImpressoraSimples implementa apenas Impressora, o DispositivoAvancado implementa todas as três, e um ScannerDedicado implementa apenas Scanner. Isso garante que nenhuma classe seja forçada a depender de métodos que não utiliza, seguindo o Princípio da Segregação da Interface.

## D — Dependency Inversion Principle (Princípio da Inversão de Dependência)
Dependa de abstrações, não de implementações concretas.
Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações.
Abstrações não devem depender de detalhes. Detalhes (concretos) devem depender de abstrações.   
Isso significa que as classes de alto nível (que contêm a lógica de negócios) não devem depender diretamente de classes de baixo nível (que implementam detalhes, como acesso a banco de dados ou sistemas de arquivos). Ambas devem depender de interfaces ou classes abstratas.

❌ Exemplo incorreto:
```java
public class MySQLRepositorio {
    public void salvar(String dado) {
        // código específico do MySQL
    }
}

public class Servico {
    private MySQLRepositorio repo = new MySQLRepositorio();

    public void executar() {
        repo.salvar("dados");
    }
}
```
A classe Servico está fortemente acoplada a uma implementação concreta.

✅ Exemplo correto:
```java
public interface Repositorio {
    void salvar(String dado);
}

public class MySQLRepositorio implements Repositorio {
    public void salvar(String dado) {
        // implementação MySQL
    }
}

public class Servico {
    private Repositorio repo;

    public Servico(Repositorio repo) {
        this.repo = repo;
    }

    public void executar() {
        repo.salvar("dados");
    }
}
```
Agora, Servico depende da abstração Repositorio, permitindo trocar a implementação facilmente (por exemplo, PostgresRepositorio ou MemoriaRepositorio).

## Conclusão
Compreender e aplicar os princípios SOLID em conjunto com os conceitos da POO leva a um design de software mais robusto, manutenível e extensível. Ao seguir esses princípios, você pode criar sistemas mais flexíveis, fáceis de testar e menos propensos a mudanças cascateadas. Os exemplos e contraexemplos em Java ilustram como esses princípios podem ser aplicados na prática.






