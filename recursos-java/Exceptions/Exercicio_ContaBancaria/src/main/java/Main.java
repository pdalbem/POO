import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Conta conta1 = lerDados();
            Conta conta2 = lerDados();

            conta1.depositar(300);
            conta1.transferir(conta2,200);

            System.out.println("Saldo da conta1: "+conta1.getSaldo());
            System.out.println("Saldo da conta2: "+conta2.getSaldo());

        } catch (InputMismatchException e) {
            System.out.println("ERRO: entrada inválida");;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }
    }

   public static Conta  lerDados(){
       Scanner scanner = new Scanner(System.in);

       System.out.print("Digite o nome do titular da conta: ");
       String titular = scanner.nextLine();

       System.out.print("Digite o saldo inicial da conta: ");
       double saldo = scanner.nextDouble();

       return new Conta(titular, saldo);

   }
}
