import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Departamento d1 = new Departamento("TI", "Tecnologia da Informação");
        Funcionario f1 = new Funcionario("Joaquim","123456789",2500.00f,d1);
        Funcionario f2 = new Funcionario("Maria", "77788899944",3600.00f,d1);

        System.out.println("Folha de pagamento do departamento "+d1.getSigla());
        System.out.println(d1.calcularFolhaPagamento());

        System.out.println("Média salarial do departamento "+d1.getSigla());
        System.out.println(d1.obterMediaSalarial());

        System.out.println("Funcionários do departamento "+d1.getSigla());
        Iterator<Funcionario> it = d1.iterator();
        while (it.hasNext())
            System.out.println("Nome: "+it.next().getNome());

        Departamento d2 = new Departamento("RH", "Recursos Humanos");
        f1.transferirDepartamento(d2);

        System.out.println("Funcionários do departamento "+d1.getSigla());
        it = d1.iterator();
        while (it.hasNext())
            System.out.println("Nome: "+it.next().getNome());

        System.out.println("Funcionários do departamento "+d2.getSigla());
        it = d2.iterator();
        while (it.hasNext())
            System.out.println("Nome: "+it.next().getNome());

    }
}
