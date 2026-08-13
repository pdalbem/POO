import adapter.config.AppConfig;
import adapter.config.DatabaseInitializer;
import domain.entity.Proprietario;
import domain.entity.Veiculo;
import domain.exception.EntityAlreadyExistsException;
import usecase.ProprietarioUseCase;
import usecase.VeiculoUseCase;

import java.util.Iterator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.init(); // Crie este método para garantir que as tabelas existam

        VeiculoUseCase veiculoUseCase = AppConfig.createVeiculoUseCase();
        ProprietarioUseCase proprietarioUseCase = AppConfig.createProprietarioUseCase();

        try {
            // Inserindo proprietários
            Proprietario p1 = new Proprietario("Joaquim");
            Proprietario p2 = new Proprietario("Maria");
            proprietarioUseCase.insertProprietario(p1);
            proprietarioUseCase.insertProprietario(p2);

            // Inserindo veículos
            Veiculo v1 = new Veiculo("ABC12345", "Fiat Uno", p1);
            Veiculo v2 = new Veiculo("XYZ98765", "Honda Civic", p2);
            veiculoUseCase.insertVeiculo(v1);
            veiculoUseCase.insertVeiculo(v2);

            // Buscar por ID
            System.out.println("\nBuscando proprietário por ID");
            Optional<Proprietario> propOpt = proprietarioUseCase.findProprietarioById(p1.getId());
            if (propOpt.isPresent())
                System.out.println(propOpt.get());
            else
                System.out.println("Proprietário não encontrado com id especificado");


            System.out.println("\nBuscando veículo por ID");
            Optional<Veiculo> veicOpt = veiculoUseCase.findVeiculoById(v1.getId());
            if (veicOpt.isPresent())
                System.out.println(veicOpt.get());
            else
                System.out.println("Veículo não encontrado com o id especificado");


            // Buscar por placa
            System.out.println("\nBuscando veículo por placa");
            veicOpt = veiculoUseCase.findVeiculoByPlaca("ABC1234");
            if (veicOpt.isPresent())
                System.out.println(veicOpt.get());
            else
                System.out.println("Veículo não encontrado com a placa especificada");


            // Listar veículos de um proprietário
            System.out.println("\nVeículos do proprietário " + p1.getNome());
            Iterator<Veiculo> it = veiculoUseCase.findVeiculosByProprietario(p1);
            while (it.hasNext()) {
                Veiculo v = it.next();
                System.out.println(v);
            }

            // Listar todos os veículos
            System.out.println("\nTodos os veículos cadastrados:");
            it = veiculoUseCase.listAllVeiculos();
            while (it.hasNext()) {
                Veiculo v = it.next();
                System.out.println(v);
            }

        } catch (EntityAlreadyExistsException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}
