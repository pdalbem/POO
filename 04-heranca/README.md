# Herança

Herança é um mecanismo que permite que uma classe (subclasse, filha)
herde atributos e métodos de outra classe (superclasse, pai).
Comportamentos comuns a diversas classes são centralizados na
superclasse, enquanto as subclasses podem ter atributos e métodos
específicos.

Em Java, a herança é implementada utilizando a palavra-chave `extends`. A sintaxe básica é:

```java
public class Subclasse extends Superclasse {
    // Corpo da subclasse
}
```

Exemplo: Classe Pessoa

```java
public class Pessoa {
    private String cpf;
    private String nome;

    public void validarCPF(){
        System.out.println("Validando o CPF "+ this.getCpf());
    }

    public Pessoa(String cpf, String nome) {
        this.setCpf(cpf);
        this.setNome(nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
```
A classe Aluno herda de Pessoa. Os métodos contrutores não são herdados. Cada subclasse deve fornecer o seu próprio construtor e invocar o construtor da superclasse por meio da palavra-chave **super**:

```java

public class Aluno extends Pessoa{
    private String prontuario;
    private double ira;

    public void efetuarMatricula(){
        System.out.println("Efetuando matrícula do(a) aluno(a) "+ this.getNome());
    }

    public Aluno(String cpf, String nome, String prontuario, double ira) {
        super(cpf, nome);
        this.setProntuario(prontuario);
        this.setIra(ira);
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public double getIra() {
        return ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }
}
```
A classe Professor também herda da classe Pessoa
```java
public class Professor extends Pessoa{
    private String titulacao;
    private String areaAtuacao;

    public void atribuirDisciplina(){
        System.out.println("Atribuindo disciplina para o(a) professor(a) "+this.getNome());
    }

    public Professor(String cpf, String nome, String titulacao, String areaAtuacao) {
        super(cpf, nome);
        this.setTitulacao(titulacao);
        this.setAreaAtuacao(areaAtuacao);
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
}
```
A classe Main:
```java
public class Main {
    public static void main(String[] args) {
        Aluno aluno= new Aluno("111.111.111-11", "Maria","SC123456", 8);
        Professor professor = new Professor("222.222.222-22", "Joaquim", "Doutorado", "Computação");

        aluno.validarCPF();
        professor.validarCPF();

        aluno.efetuarMatricula();
        professor.atribuirDisciplina();

        System.out.println("Nome do(a) aluno(a): "+aluno.getNome());
        System.out.println("IRA do(a) aluno(a): "+aluno.getIra());
    }
}
```

# Sobrescrita de Método (Method Overriding)
A sobrescrita de método (em inglês, method overriding) é um recurso que
permite a uma subclasse fornecer uma implementação específica para um
método que já está definido na sua superclasse.

Imagine que a superclasse tem um método que realiza uma determinada
ação. A subclasse, por herdar esse método, também pode realizar essa
mesma ação. No entanto, esta subclasse pode querer que essa ação seja
realizada de uma maneira diferente, mais específica para o seu tipo.

A sobrescrita de método permite que a subclasse substitua a
implementação do método da classe pai pela sua própria implementação.

Regras importantes:
* Mesma Assinatura: O método na subclasse deve ter a mesma
assinatura do método na superclasse. Isto é: mesmo nome, mesmos
parâmetros e mesmo retorno.

* Relacionamento de Herança: A sobrescrita só pode ocorrer entre uma
superclasse e uma de suas subclasses.

* Modificador de Acesso: O modificador de acesso do método
sobrescrito na subclasse não pode ser mais restritivo que o
modificador de acesso do método na superclasse. Por exemplo, se o
método na superclasse é protected, o método na subclasse pode ser
protected ou public, mas não private.

* Anotação ```@Override```: Em Java, é uma boa prática usar a anotação
@Override antes do método sobrescrito na subclasse.

* Métodos com os modificadores ```final```, ```static``` e ```private``` **NÃO** podem ser sobrescritos.

Exemplo: Veja a classe Funcionario com os métodos ```calcularBonus()``` e ```exibirInfo()```
```java
public class Funcionario {
    private String nome;
    private double salario;

    public double calcularBonus(){
        return salario*0.05;
    }

    public void exibirInfo(){
        System.out.println("\nNome: "+this.nome+
                           "\nSalário: "+this.salario);
    }

    public Funcionario(String nome, double salario) {
        this.setNome(nome);
        this.setSalario(salario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
```
A classe Gerente herda de Funcionario, porém ela sobrescreve os métodos ```calcularBonus()``` e ```exibirInfo()```, alterando os seus comportamentos.
```java
public class Gerente extends Funcionario{
    private int qtdProjetos;

    @Override
    public double calcularBonus() {
        return getSalario()*.10 + (1000*this.qtdProjetos);
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Qtd. de projetos: "+ this.qtdProjetos);
    }

    public Gerente(String nome, double salario, int qtdProjetos) {
        super(nome, salario);
        this.setQtdProjetos(qtdProjetos);
    }

    public int getQtdProjetos() {
        return qtdProjetos;
    }

    public void setQtdProjetos(int qtdProjetos) {
        this.qtdProjetos = qtdProjetos;
    }
}
```
Da mesma forma, a classe Vendedor também herda de Funcionario e sobrescreve os métodos ```calcularBonus()``` e ```exibirInfo()```
```java
public class Vendedor extends Funcionario{
    private double totalVendas;

    @Override
    public double calcularBonus() {
        return this.totalVendas*0.08;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Total de vendas: "+this.totalVendas);
    }

    public Vendedor(String nome, double salario, double totalVendas) {
        super(nome, salario);
        this.setTotalVendas(totalVendas);
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }
}
```

