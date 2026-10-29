import data.dao.ProprietarioDAOImpl;
import data.dao.VeiculoDAOImpl;
import data.db.DatabaseInitializer;
import exception.EntityAlreadyExistsException;
import exception.EntityNotFoundException;
import model.Proprietario;
import model.Veiculo;
import service.ProprietarioService;
import service.VeiculoService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseInitializer.initialize();

            ProprietarioService proprietarioService = new ProprietarioService(new ProprietarioDAOImpl());
            VeiculoService veiculoService = new VeiculoService(new VeiculoDAOImpl());

            Proprietario proprietario =  new Proprietario("Carlos Silva");
            proprietario = proprietarioService.cadastrar(proprietario);

            Veiculo veiculo = new Veiculo("ABC1D23","Toyota", proprietario);
            veiculo = veiculoService.cadastrar(veiculo);

            Optional<Veiculo> encontrado = veiculoService.buscarPorPlaca("ABC1D23");
            if (encontrado.isPresent())
                System.out.println(encontrado.get());


            System.out.println("\nTodos os veículos:");
            for (Veiculo v : veiculoService.buscarTodos())
                System.out.println(v);

        }catch (IllegalArgumentException | EntityAlreadyExistsException | EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
