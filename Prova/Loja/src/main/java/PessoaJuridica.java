import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PessoaJuridica extends Cliente {
    private final String cnpj;
    private final String razaoSocial;

    public PessoaJuridica(int id, String endereco, String cnpj, String razaoSocial) {
        super(id, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String obterDados() {
        return "----- Dados PJ -----" +
                "\nID: " + super.getId() +
                "\nCNPJ: " + getCnpj() +
                "\nRazão Social: " + getRazaoSocial() +
                "\n----------------------------";
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }
}
