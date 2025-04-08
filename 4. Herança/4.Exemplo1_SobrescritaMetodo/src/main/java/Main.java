public class Main {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("José", 2500);
        Gerente g = new Gerente("Maria", 5000,3);
        Vendedor v = new Vendedor("Joaquim", 3000, 20000);

        f.exibirInfo();
        g.exibirInfo();
        v.exibirInfo();

        System.out.println("\nBônus do funcionário "+f.getNome()+": "+f.calcularBonus());
        System.out.println("Bônus do gerente "+g.getNome()+": "+g.calcularBonus());
        System.out.println("Bônus do vendedor "+v.getNome()+": "+v.calcularBonus());
    }
}
