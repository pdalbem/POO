public class AlunoGraduacao extends Aluno{
    private double horasAtividades;

    public AlunoGraduacao(String cpf, String nome, String prontuario, double ira, Curso curso, double horasAtividades) {
        super(cpf, nome, prontuario, ira, curso);
        this.horasAtividades = horasAtividades;
    }

    public double getHorasAtividades() {
        return horasAtividades;
    }

    public void setHorasAtividades(double horasAtividades) {
        this.horasAtividades = horasAtividades;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nNome: "+this.getNome()
                           +"\nCurso: "+this.getCurso().getNome()
                           +"\nHoras de atividades: "+this.getHorasAtividades());
    }
}
