public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Maria",20,"Rua A, nro 10","2025.1", "ADS");

        Professor professor = new Professor("Joaquim",35, "Rua B, nro 15", 3000.00,"PROO");

        FuncAdm funcAdm = new FuncAdm("José",25, "Rua C, nro 20",1500.00,"CLT", "Coordenador");

        System.out.println("Informações do(a) professor(a)");
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Salário: " + professor.getSalario());
        System.out.println("Disciplina: " + professor.getDisciplina());
    }
}
