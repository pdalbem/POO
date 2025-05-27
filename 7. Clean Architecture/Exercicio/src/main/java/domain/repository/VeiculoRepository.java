package domain.repository;

import domain.entity.Proprietario;
import domain.entity.Veiculo;

import java.util.Iterator;
import java.util.Optional;

public interface VeiculoRepository extends Repository<Veiculo>{
    Optional<Veiculo> findByPlaca(String placa);
    Iterator<Veiculo> findByProprietario(Proprietario proprietario);
}