Na classe Main:
```java
public class Main {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("José", 2500);
        Gerente g = new Gerente("Maria", 5000,3);
        Vendedor v = new Vendedor("Joaquim", 3000, 20000);

        f.exibirInfo();
        g.exibirInfo();
        v.exibirInfo();

        System.out.println("\nBônus do funcionário "+f.getNome()+": "+f.calcularBonus());
        System.out.println("Bônus do gerente "+g.getNome()+": "+g.calcularBonus());
        System.out.println("Bônus do vendedor "+v.getNome()+": "+v.calcularBonus());
    }
}
```
## Sobrescrita de toString(), equals() e hashCode()
Toda classe em Java herda, direta ou indiretamente, da classe ```java.lang.Object```, que define métodos como:

* toString(): retorna uma representação textual do objeto.

* equals(): compara objetos.

* hashCode(): retorna um código hash do objeto.

Esses métodos podem (e geralmente devem) ser sobrescritos para refletir o estado real do objeto.

### toString()

Sobrescrevendo```toString()``` na classe Funcionario:
```java
 @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }
```
Sobrescrevendo```toString()``` na classe Gerente. Repare que o método aqui invoca o toString() da superclasse Funcionario usando a palavra-chave **super**:
```java
@Override
    public String toString() {
        return "Gerente{" +
                "qtdProjetos=" + qtdProjetos +
                "} " + super.toString();
    }
```
### equals() e hashCode()
Comparar objetos usando o operador “==” nos dá um resultado diferente do
esperado, pois este operador compara referências a objetos e não os
valores de seus atributos.

Para comparar dois objetos corretamente, é preciso sobrescrever o método
```equals()``` e verificar se os valores de seus atributos são iguais.
Ao sobrescrever o método ```equals()```, é preciso sobrescrever também o
método ```hashCode()```

Exemplo da sobrescrita de equals() e hashCode() na superclasse Funcionario
```java
 @Override
    public boolean equals(Object o) {
        if (!(o instanceof Funcionario that)) return false;
        return Double.compare(getSalario(), that.getSalario()) == 0 && Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getSalario());
    }
```
Sobrescrita dos mesmos métodos na subclasse Gerente, Veja que a sobrescrita de equals() invoca o equals() da superclasse Funcionario por meio da palavra-chave **super**:

```java
 @Override
    public boolean equals(Object o) {
        if (!(o instanceof Gerente gerente)) return false;
        if (!super.equals(o)) return false;
        return getQtdProjetos() == gerente.getQtdProjetos();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getQtdProjetos());
    }
```

# Polimorfismo
É a habilidade de um objeto assumir múltiplas formas.

O polimorfismo permite que objetos de diferentes subclasses sejam tratados de forma genérica, como instâncias da superclasse. No entanto, em tempo de execução, o comportamento específico de cada subclasse é executado.

Considere novamente nosso exemplo com as classes **Funcionario**, **Gerente** e **Vendedor**. 
Agora veja a classe Main:
```java
public class Main {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("José", 2500);
        Funcionario g = new Gerente("Maria", 5000,3);
        Funcionario v = new Vendedor("Joaquim", 3000, 20000);

        List<Funcionario> lista = new ArrayList<>();
        lista.add(f);
        lista.add(g);
        lista.add(v);

        for (Funcionario func : lista){
            func.exibirInfo();
            System.out.println("Bônus: " + func.calcularBonus());
        }
    }
}
```
Os objetos f, g e v são declarados como do tipo Funcionario, mas referenciam instâncias de tipos distintos: Funcionario, Gerente e Vendedor, respectivamente. Isso é possível porque as classes Gerente e Vendedor estendem a classe Funcionario, ou seja, são suas subclasses.

Dessa forma, é possível criar uma lista do tipo Funcionario e armazenar nela objetos de diferentes subclasses. Mesmo que esses objetos tenham implementações distintas de certos métodos (como calcularBonus() ou exibirInfo()), o método executado será determinado em tempo de execução, com base no tipo real do objeto. Esse comportamento é um exemplo clássico de polimorfismo em Java, onde a JVM escolhe dinamicamente qual versão do método deve ser invocada.

# Classe __final__
O modificador final aplicado à especificação de uma classe impede que
essa classe seja estendida por outras classes. Em outras palavras,
uma classe final não pode ter subclasses.
Tentar estender uma classe ```final``` resultará em um erro de compilação. 

Sintaxe:
```java
public final class MinhaClasse {
…
}
```

Razões para uma classe final: segurança, desempenho, imutabilidade,
controle de design.

Classes da API Java que são final:
java.lang.String
java.lang.Integer
java.lang.Long
java.lang.Float
java.lang.Double
java.lang.Boolean
java.lang.Math
java.util.Collections

# Classes seladas (sealed classes)
Introduzidas no Java 17, as classes seladas (sealed) permitem controlar explicitamente quais classes podem estender uma superclasse.

Sintaxe:
```java
public sealed class Pessoa permits Aluno, Funcionario {
 …
}
```

As classes listadas na cláusula ```permits``` devem ser explicitamente declaradas com:
* final: Indica que a subclasse não pode ser estendida.
* sealed: Indica que a subclasse também é sealed e deve definir suas próprias
subclasses permitidas.
* non-sealed: Indica que a subclasse pode ser estendida por qualquer outra classe
(essencialmente "abre" novamente a hierarquia a partir desse ponto)

Exemplo
```java
public sealed class Pessoa permits Aluno, Funcionario {
 …
}
public final class Aluno extends Pessoa{
…
}
public sealed class Funcionario extends Pessoa permits Professor,FuncAdm{
…
}
public final class Professor extends Funcionario {
…
}
public final class FuncAdm extends Funcionario{
…
}
```