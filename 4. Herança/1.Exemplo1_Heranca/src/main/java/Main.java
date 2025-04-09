public class Main {
    public static void main(String[] args) {
        Aluno aluno= new Aluno("111.111.111-11", "Maria","SC123456", 8);
        Professor professor = new Professor("222.222.222-22", "Joaquim", "Doutorado", "Computação");

        aluno.validarCPF();
        professor.validarCPF();

        aluno.efetuarMatricula();
        professor.atribuirDisciplina();

        System.out.println("Nome do(a) aluno(a): "+aluno.getNome());
        System.out.println("IRA do(a) aluno(a): "+aluno.getIra());
    }
}
