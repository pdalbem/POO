public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Professor();

        System.out.println(funcionario.tipo);
        funcionario.mostrarTipo();
    }
}
