# Clean Architecture 
A Clean Architecture, proposta por Robert C. Martin ("Uncle Bob"), é uma filosofia de design de software que visa separar as responsabilidades do sistema em camadas independentes. O objetivo principal é criar sistemas que sejam:

* Independentes de frameworks: A arquitetura não depende de nenhuma biblioteca ou framework específico.
* Testáveis: As regras de negócio podem ser testadas sem a necessidade da interface do usuário, banco de dados, servidor web ou qualquer outro elemento externo.
* Independentes da interface do usuário: A interface do usuário pode mudar facilmente sem afetar a lógica de negócios.
* Independentes do banco de dados: Você pode trocar o banco de dados sem alterar a lógica de negócios.
* Independentes de qualquer agência externa: A lógica de negócios não conhece detalhes de sistemas externos.
* Fáceis de entender e manter: A separação clara de responsabilidades torna o sistema mais compreensível e facilita a manutenção.

### Camadas da Clean Architecture
A Clean Architecture organiza o código em camadas concêntricas. A camada mais interna contém as regras de negócio (Entities e Use Cases), que são as mais estáveis e independentes. As camadas externas dependem das camadas internas, mas as internas não sabem nada sobre as externas.

As principais camadas da Clean Architecture são:

* Entities: Representam as regras de negócio de mais alto nível. São objetos com lógica de domínio, mas sem dependências de outras camadas.
* Use Cases (Interactors): Contêm a lógica de negócios específica da aplicação. Orquestram o fluxo de dados entre as Entities e as camadas externas. Dependem das Entities.
* Interface Adapters (Controllers, Presenters, Gateways): Convertem os dados do formato mais conveniente para os Use Cases e Entities para o formato usado pelas camadas externas (UI, banco de dados, etc.) e vice-versa.
* Frameworks & Drivers (UI, Database, Web Frameworks, Devices): É a camada mais externa, onde residem os detalhes de implementação de frameworks, bancos de dados, interfaces de usuário, etc.

<img src="https://miro.medium.com/v2/resize:fit:1100/format:webp/1*0R0r00uF1RyRFxkxo3HVDg.png" alt="Camadas" width="600" height="400"/>



### Relação com os Princípios SOLID
Os princípios SOLID são fundamentais para alcançar os objetivos da Clean Architecture e garantir que cada camada seja bem projetada e mantenha suas responsabilidades separadas. Veja como cada princípio se relaciona:

Single Responsibility Principle (SRP): Cada camada da Clean Architecture tem uma responsabilidade bem definida. As Entities focam nas regras de negócio, os Use Cases na lógica de aplicação, os Interface Adapters na conversão de dados e os Frameworks & Drivers nos detalhes de implementação. Dentro de cada camada, as classes também devem seguir o SRP, garantindo que cada classe tenha apenas uma razão para mudar.

Open/Closed Principle (OCP): A Clean Architecture busca isolar as camadas internas das externas. Ao depender de abstrações (interfaces e classes abstratas) nas fronteiras entre as camadas, podemos estender o comportamento do sistema adicionando novas implementações nas camadas externas sem modificar o código das camadas internas. Por exemplo, podemos adicionar um novo tipo de banco de dados implementando as interfaces definidas na camada de Interface Adapters, sem alterar os Use Cases ou Entities.

Liskov Substitution Principle (LSP): Ao definir interfaces nas fronteiras entre as camadas, é crucial que as implementações concretas dessas interfaces nas camadas externas sejam substituíveis por suas abstrações sem quebrar o sistema. Isso garante a integridade das interações entre as camadas.

Interface Segregation Principle (ISP): As interfaces definidas nas fronteiras entre as camadas devem ser específicas para os clientes que as utilizam. Por exemplo, a interface de um Gateway de banco de dados para persistir alunos deve ter apenas os métodos necessários para essa operação, evitando que as camadas internas dependam de métodos desnecessários.

