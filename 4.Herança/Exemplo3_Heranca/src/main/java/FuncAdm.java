public class FuncAdm extends  Funcionario{
    private String setor;
    private String funcao;

    public FuncAdm(String nome, int idade, String endereco, double salario, String setor, String funcao) {
        super(nome, idade, endereco, salario);
        this.setSetor(setor);
        this.setFuncao(funcao);
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
