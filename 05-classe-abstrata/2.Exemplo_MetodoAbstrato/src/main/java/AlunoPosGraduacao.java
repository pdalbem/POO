public class AlunoPosGraduacao extends Aluno{
    private String tituloMonografia;
    private Professor orientador;

    public AlunoPosGraduacao(String cpf, String nome, double ira, String prontuario, Curso curso, String tituloMonografia, Professor orientador) {
        super(cpf, nome, ira, prontuario, curso);
        this.tituloMonografia = tituloMonografia;
        this.orientador = orientador;
    }

    public String getTituloMonografia() {
        return tituloMonografia;
    }

    public void setTituloMonografia(String tituloMonografia) {
        this.tituloMonografia = tituloMonografia;
    }

    public Professor getOrientador() {
        return orientador;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

    @Override
    public void exibirInfo() {
        System.out.println("\n CPF: " + this.getCpf()
                + "\n Nome: " + this.getNome()
                + "\n Prontuário: " + this.getProntuario()
                + "\n IRA: " + this.getIra()
                + "\n Curso: " + this.getCurso().getNome()
                +  "\n Orientador: " + this.getOrientador().getNome()
                + "\n Monografia: " + this.getTituloMonografia());
    }
}
