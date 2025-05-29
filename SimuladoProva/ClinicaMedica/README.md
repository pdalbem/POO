# Tutorial: Criando um Sistema de Agendamento de Consultas Médicas em Java com IntelliJ IDEA

Este tutorial guia você passo a passo para criar um sistema simples de agendamento de consultas médicas usando Java, SQLite, básico de Clean Architecture e IntelliJ IDEA.

---

## 1. Criando o projeto no IntelliJ IDEA

1. Abra o IntelliJ IDEA.
2. Clique em **New Project**.
3. Escolha **Java**, configure o JDK (17+), clique em **Next**.
4. Dê um nome ao projeto.
5. Escolha Maven como build system 
6. Finalize a criação.

---

## 3. Estrutura do Projeto

Organize os pacotes da seguinte forma para manter a Clean Architecture:

```
├── src
│   └── main
│       └── java
│           ├── Main.java
│           ├── adapter
│           │   ├── config
│           │   │   ├── AppConfig.java
│           │   │   ├── DatabaseInitializer.java
│           │   │   └── SQLiteConnectionFactory.java
│           │   └── repository
│           │       ├── ConsultaRepositoryImpl.java
│           │       ├── EspecialidadeRepositoryImpl.java
│           │       ├── MedicoRepositoryImpl.java
│           │       └── PacienteRepositoryImpl.java
│           ├── domain
│           │   ├── entity
│           │   │   ├── Consulta.java
│           │   │   ├── Especialidade.java
│           │   │   ├── ExibeDados.java
│           │   │   ├── Medico.java
│           │   │   ├── Paciente.java
│           │   │   ├── Pessoa.java
│           │   │   └── StatusConsulta.java
│           │   ├── exception
│           │   │   └── EntityAlreadyExistsException.java
│           │   └── repository
│           │       ├── ConsultaRepository.java
│           │       ├── EspecialidadeRepository.java
│           │       ├── MedicoRepository.java
│           │       └── PacienteRepository.java
│           └── usecase
│               ├── ConsultaUseCase.java
│               ├── EspecialidadeUseCase.java
│               ├── MedicoUseCase.java
│               └── PacienteUseCase.java
```


---
## 4. Dependências

Adicione a biblioteca JDBC para SQLite no arquivo do Maven `pom.xml`:

```xml
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.49.1.0</version>
</dependency>
```

---

## 5. Entidades do Domínio 

Crie classes e interfaces de domínio em `domain.entity`:

```java
package domain.entity;

public interface ExibeDados {
    void exibirInfo();
}
```

```java
package domain.entity;

public abstract class Pessoa implements ExibeDados {
    private int id;
    private String cpf;
    private String nome;

    public Pessoa(int id, String cpf, String nome) {
        this(cpf,nome);
        this.id = id;
    }

    public Pessoa(String cpf, String nome) {
        validarDados(cpf, nome);
        this.cpf = cpf;
        this.nome = nome;
    }

    private void validarDados(String cpf, String nome) {
        validarCPF(cpf);
        validarNome(nome);
    }

    private void validarCPF(String cpf){
        if (cpf == null || cpf.isBlank())
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio.");
    }

    private void validarNome(String nome){
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCPF(cpf);
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }
}
```

```java
package domain.entity;

public class Paciente extends Pessoa{
    private String telefone;

    public Paciente(String cpf, String nome, String telefone) {
        super(cpf, nome);
        this.telefone = telefone;
    }

    public Paciente(int id, String cpf, String nome, String telefone) {
        super(id, cpf, nome);
        this.telefone = telefone;
    }

    @Override
    public void exibirInfo() {
        System.out.println("\nID: " + getId() +
                "\nNome: " + getNome() +
                "\nCPF: " +getCpf() +
                "\nTelefone: " + telefone);
        }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
```

