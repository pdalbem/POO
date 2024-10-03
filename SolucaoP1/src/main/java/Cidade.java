import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cidade {
    private String nome;
    private String uf;
    private List<Pessoa> pessoas = new ArrayList<>();

    public Cidade(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public List<Medico> obterMedicos(){
        List<Medico> medicos = new ArrayList<>();
        for(Pessoa pessoa: pessoas)
            if (pessoa instanceof Medico)
                medicos.add((Medico) pessoa);
        return medicos;
    }

    public void adicionarPessoa(Pessoa...p){
        Collections.addAll(pessoas,p);
    }

    public void removerPessoas(Pessoa p){
        this.pessoas.remove(p);
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

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }


}