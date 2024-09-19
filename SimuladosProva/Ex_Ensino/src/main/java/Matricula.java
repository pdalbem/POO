public class Matricula {
    private double nota;
    private int frequencia;
    private Turma turma;
    private Aluno aluno;

    public Matricula(double nota, int frequencia, Turma turma, Aluno aluno) {
        this.nota = nota;
        this.frequencia = frequencia;
        this.turma = turma;
        this.aluno = aluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