```java
package domain.entity;

public class Especialidade {
    private int id;
    private String descricao;

    private void validarDescricao(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição da especialidade não pode ser nula ou vazia.");
        }
    }

    public Especialidade(int id, String descricao) {
        this(descricao);
        this.id = id;
    }

    public Especialidade(String descricao) {
        validarDescricao(descricao);
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        validarDescricao(descricao);
        this.descricao = descricao;
    }
}
```
```java
package domain.entity;

public class Medico extends Pessoa {
    private String inscricaoCRM;
    private Especialidade especialidade;

    public Medico(int id, String cpf, String nome, String inscricaoCRM, Especialidade especialidade) {
        super(id, cpf, nome);
        validarDados(inscricaoCRM, especialidade);
        this.inscricaoCRM = inscricaoCRM;
        this.especialidade = especialidade;
    }

    public Medico(String cpf, String nome, String inscricaoCRM, Especialidade especialidade) {
        super(cpf, nome);
        validarDados(inscricaoCRM, especialidade);
        this.inscricaoCRM = inscricaoCRM;
        this.especialidade = especialidade;
    }

    private void validarDados(String crm, Especialidade esp) {
      validarCRM(crm);
      validarEspecialidade(esp);
    }

    private  void validarCRM(String crm){
       if (crm == null || crm.isBlank())
            throw new IllegalArgumentException("CRM não pode ser nulo ou vazio.");

    }

    private void validarEspecialidade(Especialidade esp){
        if (esp == null)
            throw new IllegalArgumentException("Especialidade não pode ser nula.");

    }

    @Override
    public void exibirInfo() {
        System.out.println("\nID: " + getId() +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nCRM: " + inscricaoCRM +
                "\nEspecialidade: " + especialidade.getDescricao());
    }

    public String getInscricaoCRM() {
        return inscricaoCRM;
    }

    public void setInscricaoCRM(String inscricaoCRM) {
        validarCRM(inscricaoCRM);
        this.inscricaoCRM = inscricaoCRM;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        validarEspecialidade(especialidade);
        this.especialidade = especialidade;
    }
}
```

```java
package domain.entity;

import java.time.LocalDateTime;

public class Consulta {
    private int id;
    private LocalDateTime dataHora;
    private StatusConsulta status;
    private final Paciente paciente;
    private final Medico medico;

    public Consulta(int id, LocalDateTime dataHora, StatusConsulta status, Paciente paciente, Medico medico) {
        validarDados(dataHora, paciente, medico);
        this.id = id;
        this.dataHora = dataHora;
        this.status =  status;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Consulta(LocalDateTime dataHora, Paciente paciente, Medico medico) {
        validarDados(dataHora, paciente, medico);
        this.dataHora = dataHora;
        this.paciente = paciente;
        this.medico = medico;
        this.status = StatusConsulta.AGENDADA;
    }

    private void validarDados(LocalDateTime dataHora, Paciente paciente, Medico medico) {
        if (dataHora == null)
            throw new IllegalArgumentException("Data e hora da consulta não podem ser nulas.");

        if (paciente == null)
            throw new IllegalArgumentException("Paciente não pode ser nulo.");

        if (medico == null)
            throw new IllegalArgumentException("Médico não pode ser nulo.");

    }

    public void cancelarConsulta() {
        this.status = StatusConsulta.CANCELADA;
    }

    public void remarcarConsulta(LocalDateTime novaDataHora) {
        this.dataHora = novaDataHora;
        this.status = StatusConsulta.AGENDADA; // opcional: reinicia status após remarcação
    }

    public void confirmarConsulta() {
        this.status = StatusConsulta.CONFIRMADA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }
}
```

---

## 6. Exceção Personalizada

Em `domain.exception`, crie:

```java
public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
```

---

## 7. Repositórios 

Defina interfaces dos Repositories. Em `domain.repository`, crie:

```java
package domain.repository;

import java.util.Iterator;
import java.util.Optional;

public interface Repository <T>{
    void save(T entity);
    Optional<T> findById(int id);
    Iterator<T> findAll();
}
```

```java
package domain.repository;

import domain.entity.Especialidade;

public interface EspecialidadeRepository extends Repository<Especialidade>{
    void update(Especialidade especialidade);
    void delete(Especialidade especialidade);
}
```

```java
package domain.repository;

import domain.entity.Paciente;

import java.util.Optional;

public interface PacienteRepository extends Repository<Paciente>{
    Optional<Paciente> findByCPF(String cpf);
}
```

```java
package domain.repository;

import domain.entity.Especialidade;
import domain.entity.Medico;

import java.util.Iterator;
import java.util.Optional;

public interface MedicoRepository extends Repository<Medico>{
    Optional<Medico> findByCPF(String cpf);
    Optional<Medico> findByCRM(String crm);
    Iterator<Medico> findByEspecialidade(Especialidade especialidade);
}
```

```java
package domain.repository;

import domain.entity.Consulta;
import domain.entity.Medico;
import domain.entity.Paciente;

import java.util.Iterator;

public interface ConsultaRepository extends Repository<Consulta>{
    void update(Consulta consulta);
    Iterator<Consulta> findByPaciente(Paciente paciente);
    Iterator<Consulta> findByMedico(Medico medico);

}
```

---

## 8. Use Cases (`usecase`)

Implemente classes para regras de negócio em `usecase`:

