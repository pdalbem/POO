import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Cidade cidade = new Cidade("São Carlos", "SP");

        Funcionario func1 = new Funcionario("Joaquim", "12345678910", cidade);

        Funcionario func2 = new Funcionario("Maria", "99988877766", cidade);

        System.out.println("Funcionários de "+cidade.getNome());
        Iterator<Funcionario> it = cidade.iterator();
        while (it.hasNext())
        {
            Funcionario f = it.next();
            System.out.println("Nome: "+f.getNome());
            System.out.println("CPF: "+ f.getCpf());
        }
    }
}
