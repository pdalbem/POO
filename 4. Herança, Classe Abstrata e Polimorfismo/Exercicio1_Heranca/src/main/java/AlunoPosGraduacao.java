public class AlunoPosGraduacao extends Aluno{
    private String tituloMonografia;
    private Professor orientador;


    public AlunoPosGraduacao(String cpf, String nome, String prontuario, double ira, Curso curso, String tituloMonografia, Professor orientador) {
        super(cpf, nome, prontuario, ira, curso);
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
    public void mostrarDados() {
        System.out.println("\nNome: "+this.getNome()
                           +"\nProntuário: "+this.getProntuario()
                           +"\nOrientador: "+this.getOrientador().getNome());
    }
}
