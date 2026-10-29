package service;

import data.dao.VeiculoDAO;
import model.Proprietario;
import model.Veiculo;

import java.util.List;
import java.util.Optional;

public class VeiculoService {

    private final VeiculoDAO veiculoDAO;

    public VeiculoService(VeiculoDAO veiculoDAO) {
        this.veiculoDAO = veiculoDAO;
    }

    public Veiculo cadastrar(Veiculo veiculo) {
        if (veiculo == null)
            throw new IllegalArgumentException("O veículo não pode ser nulo.");

        return veiculoDAO.save(veiculo);
    }

    public Optional<Veiculo> buscarPorId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("O ID do veículo deve ser positivo.");

        return veiculoDAO.findById(id);
    }

    public Optional<Veiculo> buscarPorPlaca(String placa) {
        if (placa == null || placa.isBlank())
            throw new IllegalArgumentException("A placa do veículo é obrigatória.");


        return veiculoDAO.findByPlaca(placa);
    }

    public List<Veiculo> buscarPorProprietario(Proprietario proprietario) {
        if (proprietario == null)
            throw new IllegalArgumentException("O proprietário não pode ser nulo.");

        return veiculoDAO.findByProprietario(proprietario);
    }

    public List<Veiculo> buscarTodos() {
        return veiculoDAO.findAll();
    }
}
