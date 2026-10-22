public class Livro {
    private final int id;
    private String titulo;
    private double preco;

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                '}';
    }

    public Livro(int id, String titulo, double preco) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
