# Classe Abstrata

Uma classe abstrata é um tipo especial de classe que não pode ser instanciada diretamente. Ela serve como um modelo ou um projeto para outras classes, que são chamadas de subclasses ou classes derivadas. O principal objetivo de uma classe abstrata é definir um conjunto comum de métodos (e, às vezes, atributos) que suas subclasses devem implementar ou herdar.

Aqui estão os pontos chave sobre classes abstratas:

* Não podem ser instanciadas: Você não pode criar objetos diretamente de uma classe abstrata. A tentativa de fazer isso geralmente resulta em um erro de compilação.
* Podem conter métodos abstratos: Uma classe abstrata pode declarar métodos abstratos. Um método abstrato é um método que é declarado, mas não implementado na classe abstrata. A implementação desses métodos é deixada para as subclasses concretas. Em algumas linguagens de programação, a presença de pelo menos um método abstrato torna a classe inteira abstrata.
* Podem conter métodos concretos: Além de métodos abstratos, uma classe abstrata também pode conter métodos concretos (com implementação), atributos e construtores. Estes podem ser herdados pelas subclasses.
* Servem como um tipo base: Classes abstratas são frequentemente usadas como um tipo base para criar uma hierarquia de classes relacionadas. Elas fornecem uma interface comum para essas classes, garantindo que certas funcionalidades estejam presentes.
* Obriga a implementação: Quando uma classe concreta herda de uma classe abstrata, ela é obrigada a fornecer implementações para todos os métodos abstratos definidos na classe pai. Se uma subclasse não implementar todos os métodos abstratos, ela também se torna uma classe abstrata.

### Propósito e Benefícios das Classes Abstratas:

* Definir uma interface comum: Classes abstratas ajudam a estabelecer um contrato ou uma interface que todas as subclasses devem seguir. Isso garante consistência no comportamento das classes relacionadas.
* Reutilização de código: Elas permitem que você defina funcionalidades comuns (métodos concretos e atributos) que podem ser reutilizadas por todas as subclasses, evitando a duplicação de código.
* Polimorfismo: Referências a objetos de subclasses podem ser tratadas como referências ao tipo da classe abstrata pai. Isso permite escrever código mais genérico e flexível que pode trabalhar com diferentes implementações.
* Modelagem de conceitos abstratos: Elas são úteis para modelar entidades ou conceitos que são gerais demais para serem instanciados por si só, mas que servem como base para entidades mais específicas.

Exemplo:
```java
public abstract class Pessoa {
    private String endereco;
    private String telefone;
    private String email;

    public Pessoa(String endereco, String telefone, String email) {
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


public class PessoaFisica extends Pessoa {
    private String cpf;
    private String nome;

    public PessoaFisica(String endereco, String telefone, String email, String cpf, String nome) {
        super(endereco, telefone, email);
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                "} " + super.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean validarCPF() {
        //código para validar CPF
        return false;
    }
}

public class PessoaJuridica extends Pessoa{
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;

    public PessoaJuridica(String cnpj, String razaoSocial, String nomeFantasia,
                          String endereco, String telefone, String email) {
        super(endereco, telefone, email);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                "} " + super.toString();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public boolean validarCNPJ(){
        //código para validar cnpj
        return false;
    }
}


public class Main {
    public static void main(String[] args) {

       //Polimorfismo
       Pessoa pessoaFisica1 = new PessoaFisica("1234567810",
                "Maria",
               "Rua A, n10",
               "3351-1234",
               "maria@poo.com.br");

        //Polimorfismo
       Pessoa pessoaFisica2 = new PessoaFisica("98798798711",
               "João",
               "Rua C, n15",
               "3351-4646",
               "joao@joao.com.br");

        //Polimorfismo
       Pessoa pessoaJuridica = new PessoaJuridica("111222333000190",
               "Empresa S/A",
                "Empresa XPTO",
               "Rua B, n 20",
               "3351-9090",
               "empresa@empresa.com.br");


        //Polimorfismo também  (ArrayList é do tipo List) junto com Generics (List<Pessoa>)
       List<Pessoa> lista = new ArrayList<>();
       lista.add(pessoaFisica1);
       lista.add(pessoaFisica1);
       lista.add(pessoaJuridica);

       //Embora a lista possua objetos PessoaFisica e PessoaJurica,
        // todos são tratados como Pessoa  (superclasse)
       for (Pessoa p : lista)
           System.out.println(p); //em tempo de execução,
                             // é decidido qual comportamento o método irá exibir
                            // dependendo do tipo do objeto (PessoaFisica ou PessoaJuridica)

    }
}
```

