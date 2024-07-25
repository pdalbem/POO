import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Departamento {
    private String nome;
    private String sigla;
    private List<Funcionario> funcionarios = new ArrayList<>();


    public double calcularFolhaPagamento(){
        double soma=0;
        for (Funcionario f: this.funcionarios)
            soma = soma + f.getSalario();
        return soma;
    }

    public void mostrarFuncionarios(){
        for (Funcionario f: this.funcionarios)
              f.mostrarDados();
    }


    public void adicionarFuncionario(Funcionario...f){
        Collections.addAll(this.funcionarios,f);

     //Outra forma de adicionar:
    /*  for (Funcionario func: f)
            this.funcionarios.add(func);*/

    }

    public void removerFuncionario(Funcionario f){
        this.funcionarios.remove(f);
    }

    public Departamento(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