```java
package usecase;

import domain.entity.Especialidade;
import domain.repository.EspecialidadeRepository;

import java.util.Iterator;
import java.util.Optional;

public class EspecialidadeUseCase {
    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeUseCase(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    public void save(Especialidade especialidade) {
        especialidadeRepository.save(especialidade);
    }

    public Optional<Especialidade> findById(int id) {
        return especialidadeRepository.findById(id);
    }

    public Iterator<Especialidade> findAll() {
        return especialidadeRepository.findAll();
    }

    public void update(Especialidade especialidade) {
        especialidadeRepository.update(especialidade);
    }

    public void delete(Especialidade especialidade) {
        especialidadeRepository.delete(especialidade);
    }
}
```

```java
package usecase;

import domain.entity.Paciente;
import domain.exception.EntityAlreadyExistsException;
import domain.repository.PacienteRepository;

import java.util.Iterator;
import java.util.Optional;

public class PacienteUseCase {
    private final PacienteRepository pacienteRepository;

    public PacienteUseCase(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void save(Paciente paciente) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findByCPF(paciente.getCpf());
        if (pacienteOptional.isPresent())
            throw new EntityAlreadyExistsException("CPF já cadastrado para outro paciente.");

        pacienteRepository.save(paciente);
    }

    public Optional<Paciente> findById(int id) {
        return pacienteRepository.findById(id);
    }

    public Iterator<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> findByCPF(String cpf) {
        return pacienteRepository.findByCPF(cpf);
    }
}
```

```java
package usecase;

import domain.entity.Especialidade;
import domain.entity.Medico;
import domain.exception.EntityAlreadyExistsException;
import domain.repository.MedicoRepository;

import java.util.Iterator;
import java.util.Optional;

public class MedicoUseCase {
    private final MedicoRepository medicoRepository;

    public MedicoUseCase(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public void save(Medico medico) {
        Optional<Medico> porCpf = medicoRepository.findByCPF(medico.getCpf());
        if (porCpf.isPresent())
            throw new EntityAlreadyExistsException("CPF já cadastrado para outro médico.");

        Optional<Medico> porCRM = medicoRepository.findByCRM(medico.getInscricaoCRM());
        if (porCRM.isPresent())
            throw new EntityAlreadyExistsException("CRM já cadastrado para outro médico.");

        medicoRepository.save(medico);
    }

    public Optional<Medico> findById(int id) {
        return medicoRepository.findById(id);
    }

    public Iterator<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> findByCPF(String cpf) {
        return medicoRepository.findByCPF(cpf);
    }

    public Optional<Medico> findByCRM(String crm) {
        return medicoRepository.findByCRM(crm);
    }

    public Iterator<Medico> findByEspecialidade(Especialidade especialidade) {
        return medicoRepository.findByEspecialidade(especialidade);
    }
}
```

```java
package usecase;

import domain.entity.Consulta;
import domain.entity.Medico;
import domain.entity.Paciente;
import domain.entity.StatusConsulta;
import domain.repository.ConsultaRepository;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Optional;

public class ConsultaUseCase {
    private final ConsultaRepository consultaRepository;
    private static final int DURACAO_CONSULTA = 30;
    // Poderia usar o tipo Duration também:
    //private static final Duration DURACAO_CONSULTA = Duration.ofMinutes(30);

    public ConsultaUseCase(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public void save(Consulta consulta) {
        // Regra 7: Não pode marcar consulta no passado
        if (consulta.getDataHora().isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Não é possível marcar consulta com data/hora anterior à data/hora atual.");

        // Regra 6: Verificar conflito de horário (considera duração padrão 30min)
        Iterator<Consulta> consultasMedico = consultaRepository.findByMedico(consulta.getMedico());
        while (consultasMedico.hasNext()) {
            Consulta c = consultasMedico.next();
            if (c.getStatus() != StatusConsulta.CANCELADA && conflitoDeHorario(consulta.getDataHora(), c.getDataHora()))
                throw new IllegalArgumentException("Conflito de horário com outra consulta agendada para o médico.");
        }

        consultaRepository.save(consulta);
    }

    public Optional<Consulta> findById(int id) {
        return consultaRepository.findById(id);
    }

    public Iterator<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public void update(Consulta consulta) {
        consultaRepository.update(consulta);
    }

    public Iterator<Consulta> findByPaciente(Paciente paciente) {
        return consultaRepository.findByPaciente(paciente);
    }

    public Iterator<Consulta> findByMedico(Medico medico) {
        return consultaRepository.findByMedico(medico);
    }

    public void confirmarConsulta(Consulta consulta) {
        if (consulta.getStatus() == StatusConsulta.CANCELADA)
            throw new IllegalStateException("Não é possível confirmar uma consulta cancelada.");

        consulta.confirmarConsulta();
        consultaRepository.update(consulta);
    }


    public void cancelarConsulta(Consulta consulta) {
        // Regra 8: Só cancelar antes do horário de início
        if (!consulta.getDataHora().isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("Não é possível cancelar uma consulta após seu horário de início.");

        if (consulta.getStatus() == StatusConsulta.CANCELADA)
            throw new IllegalStateException("Consulta já está cancelada.");

        consulta.cancelarConsulta();
        consultaRepository.update(consulta);
    }

    public void remarcarConsulta(Consulta consulta, LocalDateTime novaDataHora) {
        if (novaDataHora == null)
            throw new IllegalArgumentException("Nova data e hora não podem ser nulas.");

        if (novaDataHora.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Nova data e hora não podem estar no passado.");

        // Regra: conflito de horário
        Iterator<Consulta> consultasMedico = consultaRepository.findByMedico(consulta.getMedico());
        while (consultasMedico.hasNext()) {
            Consulta outra = consultasMedico.next();
            if (outra.getId() != consulta.getId() &&
                    outra.getStatus() != StatusConsulta.CANCELADA &&
                    conflitoDeHorario(novaDataHora, outra.getDataHora()))
                throw new IllegalArgumentException("Conflito de horário com outra consulta.");

        }

        consulta.remarcarConsulta(novaDataHora);
        consultaRepository.update(consulta);
    }

    // Método interno que verifica se há conflito entre duas consultas
    // Retorna true para conflito e false caso não ocorra
    private boolean conflitoDeHorario(LocalDateTime inicioNovaConsulta, LocalDateTime inicioConsultaExistente) {
        LocalDateTime fimNovaConsulta = inicioNovaConsulta.plusMinutes(DURACAO_CONSULTA);
        LocalDateTime fimConsultaExistente = inicioConsultaExistente.plusMinutes(DURACAO_CONSULTA);

        return inicioNovaConsulta.isBefore(fimConsultaExistente) && inicioConsultaExistente.isBefore(fimNovaConsulta);
    }
}
```

