package service;

import data.dao.ProprietarioDAO;
import model.Proprietario;

import java.util.List;
import java.util.Optional;

public class ProprietarioService {

    private final ProprietarioDAO proprietarioDAO;

    public ProprietarioService(ProprietarioDAO proprietarioDAO) {
        this.proprietarioDAO = proprietarioDAO;
    }

    public Proprietario cadastrar(Proprietario proprietario) {
        if (proprietario == null)
            throw new IllegalArgumentException("O proprietário não pode ser nulo.");

        return proprietarioDAO.save(proprietario);
    }

    public Optional<Proprietario> buscarPorId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("O ID do proprietário deve ser positivo.");

        return proprietarioDAO.findById(id);
    }

    public List<Proprietario> buscarTodos() {
        return proprietarioDAO.findAll();
    }
}
