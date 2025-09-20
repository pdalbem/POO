import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Representa uma conta bancária associada a um {@link Cliente}.
 * <p>
 * Cada conta possui um número único, saldo, status de atividade e histórico de transações.
 * <p>
 * Regras principais:
 * <ul>
 *   <li>O número da conta é gerado automaticamente e único.</li>
 *   <li>O saldo inicial é zero e a conta é criada como ativa.</li>
 *   <li>Não é possível encerrar a conta se o saldo for diferente de zero.</li>
 *   <li>As transações são armazenadas em uma lista específica da conta.</li>
 * </ul>
 */
public class Conta {
    private static int contador = 1;
    private final int numero;
    private double saldo;
    private boolean ativa;
    private final Cliente cliente;
    private final List<Transacao> transacoes = new ArrayList<>();

    /**
     * Cria uma nova conta bancária para o cliente informado.
     * <p>
     * A conta inicia com saldo zero e status ativa.
     *
     * @param cliente o titular da conta; não pode ser nulo
     * @throws IllegalArgumentException se o cliente for nulo
     */
    public Conta(Cliente cliente) {
        if (cliente == null)
            throw new IllegalArgumentException("Titular da conta não pode ser nulo");

        this.numero = contador++;
        this.saldo = 0;
        this.ativa = true;
        this.cliente = cliente;
    }

    /**
     * Debita um valor do saldo da conta.
     *
     * @param valor o valor a ser debitado
     */
    public void debitar(double valor) {
        this.saldo -= valor;
    }

    /**
     * Credita um valor no saldo da conta.
     *
     * @param valor o valor a ser creditado
     */
    public void creditar(double valor) {
        this.saldo += valor;
    }

    /**
     * Encerra a conta, tornando-a inativa.
     * <p>
     * A conta só pode ser encerrada se estiver ativa e com saldo zero.
     *
     * @throws IllegalStateException se a conta já estiver encerrada ou saldo for diferente de zero
     */
    public void encerrarConta() {
        if (!isAtiva())
            throw new IllegalStateException("Conta já está encerrada");

        if (this.saldo != 0)
            throw new IllegalStateException("Conta só pode ser encerrada com saldo 0");

        this.ativa = false;
    }

    /**
     * Retorna um iterador com as transações da conta dentro de um intervalo de datas.
     *
     * @param dataInicio a data inicial (inclusive)
     * @param dataFim    a data final (inclusive)
     * @return um {@link Iterator} das transações filtradas pelo intervalo
     */
    public Iterator<Transacao> obterExtrato(LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Transacao> transacoesFiltradas = new ArrayList<>();
        for (Transacao t : this.transacoes) {
            if (!t.getDataHora().isBefore(dataInicio) && !t.getDataHora().isAfter(dataFim)) {
                transacoesFiltradas.add(t);
            }
        }
        return transacoesFiltradas.iterator();
    }

    /**
     * Retorna o número único da conta.
     *
     * @return o número da conta
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retorna o saldo atual da conta.
     *
     * @return o saldo da conta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Verifica se a conta está ativa.
     *
     * @return {@code true} se a conta estiver ativa; {@code false} caso contrário
     */
    public boolean isAtiva() {
        return ativa;
    }

    /**
     * Retorna o cliente titular da conta.
     *
     * @return o {@link Cliente} associado à conta
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Retorna um iterador das transações da conta.
     *
     * @return um {@link Iterator} das transações da conta
     */
    public Iterator<Transacao> getTransacoes() {
        return transacoes.iterator();
    }

    /**
     * Adiciona uma ou mais transações à lista de transações da conta.
     *
     * @param transacao uma ou mais instâncias de {@link Transacao} a serem adicionadas
     */
    public void adicionarTransacao(Transacao... transacao) {
        Collections.addAll(this.transacoes, transacao);
    }
}
