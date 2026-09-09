class Professor extends Funcionario {
    public String tipo = "Professor";

    @Override
    public void mostrarTipo() {
        System.out.println("Professor");
    }
}