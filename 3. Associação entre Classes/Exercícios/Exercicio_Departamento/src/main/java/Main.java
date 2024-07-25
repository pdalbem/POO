public class Main {
    public static void main(String[] args) {
        Departamento d1 = new Departamento("Tecnologia da Informação", "TI");

        Funcionario f1 = new Funcionario("Maria", "123456", 3000, d1);

        Funcionario f2 = new Funcionario("José", "989898", 2000, d1);
        Funcionario f3 = new Funcionario("joão", "7777", 1500, d1);

        d1.adicionarFuncionario(f1,f2,f3);
        System.out.println("\n Folha de pagamento do departamento "
                           + d1.getSigla() + ": "+ d1.calcularFolhaPagamento());

        System.out.println("Funcionários de " + d1.getSigla() + ": ");
        d1.mostrarFuncionarios();

    }
}