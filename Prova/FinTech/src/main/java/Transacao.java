import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa uma transação financeira realizada em uma {@link Conta}.
 * Pode ser do tipo {@link TipoOperacao#DEPOSITO}, {@link TipoOperacao#SAQUE},
 * {@link TipoOperacao#TAXA} ou {@link TipoOperacao#TRANSFERENCIA}.
 *
 * <p>Regras principais:
 * <ul>
 *   <li>Todo valor deve ser positivo.</li>
 *   <li>Não é permitido operar em contas inativas.</li>
 *   <li>O saldo da conta deve ser suficiente para saques, taxas ou transferências.</li>
 *   <li>Transações de saque automaticamente geram uma transação de taxa de 2%.</li>
 *   <li>Transações de transferência afetam tanto a conta de origem quanto a de destino.</li>
 * </ul>
 */
public class Transacao {
    private static final List<Transacao> historicoGlobal = new ArrayList<>();
    private static int contador = 1;

    private final int id;
    private final LocalDateTime dataHora;
    private final TipoOperacao tipoOperacao;
    private final double valor;
    private final Conta origem;
    private final Conta destino;

    /**
     * Cria uma transação financeira, podendo envolver apenas uma conta
     * (depósito, saque ou taxa) ou duas contas (transferência).
     *
     * @param dataHora      Data e hora da transação
     * @param tipoOperacao  Tipo da operação ({@link TipoOperacao})
     * @param valor         Valor da transação (positivo)
     * @param origem        Conta de origem (não pode ser nula)
     * @param destino       Conta de destino (somente para transferências; pode ser {@code null})
     * @throws IllegalArgumentException se algum parâmetro for inválido
     * @throws IllegalStateException    se regras de negócio forem violadas (saldo insuficiente ou conta inativa)
     */
    public Transacao(LocalDateTime dataHora, TipoOperacao tipoOperacao, double valor, Conta origem, Conta destino) {
        validarDataHora(dataHora);
        validarValor(valor);

        this.id = contador++;
        this.dataHora = dataHora;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
        this.origem = origem;
        this.destino = destino;

        executar();
        registrar();
    }

    /**
     * Construtor auxiliar para transações que envolvem apenas uma conta
     * (depósito, saque ou taxa).
     *
     * @param dataHora      Data e hora da transação
     * @param tipoOperacao  Tipo da operação ({@link TipoOperacao}), não pode ser TRANSFERENCIA
     * @param valor         Valor da transação (positivo)
     * @param origem        Conta de origem (não pode ser nula)
     */
    public Transacao(LocalDateTime dataHora, TipoOperacao tipoOperacao, double valor, Conta origem) {
        this(dataHora, tipoOperacao, valor, origem, null);
    }

    // ---------- Validações ----------

    private void validarDataHora(LocalDateTime dataHora) {
        if (dataHora == null)
            throw new IllegalArgumentException("Data não pode ser nula");
    }

    private void validarValor(double valor) {
        if (valor <= 0)
            throw new IllegalArgumentException("Valor deve ser positivo");
    }

    private void validarConta(Conta conta) {
        if (conta == null)
            throw new IllegalArgumentException("Conta não pode ser nula");
        if (!conta.isAtiva())
            throw new IllegalStateException("Conta " + conta.getNumero() + " deve estar ativa");
    }

    private void validarSaldo(double saldo, double valorOperacao) {
        if (saldo < valorOperacao)
            throw new IllegalStateException("Saldo insuficiente");
    }

    /**
     * Executa a lógica da transação conforme o tipo informado.
     * <ul>
     *   <li>DEPOSITO: credita o valor na conta de origem.</li>
     *   <li>SAQUE: debita o valor + taxa de 2%, gerando uma transação de TAXA.</li>
     *   <li>TAXA: debita o valor da conta.</li>
     *   <li>TRANSFERENCIA: debita da origem e credita na conta de destino.</li>
     * </ul>
     */
    private void executar() {
        switch (tipoOperacao) {
            case DEPOSITO -> {
                validarConta(origem);
                origem.creditar(valor);
            }
            case SAQUE -> {
                validarConta(origem);
                double taxa = valor * 0.02;
                validarSaldo(origem.getSaldo(), valor + taxa);
                origem.debitar(valor);
                new Transacao(dataHora, TipoOperacao.TAXA, taxa, origem);
            }
            case TAXA -> {
                validarConta(origem);
                validarSaldo(origem.getSaldo(), valor);
                origem.debitar(valor);
            }
            case TRANSFERENCIA -> {
                validarConta(origem);
                validarConta(destino);
                if (origem == destino)
                    throw new IllegalArgumentException("Conta origem e destino não podem ser as mesmas");
                validarSaldo(origem.getSaldo(), valor);
                origem.debitar(valor);
                destino.creditar(valor);
            }
        }
    }

    /**
     * Registra a transação na conta de origem, na conta de destino (quando aplicável)
     * e no histórico global de transações.
     */
    private void registrar() {
        origem.adicionarTransacao(this);
        if (destino != null)
            destino.adicionarTransacao(this);
        historicoGlobal.add(this);
    }

    /**
     * Retorna um iterador do histórico global de transações.
     *
     * @return iterador de todas as transações realizadas
     */
    public static Iterator<Transacao> obterHistoricoGlobalTransacoes() {
        return historicoGlobal.iterator();
    }

    /**
     * Retorna os dados da transação em formato legível.
     *
     * @return string contendo ID, data, operação, valor, conta de origem e conta de destino (quando aplicável)
     */
    public String obterDados() {
        String retorno = "\nID: " + id
                + "\nData: " + dataHora.format(DateTimeFormatter.ofPattern("d/M/yyyy-HH:mm"))
                + "\nOperação: " + tipoOperacao
                + "\nValor: " + String.format("%.2f", valor)
                + "\nConta Origem: " + origem.getNumero();
        if (destino != null)
            retorno += "\nConta Destino: " + destino.getNumero();
        return retorno;
    }

    // ---------- Getters ----------

    /**
     * Retorna o identificador único da transação.
     *
     * @return identificador único
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna a data e hora da transação.
     *
     * @return data e hora da transação
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Retorna o tipo da operação realizada.
     *
     * @return tipo da operação
     */
    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    /**
     * Retorna a conta de origem da operação.
     *
     * @return conta de origem
     */
    public Conta getOrigem() {
        return origem;
    }

    /**
     * Retorna a conta de destino da operação, se aplicável.
     *
     * @return conta de destino ou {@code null} se não houver
     */
    public Conta getDestino() {
        return destino;
    }

    /**
     * Retorna o valor da operação.
     *
     * @return valor da transação
     */
    public double getValor() {
        return valor;
    }
}
