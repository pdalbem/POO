import data.*;
import model.Candidato;
import model.Cargo;
import model.Partido;


public class Main {
    public static void main(String[] args) {
        Partido partido1 = new Partido(1, "Partido1", "P1");
        Partido partido2 = new Partido(2, "Partido2", "P2");

        PartidoSQliteDAO partidoDAO = new PartidoSQliteDAO();
        partidoDAO.save(partido1);
        partidoDAO.save(partido2);

        Cargo cargo1 = new Cargo(10, "Prefeito");
        Cargo cargo2 = new Cargo(20, "Vereador");

        CargoSQliteDAO cargoDAO = new CargoSQliteDAO();
        cargoDAO.save(cargo1);
        cargoDAO.save(cargo2);

        Candidato candidato1 = new Candidato(1010, "Maria", cargo1, partido1);
        Candidato candidato2 = new Candidato(2020, "João", cargo2, partido2);

        CandidatoSQliteDAO candidatoDAO = new CandidatoSQliteDAO();
        candidatoDAO.save(candidato1);
        candidatoDAO.save(candidato2);

        System.out.println("\nPartidos:");
        for (Partido p : partidoDAO.findAll())
            System.out.println(p);


        System.out.println("\nCargos:");
        for (Cargo c :cargoDAO.findAll())
            System.out.println(c);

        System.out.println("\nCandidatos:");
        for (Candidato c : candidatoDAO.findAll())
            System.out.println(c);

    }
}
