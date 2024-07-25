import java.time.LocalTime;

public class Musica {
    private String titulo;
    private String artista;
    private String estilo;
    private LocalTime duracao;

    public void mostrarDados(){
        System.out.println("\n Título: " + titulo
                          + "\n Artista: " + artista
                          + "\n Estilo: " + estilo
                          + "\n Duração: " + duracao);
    }

    public Musica(String titulo, String artista, String estilo, LocalTime duracao) {
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

    public LocalTime getDuracao() {
        return duracao;
    }

    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
    }
}
