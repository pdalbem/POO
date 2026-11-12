import data.dao.DoacaoDAO;
import data.dao.DoacaoDAOImpl;
import data.dao.DoadorDAO;
import data.dao.DoadorDAOImpl;
import data.db.DatabaseInitializer;
import exception.EntityAlreadyExistsException;
import exception.EntityNotFoundException;
import model.Doacao;
import model.Doador;
import model.Sexo;
import model.TipoSanguineo;
import service.DoacaoService;
import service.DoadorService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseInitializer.initialize();
            DoadorDAO doadorDAO = new DoadorDAOImpl();
            DoacaoDAO doacaoDAO = new DoacaoDAOImpl();
            DoadorService doadorService = new DoadorService(doadorDAO);
            DoacaoService doacaoService = new DoacaoService(doacaoDAO,doadorDAO);

            Doador d1 = new Doador("Joaquim","11111111111", LocalDate.of(2000, 5, 10),
                    Sexo.MASCULINO, TipoSanguineo.A_POSITIVO,75.0,LocalDate.now().minusDays(100));

            Doador d2 = new Doador(
                    "Maria","22222222222", LocalDate.of(2005, 11, 20),
                    Sexo.FEMININO,TipoSanguineo.O_POSITIVO,62.0, LocalDate.now().minusDays(100));

            Doador d3 = new Doador(
                    "José","33333333333", LocalDate.of(2000, 3, 15),
                    Sexo.MASCULINO, TipoSanguineo.O_POSITIVO,68.0,null);

            d1 = doadorService.cadastrar(d1);
            d2 = doadorService.cadastrar(d2);
            d3 = doadorService.cadastrar(d3);

            System.out.println("\nDoadores cadastrados:");
            for (Doador d : doadorService.buscarTodos())
                System.out.println(d);

            System.out.println("\nDoadores com tipo sanguíneo O POSITIVO");
            for (Doador d :  doadorService.buscarPorTipoSanguineo(TipoSanguineo.O_POSITIVO))
                System.out.println(d);

            System.out.println("\nAtualizando dados do doador 1");
            d1.setPeso(78.0);
            doadorService.atualizar(d1);

            System.out.println("\nDoadores aptos: ");
            for (Doador d : doadorService.buscarDoadoresAptos())
                System.out.println(d);

            Doacao doacao1 = new Doacao(LocalDate.now(), d1);
            Doacao doacao2 = new Doacao(LocalDate.now(), d2);
            Doacao doacao3 = new Doacao(LocalDate.now(), d3);

            doacao1 = doacaoService.cadastrar(doacao1);
            doacao2 = doacaoService.cadastrar(doacao2);
            doacao3 = doacaoService.cadastrar(doacao3);

            System.out.println("\nDoações cadastradas");
            for (Doacao d : doacaoService.buscarTodos())
                System.out.println(d);

            System.out.println("\nDoações de " + d1.getNome());
            for (Doacao d : doacaoService.buscarPorDoador(d1))
                System.out.println(d);


            System.out.println("\nDoações de " + d2.getNome());
            for (Doacao d : doacaoService.buscarPorDoador(d2))
                System.out.println(d);

        } catch (IllegalArgumentException | IllegalStateException |
                 EntityAlreadyExistsException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}