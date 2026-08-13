import java.time.Duration;

public class Musica {
    private String titulo;
    private String artista;
    private Duration duracao;
    private String estilo;

    public Musica(String titulo, String artista, Duration duracao, String estilo) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.estilo = estilo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