## Método Abstrato
Um método abstrato é um método que é declarado dentro de uma classe abstrata (ou em algumas linguagens, em uma interface), mas não possui uma implementação definida nessa classe. Ele serve como um "contrato" que as subclasses concretas (não abstratas) devem seguir, sendo obrigadas a fornecer sua própria implementação para esse método.

Aqui estão os pontos chave sobre métodos abstratos:

* Declarado, não implementado: Um método abstrato possui uma assinatura (nome, parâmetros, tipo de retorno), mas não tem um corpo com código. Em muitas linguagens, isso é indicado pelo uso de uma palavra-chave como abstract.
* Reside em classes abstratas (geralmente): Métodos abstratos só podem existir dentro de classes abstratas. Se uma classe contém pelo menos um método abstrato, a própria classe deve ser declarada como abstrata.
Obrigatório para subclasses concretas: Qualquer subclasse concreta (que pode ser instanciada) que herda de uma classe abstrata com métodos abstratos é obrigada a fornecer uma implementação para todos esses métodos abstratos. Se uma subclasse não implementar todos os métodos abstratos herdados, ela também se torna uma classe abstrata.
* Define uma interface: Métodos abstratos ajudam a definir uma interface comum para um conjunto de subclasses relacionadas. Eles garantem que todas as subclasses suportem certas operações, mesmo que a forma como essas operações são realizadas possa variar entre as subclasses.
* Foco no "o quê", não no "como": Um método abstrato especifica o que uma subclasse deve ser capaz de fazer, mas não diz como ela deve fazer isso. A responsabilidade de fornecer a lógica de implementação recai sobre as subclasses.

### Propósito e Benefícios dos Métodos Abstratos:

* Forçar a implementação: Eles garantem que certas funcionalidades essenciais sejam implementadas por todas as subclasses, evitando que classes concretas esqueçam de fornecer um comportamento necessário.
* Promover o polimorfismo: Métodos abstratos são cruciais para o polimorfismo. Você pode chamar o mesmo método em diferentes objetos de subclasses, e cada objeto executará sua própria implementação específica do método abstrato.
* Design orientado a interfaces: Eles ajudam a projetar sistemas baseados em interfaces, onde a classe base abstrata define o comportamento esperado, e as subclasses fornecem as implementações concretas.
* Flexibilidade e extensibilidade: Permitem que você adicione novas subclasses com comportamentos específicos sem precisar modificar o código que interage com a classe abstrata pai.

Exemplo:
```java
import java.util.Objects;

public abstract class Funcionario {
    private String nome;
    private double salario;

    public abstract double calcularBonus(); //metodo abstrato

    public void exibirInfo(){
        System.out.println("\nNome: "+this.nome+
                           "\nSalário: "+this.salario);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Funcionario that)) return false;
        return Double.compare(getSalario(), that.getSalario()) == 0 && Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getSalario());
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

    @Override
    public String toString() {
        return "Gerente{" +
                "qtdProjetos=" + qtdProjetos +
                "} " + super.toString();
    }

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

    @Override
    public String toString() {
        return "Vendedor{" +
                "totalVendas=" + totalVendas +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vendedor vendedor)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getTotalVendas(), vendedor.getTotalVendas()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTotalVendas());
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


public class Main {
    public static void main(String[] args) {
        //Funcionario f = new Funcionario("José", 2500); ERRO, classe é abstrata
        Funcionario g = new Gerente("Maria", 5000,3);
        Funcionario v = new Vendedor("Joaquim", 3000, 20000);

        List<Funcionario> lista = new ArrayList<>();
        lista.add(g);
        lista.add(v);

        for (Funcionario func : lista){
            func.exibirInfo();
            System.out.println("Bônus: " + func.calcularBonus());
        }
    }
}
```