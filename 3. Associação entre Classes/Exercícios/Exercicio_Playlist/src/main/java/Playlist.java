import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Musica> musicas = new ArrayList<>();

    public LocalTime calcularDuracao(){
        LocalTime soma = LocalTime.of(0,0,0);
        for (Musica m: musicas)
            soma = soma.plusHours(m.getDuracao().getHour())
                    .plusMinutes(m.getDuracao().getMinute())
                    .plusSeconds(m.getDuracao().getSecond());
        return soma;


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
