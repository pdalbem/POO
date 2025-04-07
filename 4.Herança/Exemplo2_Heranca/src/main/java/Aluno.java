public class Aluno extends Pessoa{
    private String prontuario;
    private double ira;

    public void efetuarMatricula(){
        System.out.println("Efetuando matrícula do(a) aluno(a) "+ this.getNome());
    }

    public Aluno(String cpf, String nome, Cidade cidade, String prontuario, double ira) {
        super(cpf, nome, cidade);
        this.prontuario = prontuario;
        this.ira = ira;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public double getIra() {
        return ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }
}
