public class Livro {
    //Todos atributos devem ser privados. Menu refactor -> Encapsulate fields...
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private double preco;

    //Método construtor vazio. Menu Code - Generate -> Constructor...Desmarque todos os atributos
    public Livro() {
    }

    //Método construtor com parâmetros. Menu Code - Generate -> Constructor...Selecione os atributos desejados
    public Livro(String titulo, String autor, int anoPublicacao, double preco) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setAnoPublicacao(anoPublicacao);
        this.setPreco(preco);
    }

    //Método construtor com parâmetros. Menu Code - Generate -> Constructor...Selecione os atributos desejados
    public Livro(String titulo, String autor) {
        this.setTitulo(titulo);
        this.setAutor(autor);
    }

    public void reajustarPreco(double porcentagem){
        setPreco(getPreco() * (1+porcentagem));
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
