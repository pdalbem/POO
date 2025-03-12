import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Departamento {
    private String sigla;
    private String nome;
    private List<Funcionario> funcionarios = new ArrayList<>();

    public double calcularFolhaPagamento(){
        if (this.funcionarios.isEmpty())
            throw new IllegalStateException("Não existem funcionários neste departamento");

        double soma=0;
        for(Funcionario f:this.funcionarios)
            soma+=f.getSalario();
        return soma;
    }

    public Iterator<Funcionario> iterator(){
        return this.funcionarios.iterator();
    }

    public void adicionarFuncionario(Funcionario...f){
        Collections.addAll(this.funcionarios,f);
    }

    public void removerFuncionario(Funcionario f){
        this.funcionarios.remove(f);
    }

    public Departamento(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

/*    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }*/
}