---

## 9. ConnectionFactory

Crie a classe `SQLiteConnectionFactory` no pacote `adapter.config`:

```java
package adapter.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionFactory {
    private static final String URL = "jdbc:sqlite:clinica.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
```
---

## 10. DatabaseInitializer

Crie a classe `DatabaseInitializer` no pacote `adapter.config` :

```java
package adapter.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void init() {
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Especialidade (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    descricao TEXT NOT NULL UNIQUE
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Paciente (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    cpf TEXT NOT NULL UNIQUE,
                    nome TEXT NOT NULL,
                    telefone TEXT
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Medico (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    cpf TEXT NOT NULL UNIQUE,
                    nome TEXT NOT NULL,
                    inscricaoCRM TEXT NOT NULL,
                    especialidade_id INTEGER,
                    FOREIGN KEY (especialidade_id) REFERENCES Especialidade(id)
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS Consulta (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    dataHora TEXT NOT NULL,
                    status TEXT NOT NULL,
                    paciente_id INTEGER,
                    medico_id INTEGER,
                    FOREIGN KEY (paciente_id) REFERENCES Paciente(id),
                    FOREIGN KEY (medico_id) REFERENCES Medico(id)
                );
            """);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inicializar banco de dados: " + e.getMessage());
        }
    }
}
```

---

## 11. AppConfig

Implemente no pacote `adapter.config` uma classe simples para fazer injeção de dependência dos use cases:

```java
package adapter.config;

import adapter.repository.ConsultaRepositoryImpl;
import adapter.repository.EspecialidadeRepositoryImpl;
import adapter.repository.MedicoRepositoryImpl;
import adapter.repository.PacienteRepositoryImpl;

import usecase.ConsultaUseCase;
import usecase.EspecialidadeUseCase;
import usecase.MedicoUseCase;
import usecase.PacienteUseCase;

public class AppConfig {

    public static EspecialidadeUseCase createEspecialidadeUseCase() {
        return new EspecialidadeUseCase(new EspecialidadeRepositoryImpl());
    }

    public static PacienteUseCase createPacienteUseCase() {
        return new PacienteUseCase(new PacienteRepositoryImpl());
    }

    public static MedicoUseCase createMedicoUseCase() {
        return new MedicoUseCase(new MedicoRepositoryImpl());
    }

    public static ConsultaUseCase createConsultaUseCase() {
        return new ConsultaUseCase(new ConsultaRepositoryImpl());
    }
}
```


---

## 12. Implementação dos repositórios
Implemente as interfaces dos repositórios que você havia criado em `domain.repository`.
As implementações das interfaces ficarão em `adapter.repository`:

