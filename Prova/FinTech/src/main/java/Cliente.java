import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Representa um cliente do banco, identificado por um CPF único,
 * que pode possuir uma ou mais {@link Conta}s associadas.
 *
 * <p>Regras principais:
 * <ul>
 *   <li>O CPF é obrigatório, não pode ser nulo ou vazio, e é imutável após a criação.</li>
 *   <li>O nome é obrigatório e pode ser alterado posteriormente.</li>
 *   <li>O cliente pode ter múltiplas contas associadas.</li>
 * </ul>
 */
public class Cliente {
    private final String cpf;
    private String nome;
    private final List<Conta> contas = new ArrayList<>();

    /**
     * Constrói um cliente com CPF e nome obrigatórios.
     *
     * @param cpf  CPF do cliente; não pode ser nulo ou vazio
     * @param nome Nome do cliente; não pode ser nulo ou vazio
     * @throws IllegalArgumentException se o CPF ou o nome forem nulos ou vazios
     */
    public Cliente(String cpf, String nome) {
        if (cpf == null || cpf.isBlank())
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");

        this.cpf = cpf;
        this.nome = nome;
    }

    /**
     * Retorna o CPF do cliente.
     *
     * @return CPF do cliente
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Retorna o nome do cliente.
     *
     * @return nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define um novo nome para o cliente.
     *
     * @param nome novo nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna um iterador das contas associadas ao cliente.
     *
     * @return {@link Iterator} da lista de contas do cliente
     */
    public Iterator<Conta> getContas() {
        return contas.iterator();
    }

    /**
     * Adiciona uma ou mais contas ao cliente.
     *
     * @param conta uma ou mais instâncias de {@link Conta} a serem associadas ao cliente
     */
    public void adicionarConta(Conta... conta) {
        Collections.addAll(this.contas, conta);
    }

    /**
     * Retorna os dados do cliente em formato legível.
     *
     * @return string contendo CPF e nome do cliente
     */
    public String obterDados() {
        return "\nCPF: " + cpf
                + "\nNome: " + nome;
    }
}
