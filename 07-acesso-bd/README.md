# Acesso a Bancos de Dados em Aplicações Java

Java Database Connectivity (JDBC) é a tecnologia fundamental que permite que suas aplicações Java conversem, enviem comandos e recebam informações de SGBDs como MySQL, PostgreSQL, Oracle, SQL Server e muitos outros.

O JDBC é a API (Application Programming Interface) padrão da plataforma Java que define como um cliente Java pode acessar e interagir com um banco de dados. Pense nele como um conjunto de interfaces e classes que fornecem uma maneira uniforme para os desenvolvedores Java executarem tarefas como:

* Estabelecer conexões com bancos de dados.
* Enviar consultas SQL para o banco de dados.
* Processar os resultados retornados pelas consultas.
* Gerenciar transações (agrupar múltiplas operações em uma única unidade de trabalho)

Uma aplicação Java pode acessar um banco de dados relacional de diferentes maneiras, dependendo das necessidades do projeto, como complexidade, desempenho, segurança e facilidade de desenvolvimento. 

Independentemente da abordagem escolhida — seja com frameworks ORM, microframeworks ou bibliotecas utilitárias — todas as formas de acesso a banco em Java utilizam JDBC direta ou indiretamente. Ele é a base sobre a qual outras soluções foram construídas.

A seguir estão as abordagens mais comuns:

## Principais Formas de Acesso a Banco de Dados

### 1. JDBC Puro
A API padrão do Java para acesso a bancos de dados. Fornece controle total sobre a conexão, comandos SQL, e manipulação de resultados. É ideal para aprendizado ou para sistemas pequenos e simples.

- **Vantagens:** controle total, independência de frameworks.
- **Desvantagens:** muito código repetitivo (boilerplate), propenso a erros, difícil de escalar.

### 2. Frameworks ORM (JPA / Hibernate)
Fazem o mapeamento objeto-relacional (ORM), permitindo que entidades Java sejam automaticamente associadas a tabelas do banco.

- **Vantagens:** desenvolvimento mais produtivo, menos código SQL, recursos como cache, lazy loading, e transações.
- **Desvantagens:** curva de aprendizado, menor controle sobre o SQL gerado, possíveis problemas de desempenho.

### 3. Frameworks de Acesso a Dados (Spring JDBC / Spring Data JDBC)
Camada de abstração sobre o JDBC que reduz a verbosidade e facilita a integração com o Spring Framework.

- **Vantagens:** menos código repetitivo, integração nativa com o Spring.
- **Desvantagens:** ainda exige conhecimento de SQL, menos flexível que ORMs.

### 4. Microframeworks como jOOQ
Permitem escrever SQL de forma programática e segura, com checagem em tempo de compilação.

- **Vantagens:** controle total sobre SQL, geração automática de código com base no schema do banco.
- **Desvantagens:** depende da geração de código e da estrutura do banco de dados.

---

## Aprofundando: JDBC Puro

O JDBC (Java Database Connectivity) é uma API da linguagem Java que permite interagir com bancos de dados relacionais de forma direta.

### Etapas para Acesso com JDBC Puro

1. **Carregar o driver JDBC**

Primeiramente, você precisa do driver JDBC específico para o banco de dados que você quer usar (MySQL, PostgreSQL, Oracle, SQL Server, etc.). Esse driver atua como um tradutor entre as chamadas JDBC da sua aplicação Java e a linguagem nativa do banco de dados. Geralmente, você adiciona esse driver como uma dependência no seu projeto (Maven ou Gradle).

Exemplo do pom.xml para adicionar o driver JDBC de acesso ao MySQL
```java
<dependencies>
<dependency> 
    <groupId> mysql </groupId> 
    <artifactId> mysql-connector-java </artifactId> 
    <version> 8.0.33 </version> 
</dependency>
</dependencies>
```

Exemplo do pom.xml para adicionar o driver JDBC de acesso ao PostgreSQL
```java
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.5</version>
</dependency>
```

Exemplo do pom.xml para adicionar o driver JDBC de acesso ao SQLite
```java
<dependencies>
<dependency>
    <groupId> org.xerial.sqlite-jdbc </groupId>
    <artifactId> sqlite-jdbc </artifactId>
    <version> 3.49.1.0 </version> 
</dependency>
```


Embora o carregamento seja automático nas versões modernas, é possível registrar o driver explicitamente:

```java
Class.forName("org.postgresql.Driver");
```

2. **Estabelecer uma conexão**

O próximo passo crucial é estabelecer uma conexão com o banco de dados. Isso envolve usar a classe DriverManager e fornecer uma URL de conexão, além de credenciais (usuário e senha, se necessário). A URL de conexão segue um formato específico que informa ao JDBC qual driver usar e onde o banco de dados está localizado. Por exemplo, para PostgreSQL, poderia ser algo como:

```java
String url = "jdbc:postgresql://localhost:5432/meubanco";
String usuario = "usuario";
String senha = "senha";

try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
    System.out.println("Conexão estabelecida com sucesso!");
} catch (SQLException e) {
    e.printStackTrace();
}
```
Perceba o bloco try-with-resources. Ele garante que a conexão seja fechada automaticamente após o uso, evitando vazamentos de recursos. A SQLException é a exceção base para qualquer problema que ocorra durante a interação com o banco de dados.

3. **Executar comandos SQL**

Uma vez que você tem a conexão, o próximo passo é executar comandos SQL. Para isso, você usa a interface Statement (para comandos simples) ou PreparedStatement (para comandos parametrizados, mais seguros contra SQL Injection e geralmente mais eficientes para consultas repetidas).

#### Com `Statement` (evite para entradas externas - risco de SQL Injection):
Usado para comandos SQL estáticos e simples. É menos seguro contra SQL Injection.


```java
String url = "jdbc:postgresql://localhost:5432/meubanco";
String usuario = "usuario";
String senha = "senha";

try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
     Statement stmt = conexao.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT * FROM aluno")) {

    while (rs.next()) {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String email = rs.getString("email");
        System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email);
    }

} catch (SQLException e) {
    e.printStackTrace();
}
```
Aqui, executeQuery() é usado para comandos SELECT que retornam resultados, que são acessados através do objeto ResultSet. Você itera sobre as linhas do resultado usando rs.next() e recupera os valores das colunas usando métodos como getInt(), getString(), etc., passando o nome ou o índice da coluna.


#### Com `PreparedStatement` (recomendado):
O PreparedStatement é uma forma mais segura e eficiente de executar consultas, especialmente quando você precisa executar a mesma consulta várias vezes com valores diferentes. Ele evita ataques de SQL Injection porque os valores são tratados separadamente da estrutura do SQL.

```java
String url = "jdbc:postgresql://localhost:5432/meubanco";
String usuario = "usuario";
String senha = "senha";

String sql = "SELECT * FROM produtos WHERE preco > ?";

try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
     PreparedStatement pstmt = conexao.prepareStatement(sql);
     ResultSet rs = pstmt.executeQuery()) {

    double precoMinimo = 20.0;
    pstmt.setDouble(1, precoMinimo); // Define o valor do primeiro parâmetro (?)

    while (rs.next()) {
        String nome = rs.getString("nome");
        double preco = rs.getDouble("preco");
        System.out.println("Nome: " + nome + ", Preço: " + preco);
    }

} catch (SQLException e) {
    e.printStackTrace();
}
```
Note que a consulta SQL no prepareStatement() tem um placeholder (?). Você então usa os métodos setXXX() (como setInt(), setString(), setDouble(), etc.) para definir os valores desses parâmetros, indicando sua posição (base 1).

Novamente, usamos o executeQuery() para o comando SELECT que retorna resultados. Estes serão acessados por meio do objeto ResultSet. Para comandos que modificam o banco de dados (INSERT, UPDATE, DELETE), você usaria executeUpdate().

```java
String url = "jdbc:postgresql://localhost:5432/meubanco";
String usuario = "usuario";
String senha = "senha";

try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
     PreparedStatement pstmt = conexao.prepareStatement(sql)) {
    String sql = "INSERT INTO aluno (id, nome, email) VALUES (1, 'Maria', 'maria@maria.com')";
    stmt.executeUpdate(sql);
} catch (SQLException e) {
    e.printStackTrace();
}
```

4. **Fechar recursos**
Finalmente, é fundamental lembrar de fechar os recursos (conexão, statement, resultset) assim que não forem mais necessários para liberar recursos do banco de dados e da sua aplicação. O bloco try-with-resources facilita muito essa tarefa.

É uma boa prática fechá-los explicitamente em blocos finally em cenários mais complexos sem o try-with-resources.
```java
rs.close();
ps.close();
conexao.close();
```