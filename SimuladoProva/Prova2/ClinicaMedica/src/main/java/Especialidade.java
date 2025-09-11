public class Especialidade implements IdentificacaoAutomatica {
    private final int id;
    private String descricao;
    private static int contador = 1;

    @Override
    public int gerarID() {
        return contador++;
    }

    public Especialidade(String descricao) {
        this.id = gerarID();
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nDescricao: " + descricao ;
    }
}
