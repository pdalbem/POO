import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cidade {
    private String nome;
    private String uf;
    private List<Funcionario> funcionarios = new ArrayList<>();

    //Metodo com quantidade variavel de parametros
    //Utilizado para atribuir objetos Funcionario à uma determinada cidade
    public void adicionarFuncionario(Funcionario...f){
        Collections.addAll(this.funcionarios,f);
//        Mesmo que:
//        for (Funcionario func:f)
//            this.funcionarios.add((func));
    }

    public void removerFuncionario(Funcionario f){
        this.funcionarios.remove((f));
    }

    public Cidade() {
    }

    public Cidade(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

 //Não será preciso. Os Funcionarios serão adicionados via metodo adicionarFuncionario(Funcionario...f)
//    public void setFuncionarios(List<Funcionario> funcionarios) {
//        this.funcionarios = funcionarios;
//    }
}
