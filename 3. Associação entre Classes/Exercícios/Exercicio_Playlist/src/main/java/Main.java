import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        Musica m1 = new Musica("Musica1", "Artista1", "Samba",
                                Duration.parse("PT3M30S"));

        Musica m2 = new Musica("Musica2", "Artista2", "Samba",
                Duration.parse("PT4M40S"));

        Playlist playlist1 = new Playlist("Sambas");
        playlist1.adicionarMusica(m1,m2);

        playlist1.mostrarDados();
        System.out.println("Duração da playlist: ");
        Duration duration=playlist1.calcularDuracao();
        System.out.println(duration.toMinutesPart()+":"+duration.toSecondsPart());

    }
}