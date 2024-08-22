import java.time.Duration;

public class Musica {
    private String titulo;
    private String artista;
    private String estilo;
    private Duration duracao;

    public void mostrarDados(){
        System.out.println("\n Título: " + titulo
                          + "\n Artista: " + artista
                          + "\n Estilo: " + estilo
                          + "\n Duração: " + duracao.toMinutesPart()+":"+duracao.toSecondsPart());
    }

    public Musica(String titulo, String artista, String estilo, Duration duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.estilo = estilo;
        this.duracao = duracao;
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

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }
}
