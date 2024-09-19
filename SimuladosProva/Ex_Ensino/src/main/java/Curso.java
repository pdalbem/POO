public class Curso {
    private String nome;
    private double valor;
    private int cargaHoraria;
    private Categoria categoria;

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", cargaHoraria=" + cargaHoraria +
                ", categoria=" + categoria.getNome() +
                '}';
    }

    public Curso(String nome, double valor, int cargaHoraria, Categoria categoria) {
        this.nome = nome;
        this.valor = valor;
        this.cargaHoraria = cargaHoraria;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
