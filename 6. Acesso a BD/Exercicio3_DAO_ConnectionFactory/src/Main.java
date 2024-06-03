import data.PartidaSQLiteDAO;
import data.TimeSQLiteDAO;
import model.Partida;
import model.Time;

public class Main {
    public static void main(String[] args) {
        Time t1 = new Time(1,"Brasil");
        Time t2 = new Time(2, "Argentina");

        TimeSQLiteDAO timeDAO = new TimeSQLiteDAO();
        timeDAO.save(t1);
        timeDAO.save(t2);

        for (Time time: timeDAO.findAll())
            System.out.println(time);


        Partida partida = new Partida(1,"02/06/2024",
                    t1,t2,0,0);

        PartidaSQLiteDAO partidaDAO = new PartidaSQLiteDAO();
        partidaDAO.save(partida);

        partida.atualizarResultado(1,0);
        partidaDAO.update(partida);

        for(Partida p : partidaDAO.findAll())
            p.mostrarResultado();

    }
}