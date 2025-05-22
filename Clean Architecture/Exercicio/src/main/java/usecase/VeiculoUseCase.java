package usecase;

import domain.entity.Proprietario;
import domain.entity.Veiculo;
import domain.exception.EntityAlreadyExistsException;
import domain.repository.VeiculoRepository;

import java.util.Iterator;
import java.util.Optional;

public class VeiculoUseCase {
    private final VeiculoRepository veiculoRepo;

    public VeiculoUseCase(VeiculoRepository veiculoRepo) {
        this.veiculoRepo = veiculoRepo;
    }

    public void insertVeiculo(Veiculo veiculo) {
        Optional<Veiculo> existente = veiculoRepo.findByPlaca(veiculo.getPlaca());
        if (existente.isPresent()) {
            throw new EntityAlreadyExistsException("Já existe um veículo com a placa: " + veiculo.getPlaca());
        }
        veiculoRepo.save(veiculo);
    }


    public Optional<Veiculo> findVeiculoById(int id) {
        return veiculoRepo.findById(id);
    }

    public Optional<Veiculo> findVeiculoByPlaca(String placa) {
        return veiculoRepo.findByPlaca(placa);
    }

    public Iterator<Veiculo> findVeiculosByProprietario(Proprietario proprietario) {
        return veiculoRepo.findByProprietario(proprietario);
    }

    public Iterator<Veiculo> listAllVeiculos() {
        return veiculoRepo.findAll();
    }
}

