import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("José", 2500);
        Funcionario g = new Gerente("Maria", 5000,3);
        Funcionario v = new Vendedor("Joaquim", 3000, 20000);

        List<Funcionario> lista = new ArrayList<>();
        lista.add(f);
        lista.add(g);
        lista.add(v);

        for (Funcionario func : lista){
            func.exibirInfo();
            System.out.println("Bônus: " + func.calcularBonus());
        }
    }
}
