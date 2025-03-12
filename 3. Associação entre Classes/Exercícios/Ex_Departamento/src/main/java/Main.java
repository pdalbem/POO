import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Departamento d1 = new Departamento("TI", "Tecnologia da Informação");
            Funcionario f1 = new Funcionario("Joaquim","123456789",2500.00,d1);
            Funcionario f2 = new Funcionario("Maria", "77788899944",3600.00,d1);

            d1.adicionarFuncionario(f1,f2);
            System.out.println("Folha de pagamento do departamento "+d1.getSigla());
            System.out.println(d1.calcularFolhaPagamento());

            System.out.println("Funcionários do departamento "+d1.getSigla());
            Iterator<Funcionario> it = d1.iterator();
            while (it.hasNext())
                System.out.println("Nome: "+it.next().getNome());
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