Dependency Inversion Principle (DIP): A Clean Architecture enfatiza a dependência de abstrações. As camadas internas (Entities e Use Cases) não devem depender de detalhes concretos das camadas externas. Em vez disso, as camadas externas devem depender das abstrações definidas pelas camadas internas. Isso é crucial para a independência de frameworks e bancos de dados. Por exemplo, os Use Cases dependem de interfaces de repositório (abstrações) definidas na camada de Interface Adapters, e as implementações concretas desses repositórios (que interagem com o SQLite) residem na camada de Frameworks & Drivers.

## Exemplo
Vamos criar um exemplo simplificado em Java para persistir dados de alunos no SQLite, seguindo os princípios da Clean Architecture

### Entity

```java
public class Aluno {
    private int id;
    private String nome;

    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
}
```


### Use Case: Cadastro
A camada de Use Cases não conhece os detalhes de como os dados são persistidos. Ela depende apenas da abstração Repository.

```java
public class CadastrarAluno {
    private Repository<Aluno> repo;

    public CadastrarAluno(Repository<Aluno> repo) {
        this.repo = repo;
    }

    public void executar(Aluno aluno) {
        repo.salvar(aluno);
    }
}
```

### Use Case: Listagem
A camada de Use Cases não conhece os detalhes de como os dados são persistidos. Ela depende apenas da abstração Repository.

```java
import java.util.Iterator;

public class ListarAlunos {
    private Repository<Aluno> repo;

    public ListarAlunos(Repository<Aluno> repo) {
        this.repo = repo;
    }

    public Iterator<Aluno> executar() {
        return repo.listarTodos();
    }
}
```

### Interface Adapters
A interface Repository define o contrato para a persistência de alunos.
O uso de Generics na interface Repository promove a reutilização de código e a criação de um contrato consistente para diferentes tipos de entidades.
```java
import java.util.Iterator;

public interface Repository<T> {
    void salvar(T entidade);
    Iterator<T> listarTodos();
}
```
Aqui, usamos Generics (<T>) para criar uma interface de repositório genérica que pode ser usada para diferentes entidades.


### Frameworks & Drivers
A camada de Frameworks & Drivers contém os detalhes da implementação do banco de dados SQLite. Se você quisesse mudar para outro banco de dados, precisaria apenas criar uma nova implementação da interface Repository.

```java
import java.sql.*;
import java.util.*;

public class AlunoSQLiteRepository implements Repository<Aluno> {
    private Connection conexao;

    public AlunoSQLiteRepository(String url) throws SQLException {
        this.conexao = DriverManager.getConnection(url);
        try (Statement stmt = conexao.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS aluno (id INTEGER PRIMARY KEY, nome TEXT)");
        }
    }

    public void salvar(Aluno aluno) {
        String sql = "INSERT INTO aluno (id, nome) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Iterator<Aluno> listarTodos() {
        List<Aluno> lista = new ArrayList<>();
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM aluno")) {
            while (rs.next()) {
                Aluno a = new Aluno(rs.getInt("id"), rs.getString("nome"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista.iterator();
    }
}
```


### Interface de Entrada (Menu simples)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Repository<Aluno> repo = new AlunoSQLiteRepository("jdbc:sqlite:alunos.db");
        CadastrarAluno cadastro = new CadastrarAluno(repo);
        ListarAlunos listagem = new ListarAlunos(repo);

        while (true) {
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("0 - Sair");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                cadastro.executar(new Aluno(id, nome));
            } else if (opcao == 2) {
                Iterator<Aluno> it = listagem.executar();
                while (it.hasNext()) {
                    Aluno a = it.next();
                    System.out.println(a.getId() + " - " + a.getNome());
                }
            } else if (opcao == 0) {
                break;
            }
        }
    }
}
```



Esse exemplo mostra como aplicar a Clean Architecture com os princípios SOLID, tornando o sistema modular, testável e flexível. Este é um exemplo simplificado. Em uma aplicação real, você teria mais Use Cases, Controllers para lidar com a entrada do usuário, e talvez Presenters para formatar a saída.




