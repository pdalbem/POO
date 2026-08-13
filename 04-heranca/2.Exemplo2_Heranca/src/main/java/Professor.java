public class Professor extends Pessoa{
    private String titulacao;
    private String areaAtuacao;

    public void atribuirDisciplina(){
        System.out.println("Atribuindo disciplina para o(a) professor(a) "+this.getNome());
    }

    public Professor(String cpf, String nome, Cidade cidade, String titulacao, String areaAtuacao) {
        super(cpf, nome, cidade);
        this.titulacao = titulacao;
        this.areaAtuacao = areaAtuacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
}
