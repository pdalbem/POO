import java.time.LocalDateTime;
import java.util.Iterator;

/**
 * Classe principal para testar o sistema bancário.
 * <p>
 * Cria clientes, contas e realiza transações de depósito, saque e transferência.
 * Exibe o histórico das contas e o histórico global de transações.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Cliente cliente = new Cliente("12345678910", "Maria");
            Conta conta1 = new Conta(cliente);
            Conta conta2 = new Conta(cliente);

            Transacao transacao1 = new Transacao(LocalDateTime.now(),TipoOperacao.DEPOSITO,100,conta1);
            Transacao transacao2 = new Transacao(LocalDateTime.now(),TipoOperacao.SAQUE, 50,conta1);
            Transacao transacao3 = new Transacao(LocalDateTime.now(),  TipoOperacao.TRANSFERENCIA,20, conta1,conta2);

            System.out.print("Transações da Conta "+conta1.getNumero());
            Iterator<Transacao> it = conta1.getTransacoes();
            while (it.hasNext()) {
                Transacao next =  it.next();
                System.out.println(next.obterDados());
            }

            System.out.print("\n\nHistórico Global de Transações");
            Iterator<Transacao> historicoGlobal = Transacao.obterHistoricoGlobalTransacoes();
            while (historicoGlobal.hasNext()) {
                Transacao next =  historicoGlobal.next();
                System.out.println(next.obterDados());
            }

            System.out.print("\n\nExtrato da Conta "+conta2.getNumero());
            Iterator<Transacao> extrato = conta2.obterExtrato(LocalDateTime.of(2025,9,1,0,0),LocalDateTime.now());
            while (extrato.hasNext()) {
                Transacao next =  extrato.next();
                System.out.println(next.obterDados());
            }

            System.out.println("\nSaldo da conta 1: "+conta1.getSaldo());
            System.out.println("Saldo da conta 2: "+conta2.getSaldo());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
