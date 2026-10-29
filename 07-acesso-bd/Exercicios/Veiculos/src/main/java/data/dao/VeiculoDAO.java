package data.dao;

import model.Proprietario;
import model.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoDAO extends DAO<Veiculo> {
    Optional<Veiculo> findByPlaca(String placa);
    List<Veiculo> findByProprietario(Proprietario proprietario);
}
