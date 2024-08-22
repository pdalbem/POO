import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Musica> musicas = new ArrayList<>();

    public Duration calcularDuracao(){
        Duration duracao=  Duration.ZERO;
        for (Musica m: musicas)
            duracao = duracao.plus(m.getDuracao());
        return duracao;


    }

    public void mostrarDados(){
        System.out.println("\n Nome da playlist: " + nome);
        System.out.println("\n Músicas: ");
        for (Musica m: musicas)
            m.mostrarDados();
    }

    public void adicionarMusica(Musica...m){
        Collections.addAll(this.musicas,m);
    }

    public void removerMusica(Musica m)
    {
        this.musicas.remove(m);
    }

    public Playlist(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
}