```java
package adapter.repository;

import adapter.config.SQLiteConnectionFactory;
import domain.entity.Especialidade;
import domain.repository.EspecialidadeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class EspecialidadeRepositoryImpl implements EspecialidadeRepository {

    @Override
    public void save(Especialidade especialidade) {
        String sql = "INSERT INTO Especialidade (descricao) VALUES (?)";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, especialidade.getDescricao());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    especialidade.setId(rs.getInt(1)); // ÚNICO USO DE SETTER
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar especialidade", e);
        }
    }

    @Override
    public Optional<Especialidade> findById(int id) {
        String sql = "SELECT * FROM Especialidade WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String descricao = rs.getString("descricao");
                    return Optional.of(new Especialidade(id, descricao));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar especialidade por ID", e);
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Especialidade> findAll() {
        List<Especialidade> lista = new ArrayList<>();
        String sql = "SELECT * FROM Especialidade";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                lista.add(new Especialidade(id, descricao));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todas as especialidades", e);
        }
        return lista.iterator();
    }

    @Override
    public void update(Especialidade especialidade) {
        String sql = "UPDATE Especialidade SET descricao = ? WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, especialidade.getDescricao());
            stmt.setInt(2, especialidade.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar especialidade", e);
        }
    }

    @Override
    public void delete(Especialidade especialidade) {
        String sql = "DELETE FROM Especialidade WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, especialidade.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir especialidade", e);
        }
    }
}
```

```Java
package adapter.repository;

import adapter.config.SQLiteConnectionFactory;
import domain.entity.Paciente;
import domain.repository.PacienteRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class PacienteRepositoryImpl implements PacienteRepository {

    @Override
    public void save(Paciente paciente) {
        String sql = "INSERT INTO Paciente (cpf, nome, telefone) VALUES (?, ?, ?)";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, paciente.getCpf());
            stmt.setString(2, paciente.getNome());
            stmt.setString(3, paciente.getTelefone());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    paciente.setId(rs.getInt(1)); // único uso do setter
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar paciente", e);
        }
    }

    @Override
    public Optional<Paciente> findById(int id) {
        String sql = "SELECT * FROM Paciente WHERE id = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    String telefone = rs.getString("telefone");
                    return Optional.of(new Paciente(id, cpf, nome, telefone));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar paciente por ID", e);
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Paciente> findAll() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Paciente";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                lista.add(new Paciente(id, cpf, nome, telefone));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os pacientes", e);
        }
        return lista.iterator();
    }

    @Override
    public Optional<Paciente> findByCPF(String cpf) {
        String sql = "SELECT * FROM Paciente WHERE cpf = ?";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String telefone = rs.getString("telefone");
                    return Optional.of(new Paciente(id, cpf, nome, telefone));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar paciente por CPF", e);
        }
        return Optional.empty();
    }
}
```

```java
package adapter.repository;

import adapter.config.SQLiteConnectionFactory;
import domain.entity.Especialidade;
import domain.entity.Medico;
import domain.repository.MedicoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class MedicoRepositoryImpl implements MedicoRepository {

    @Override
    public void save(Medico medico) {
        String sql = "INSERT INTO Medico (cpf, nome, inscricaoCRM, especialidade_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, medico.getCpf());
            stmt.setString(2, medico.getNome());
            stmt.setString(3, medico.getInscricaoCRM());
            stmt.setInt(4, medico.getEspecialidade().getId());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    medico.setId(rs.getInt(1)); // único uso do setter
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar médico", e);
        }
    }

    @Override
    public Optional<Medico> findById(int id) {
        String sql = """
            SELECT m.id, m.cpf, m.nome, m.inscricaoCRM,
                   e.id as esp_id, e.descricao
            FROM Medico m
            JOIN Especialidade e ON m.especialidade_id = e.id
            WHERE m.id = ?
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int medicoId = rs.getInt("id");
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    String crm = rs.getString("inscricaoCRM");

                    int espId = rs.getInt("esp_id");
                    String espDescricao = rs.getString("descricao");

                    Especialidade especialidade = new Especialidade(espId, espDescricao);
                    Medico medico = new Medico(medicoId, cpf, nome, crm, especialidade);
                    return Optional.of(medico);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar médico por ID", e);
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Medico> findAll() {
        List<Medico> lista = new ArrayList<>();
        String sql = """
            SELECT m.id, m.cpf, m.nome, m.inscricaoCRM,
                   e.id as esp_id, e.descricao
            FROM Medico m
            JOIN Especialidade e ON m.especialidade_id = e.id
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int medicoId = rs.getInt("id");
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String crm = rs.getString("inscricaoCRM");

                int espId = rs.getInt("esp_id");
                String espDescricao = rs.getString("descricao");

                Especialidade especialidade = new Especialidade(espId, espDescricao);
                Medico medico = new Medico(medicoId, cpf, nome, crm, especialidade);
                lista.add(medico);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os médicos", e);
        }

        return lista.iterator();
    }

    @Override
    public Optional<Medico> findByCPF(String cpf) {
        String sql = """
            SELECT m.id, m.cpf, m.nome, m.inscricaoCRM,
                   e.id as esp_id, e.descricao
            FROM Medico m
            JOIN Especialidade e ON m.especialidade_id = e.id
            WHERE m.cpf = ?
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int medicoId = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String crm = rs.getString("inscricaoCRM");

                    int espId = rs.getInt("esp_id");
                    String espDescricao = rs.getString("descricao");

                    Especialidade especialidade = new Especialidade(espId, espDescricao);
                    Medico medico = new Medico(medicoId, cpf, nome, crm, especialidade);
                    return Optional.of(medico);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar médico por CPF", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Medico> findByCRM(String crm) {
        String sql = """
            SELECT m.id, m.cpf, m.nome, m.inscricaoCRM,
                   e.id as esp_id, e.descricao
            FROM Medico m
            JOIN Especialidade e ON m.especialidade_id = e.id
            WHERE m.inscricaoCRM = ?
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, crm);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int medicoId = rs.getInt("id");
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");

                    int espId = rs.getInt("esp_id");
                    String espDescricao = rs.getString("descricao");

                    Especialidade especialidade = new Especialidade(espId, espDescricao);
                    Medico medico = new Medico(medicoId, cpf, nome, crm, especialidade);
                    return Optional.of(medico);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar médico por CRM", e);
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Medico> findByEspecialidade(Especialidade especialidade) {
        List<Medico> lista = new ArrayList<>();
        String sql = """
            SELECT m.id, m.cpf, m.nome, m.inscricaoCRM
            FROM Medico m
            WHERE m.especialidade_id = ?
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, especialidade.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int medicoId = rs.getInt("id");
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    String crm = rs.getString("inscricaoCRM");

                    Medico medico = new Medico(medicoId, cpf, nome, crm, especialidade);
                    lista.add(medico);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar médicos por especialidade", e);
        }

        return lista.iterator();
    }
}
```

