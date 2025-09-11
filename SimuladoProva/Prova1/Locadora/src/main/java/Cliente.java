
import java.time.LocalDate;
import java.util.*;

public class Cliente {
    private String cpf;
    private String nome;
    private final List<Locacao> locacoes = new ArrayList<>();

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Iterator<Locacao> obterLocacoes(){
        return this.locacoes.iterator();
    }

    public Iterator<Locacao> obterLocacoes(LocalDate dataInicial) {
        List<Locacao> listaFiltro = new ArrayList<>();
        for (Locacao locacao : this.locacoes)
            //if (!locacao.getDataLocacao().isBefore(dataInicial))
            if (locacao.getDataLocacao().isAfter(dataInicial) || locacao.getDataLocacao().isEqual(dataInicial))
                listaFiltro.add(locacao);

        return listaFiltro.iterator();
    }

    public Iterator<Locacao> obterLocacoes(Categoria categoria) {
        List<Locacao> listaFiltro = new ArrayList<>();
        for (Locacao locacao : this.locacoes)
            //if (locacao.getVeiculo().getCategoria().getDescricao()== categoria.getDescricao())
            if (locacao.getVeiculo().getCategoria().equals(categoria))
                listaFiltro.add(locacao);

        return listaFiltro.iterator();
    }

    public boolean possuiLocacaoAtiva() {
        for (Locacao locacao : this.locacoes)
            if (locacao.isLocacaoAtiva())
                return true;

        return false;
    }

    public void adicionarLocacoes(Locacao...locacao) {
        Collections.addAll(this.locacoes, locacao);
    }

    public void removerLocacao(Locacao locacao) {
        this.locacoes.remove(locacao);
    }
}
