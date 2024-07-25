import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Musica m1 = new Musica("Musica1", "Artista1", "Samba",
                                LocalTime.of(0,3,30));

        Musica m2 = new Musica("Musica2", "Artista2", "Samba",
                                LocalTime.of(0,5,50));

        Playlist playlist1 = new Playlist("Sambas");
        playlist1.adicionarMusica(m1,m2);

        playlist1.mostrarDados();
        System.out.println("Duração da playlist: ");
        System.out.println(playlist1.calcularDuracao());

    }
}