```java
package adapter.repository;

import adapter.config.SQLiteConnectionFactory;
import domain.entity.*;
import domain.repository.ConsultaRepository;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ConsultaRepositoryImpl implements ConsultaRepository {

    @Override
    public void save(Consulta consulta) {
        String sql = """
            INSERT INTO Consulta (dataHora, status, paciente_id, medico_id)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, consulta.getDataHora().toString());
            stmt.setString(2, consulta.getStatus().toString());
            stmt.setInt(3, consulta.getPaciente().getId());
            stmt.setInt(4, consulta.getMedico().getId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Erro ao inserir consulta, nenhuma linha afetada.");
            }

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                consulta.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Falha ao obter ID gerado para a consulta.");
            }
            generatedKeys.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar consulta: "+ e.getMessage());
        }
    }

    @Override
    public Optional<Consulta> findById(int id) {
        String sql = """
            SELECT 
                c.id AS consulta_id, c.dataHora, c.status,
                p.id AS paciente_id, p.cpf AS paciente_cpf, p.nome AS paciente_nome, p.telefone AS paciente_telefone,
                m.id AS medico_id, m.cpf AS medico_cpf, m.nome AS medico_nome, m.inscricaoCRM,
                e.id AS especialidade_id, e.descricao AS especialidade_descricao
            FROM Consulta c
            JOIN Paciente p ON c.paciente_id = p.id
            JOIN Medico m ON c.medico_id = m.id
            JOIN Especialidade e ON m.especialidade_id = e.id
            WHERE c.id = ?
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                var paciente = new Paciente(
                        rs.getInt("paciente_id"),
                        rs.getString("paciente_cpf"),
                        rs.getString("paciente_nome"),
                        rs.getString("paciente_telefone")
                );

                var especialidade = new Especialidade(
                        rs.getInt("especialidade_id"),
                        rs.getString("especialidade_descricao")
                );

                var medico = new Medico(
                        rs.getInt("medico_id"),
                        rs.getString("medico_cpf"),
                        rs.getString("medico_nome"),
                        rs.getString("inscricaoCRM"),
                        especialidade
                );

                Consulta consulta = new Consulta(
                        rs.getInt("consulta_id"),
                        LocalDateTime.parse(rs.getString("dataHora")),
                        StatusConsulta.valueOf(rs.getString("status")),
                        paciente,
                        medico
                );
                rs.close();
                return Optional.of(consulta);
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar consulta por ID: "+ e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public Iterator<Consulta> findByPaciente(Paciente paciente) {
        String sql = """
            SELECT 
                c.id AS consulta_id, c.dataHora, c.status,
                p.id AS paciente_id, p.cpf AS paciente_cpf, p.nome AS paciente_nome, p.telefone AS paciente_telefone,
                m.id AS medico_id, m.cpf AS medico_cpf, m.nome AS medico_nome, m.inscricaoCRM,
                e.id AS especialidade_id, e.descricao AS especialidade_descricao
            FROM Consulta c
            JOIN Paciente p ON c.paciente_id = p.id
            JOIN Medico m ON c.medico_id = m.id
            JOIN Especialidade e ON m.especialidade_id = e.id
            WHERE p.id = ?
        """;

        List<Consulta> consultas = new ArrayList<>();

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, paciente.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var pac = new Paciente(
                        rs.getInt("paciente_id"),
                        rs.getString("paciente_cpf"),
                        rs.getString("paciente_nome"),
                        rs.getString("paciente_telefone")
                );

                var especialidade = new Especialidade(
                        rs.getInt("especialidade_id"),
                        rs.getString("especialidade_descricao")
                );

                var medico = new Medico(
                        rs.getInt("medico_id"),
                        rs.getString("medico_cpf"),
                        rs.getString("medico_nome"),
                        rs.getString("inscricaoCRM"),
                        especialidade
                );

                Consulta consulta = new Consulta(
                        rs.getInt("consulta_id"),
                        LocalDateTime.parse(rs.getString("dataHora")),
                        StatusConsulta.valueOf(rs.getString("status")),
                        pac,
                        medico
                );

                consultas.add(consulta);
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar consulta por paciente: "+ e.getMessage());
        }

        return consultas.iterator();
    }

    @Override
    public Iterator<Consulta> findByMedico(Medico medico) {
        String sql = """
            SELECT 
                c.id AS consulta_id, c.dataHora, c.status,
                p.id AS paciente_id, p.cpf AS paciente_cpf, p.nome AS paciente_nome, p.telefone AS paciente_telefone,
                m.id AS medico_id, m.cpf AS medico_cpf, m.nome AS medico_nome, m.inscricaoCRM,
                e.id AS especialidade_id, e.descricao AS especialidade_descricao
            FROM Consulta c
            JOIN Paciente p ON c.paciente_id = p.id
            JOIN Medico m ON c.medico_id = m.id
            JOIN Especialidade e ON m.especialidade_id = e.id
            WHERE m.id = ?
        """;

        List<Consulta> consultas = new ArrayList<>();

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, medico.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var pac = new Paciente(
                        rs.getInt("paciente_id"),
                        rs.getString("paciente_cpf"),
                        rs.getString("paciente_nome"),
                        rs.getString("paciente_telefone")
                );

                var especialidade = new Especialidade(
                        rs.getInt("especialidade_id"),
                        rs.getString("especialidade_descricao")
                );

                var med = new Medico(
                        rs.getInt("medico_id"),
                        rs.getString("medico_cpf"),
                        rs.getString("medico_nome"),
                        rs.getString("inscricaoCRM"),
                        especialidade
                );

                Consulta consulta = new Consulta(
                        rs.getInt("consulta_id"),
                        LocalDateTime.parse(rs.getString("dataHora")),
                        StatusConsulta.valueOf(rs.getString("status")),
                        pac,
                        med
                );
                consultas.add(consulta);
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar consulta por médico: "+ e.getMessage());
        }

        return consultas.iterator();
    }

    @Override
    public Iterator<Consulta> findAll() {
        String sql = """
            SELECT 
                c.id AS consulta_id, c.dataHora, c.status,
                p.id AS paciente_id, p.cpf AS paciente_cpf, p.nome AS paciente_nome, p.telefone AS paciente_telefone,
                m.id AS medico_id, m.cpf AS medico_cpf, m.nome AS medico_nome, m.inscricaoCRM,
                e.id AS especialidade_id, e.descricao AS especialidade_descricao
            FROM Consulta c
            JOIN Paciente p ON c.paciente_id = p.id
            JOIN Medico m ON c.medico_id = m.id
            JOIN Especialidade e ON m.especialidade_id = e.id
        """;

        List<Consulta> consultas = new ArrayList<>();

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                var pac = new Paciente(
                        rs.getInt("paciente_id"),
                        rs.getString("paciente_cpf"),
                        rs.getString("paciente_nome"),
                        rs.getString("paciente_telefone")
                );

                var especialidade = new Especialidade(
                        rs.getInt("especialidade_id"),
                        rs.getString("especialidade_descricao")
                );

                var medico = new Medico(
                        rs.getInt("medico_id"),
                        rs.getString("medico_cpf"),
                        rs.getString("medico_nome"),
                        rs.getString("inscricaoCRM"),
                        especialidade
                );

                Consulta consulta = new Consulta(
                        rs.getInt("consulta_id"),
                        LocalDateTime.parse(rs.getString("dataHora")),
                        StatusConsulta.valueOf(rs.getString("status")),
                        pac,
                        medico
                );

                consultas.add(consulta);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao recuperar consultas: "+ e.getMessage());
        }

        return consultas.iterator();
    }

    @Override
    public void update(Consulta consulta) {
        String sql = """
            UPDATE Consulta
            SET dataHora = ?, status = ?, paciente_id = ?, medico_id = ?
            WHERE id = ?
        """;

        try (Connection conn = SQLiteConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, consulta.getDataHora().toString());
            stmt.setString(2, consulta.getStatus().toString());
            stmt.setInt(3, consulta.getPaciente().getId());
            stmt.setInt(4, consulta.getMedico().getId());
            stmt.setInt(5, consulta.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar consulta: "+ e.getMessage());
        }
    }
}
```
---
## 13. Classe Principal (`Main`)
Por fim, crie a classe Main:

