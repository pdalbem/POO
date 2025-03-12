import java.time.Duration;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Musica m1 = new Musica("Musica1", "Artista1", Duration.parse("PT2M30S"), "Estilo1");
            Musica m2 = new Musica("Musica2", "Artista2", Duration.parse("PT4M40S"), "Estilo2");

            Playlist playlist1 = new Playlist("Playlis1");
            playlist1.adicionarMusica(m1,m2);

            Duration duracaoPlaylist1 = playlist1.calcularDuracao();
            System.out.print("Duração total da playlist "+playlist1.getNome()+":");
            System.out.println(duracaoPlaylist1.toHoursPart()+":"+duracaoPlaylist1.toMinutesPart()
                                     +":"+duracaoPlaylist1.toSecondsPart());

            System.out.println("Músicas da playlist "+playlist1.getNome());
            Iterator<Musica> it = playlist1.iterator();
            while (it.hasNext()){
                Musica m = it.next();
                System.out.println("Título: "+m.getTitulo());
                System.out.println("Artista: "+m.getArtista());
                System.out.println("Estilo: "+m.getEstilo());
                System.out.println("Duração: "+m.getDuracao().toMinutesPart()+":"+m.getDuracao().toSecondsPart());
            }

        }catch (IllegalArgumentException | IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }
}
