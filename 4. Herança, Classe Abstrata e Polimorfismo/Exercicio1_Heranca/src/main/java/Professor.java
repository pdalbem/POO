import java.util.Objects;

public class Professor extends Pessoa{
    private String matricula;
    private String titulacao;

    //Implementação do método abstrato.
    @Override
    public void mostrarDados() {
        System.out.println("\n CPF: "+ this.getCpf()
                + "\n Nome: " + this.getNome()
                + "\n Titulação: "+ this.getTitulacao()
                + "\n Matrícula: " + this.getMatricula());
    }


    public Professor(String cpf, String nome, String matricula, String titulacao) {
        super(cpf, nome);
        this.matricula = matricula;
        this.titulacao = titulacao;
    }

    public Professor(String cpf, String nome) {
        super(cpf, nome);
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
