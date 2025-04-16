public abstract class Aluno extends Pessoa{ //Classe abstrata.
    private double ira;
    private String prontuario;
    private Curso curso;

    public Aluno(String cpf, String nome, double ira, String prontuario, Curso curso) {
        super(cpf, nome);
        this.ira = ira;
        this.prontuario = prontuario;
        this.curso = curso;
    }

    public double getIra() {
        return ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