```java
import adapter.config.AppConfig;
import adapter.config.DatabaseInitializer;
import domain.entity.*;

import domain.exception.EntityAlreadyExistsException;
import usecase.ConsultaUseCase;
import usecase.EspecialidadeUseCase;
import usecase.MedicoUseCase;
import usecase.PacienteUseCase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Inicializa o banco
        DatabaseInitializer.init();

        // Cria os use cases
        EspecialidadeUseCase especialidadeUseCase = AppConfig.createEspecialidadeUseCase();
        PacienteUseCase pacienteUseCase = AppConfig.createPacienteUseCase();
        MedicoUseCase medicoUseCase = AppConfig.createMedicoUseCase();
        ConsultaUseCase consultaUseCase = AppConfig.createConsultaUseCase();

        try {
            Especialidade especialidade1 = new Especialidade("Cardiologia");
            especialidadeUseCase.save(especialidade1);

            Especialidade especialidade2 = new Especialidade("Ortopedia");
            especialidadeUseCase.save(especialidade2);

            Paciente paciente = new Paciente("123.456.789-00", "João", "11999990000");
            pacienteUseCase.save(paciente);

            Medico medico1 = new Medico("987.654.321-00", "Dra. Maria", "CRM123456", especialidade1);
            medicoUseCase.save(medico1);

            Medico medico2= new Medico("777.777.777-77", "Dr. Joaquim", "CRM777777", especialidade2);
            medicoUseCase.save(medico2);

            LocalDateTime dataHoraConsulta = LocalDateTime.now().plusDays(1).withHour(14).withMinute(0);
            Consulta consulta = new Consulta(dataHoraConsulta, paciente, medico1);
            consultaUseCase.save(consulta);
            System.out.println("Consulta agendada com sucesso.");

            //Consulta conflito = new Consulta(dataHoraConsulta, paciente, medico1);
            //consultaUseCase.save(conflito);

            // Remarca a consulta
            LocalDateTime novaDataHora = dataHoraConsulta.plusHours(1);
            consultaUseCase.remarcarConsulta(consulta, novaDataHora);
            System.out.println("Consulta remarcada com sucesso.");

            // Confirma a consulta
            consultaUseCase.confirmarConsulta(consulta);
            System.out.println("Consulta confirmada com sucesso.");

            consultaUseCase.cancelarConsulta(consulta);

            // Lista consultas do médico
            System.out.println("\nConsultas do médico " + medico1.getNome() + ":");
            Iterator<Consulta> consultasMedico = consultaUseCase.findByMedico(medico1);
            while (consultasMedico.hasNext()) {
                Consulta c = consultasMedico.next();
                System.out.println("Consulta ID: " + c.getId()
                                   + "\nData/Hora: " + c.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"))
                                   + "\nPaciente: " + c.getPaciente().getNome()
                                    + "\nStatus: " + c.getStatus().toString());
            }

            // Lista consultas do paciente
            System.out.println("\nConsultas do paciente " + paciente.getNome() + ":");
            Iterator<Consulta> consultasPaciente = consultaUseCase.findByPaciente(paciente);
            while (consultasPaciente.hasNext()) {
                Consulta c = consultasPaciente.next();
                System.out.println("Consulta ID: " + c.getId()
                        + "\nData/Hora: " + c.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm"))
                        + "\nPaciente: " + c.getPaciente().getNome()
                        + "\nStatus: " + c.getStatus().toString());
            }

        } catch (EntityAlreadyExistsException e) {
            System.out.println("ERRO: "+e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("ERRO: "+e.getMessage());
        }catch (RuntimeException e){
            System.out.println("ERRO: "+e.getMessage());
        }
    }
}
```
---
## 14. Possíveis Extensões

- Uso de DTOs
- Interface gráfica com JavaFX
- Validações mais robustas
---