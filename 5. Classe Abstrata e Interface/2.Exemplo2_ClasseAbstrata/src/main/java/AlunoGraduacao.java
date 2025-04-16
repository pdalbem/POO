public class AlunoGraduacao extends Aluno{
    private double horasAtividadeComplementar;

    public AlunoGraduacao(String cpf, String nome, double ira, String prontuario, Curso curso, double horasAtividadeComplementar) {
        super(cpf, nome, ira, prontuario, curso);
        this.horasAtividadeComplementar = horasAtividadeComplementar;
    }

    public double getHorasAtividadeComplementar() {
        return horasAtividadeComplementar;
    }

    public void setHorasAtividadeComplementar(double horasAtividadeComplementar) {
        this.horasAtividadeComplementar = horasAtividadeComplementar;
    }


    @Override
    public void exibirInfo() {
        System.out.println("\n CPF: " + this.getCpf()
                            + "\n Nome: " + this.getNome()
                            + "\n Prontuário: " + this.getProntuario()
                            + "\n IRA: " + this.getIra()
                            + "\n Curso: " + this.getCurso().getNome()
                            + "\n Horas:" + this.getHorasAtividadeComplementar());
    }
}
