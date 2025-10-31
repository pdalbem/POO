import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PessoaFisica extends Cliente {
    private final String cpf;
    private final String nome;


    public PessoaFisica(int id, String endereco, String nome, String cpf) {
        super(id, endereco);
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String obterDados() {
        return "----- Dados PF -----" +
                "\nID: " + super.getId() +
                "\nCPF: " + getCpf() +
                "\nNome: " + getNome() +
                "\n----------------------------";
    }
}
