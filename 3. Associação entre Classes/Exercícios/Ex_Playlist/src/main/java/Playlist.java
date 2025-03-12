import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Musica> musicas = new ArrayList<>();

    public Iterator<Musica> iterator(){
        return this.musicas.iterator();
    }

    public Duration calcularDuracao(){
         if (this.musicas.isEmpty())
             throw new IllegalStateException("Playlist "+nome+ " está vazia");

        Duration soma = Duration.ZERO;
        for (Musica m : this.musicas)
            soma=soma.plus(m.getDuracao());
        return soma;
    }

    public void adicionarMusica(Musica...m){
        Collections.addAll(this.musicas,m);
    }

    public void removerMusica(Musica m){
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

//    public List<Musica> getMusicas() {
//        return musicas;
//    }
//
//    public void setMusicas(List<Musica> musicas) {
//        this.musicas = musicas;
//    }
}
