public class Professor extends Pessoa{
    private String matricula;
    private String titulacao;

    public Professor(String cpf, String nome, String matricula, String titulacao) {
        super(cpf, nome);
        this.matricula = matricula;
        this.titulacao = titulacao;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nCPF: "+this.getCpf()
                          +"\nNome: "+this.getNome()
                          +"\nTitulação: "+this.getTitulacao());
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}
