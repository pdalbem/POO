package service;

import data.dao.DoadorDAO;
import exception.EntityNotFoundException;
import model.Doador;
import model.TipoSanguineo;

import java.util.List;

public class DoadorService {
    private final DoadorDAO doadorDAO; //inversão de dependência (depende da abstração)

    //injeção de dependência
    public DoadorService(DoadorDAO doadorDAO) {
        this.doadorDAO = doadorDAO;
    }

    public Doador cadastrar(Doador doador) {
        if (doador == null)
            throw new IllegalArgumentException("O doador não pode ser nulo");

        return doadorDAO.save(doador);
    }

    public void atualizar(Doador doador) {
        if (doador == null)
            throw new IllegalArgumentException("O doador não pode ser nulo");

        if (doador.getId() <= 0)
            throw new IllegalStateException("O ID do doador deve ser positivo. Ou doador ainda não foi cadastrado");

        int linhasAfetadas = doadorDAO.update(doador);
        if (linhasAfetadas == 0)
            throw new EntityNotFoundException("Doador não encontrado: " + doador.getCpf());
    }

    public List<Doador> buscarTodos() {
         return doadorDAO.findAll();
    }

    public List<Doador> buscarPorTipoSanguineo(TipoSanguineo tipoSanguineo) {
        if (tipoSanguineo == null)
            throw new IllegalArgumentException("O tipo sanguíneo não pode ser nulo");

        return doadorDAO.findByTipoSanguineo(tipoSanguineo);
    }

    public List<Doador> buscarDoadoresAptos() {
        return doadorDAO.findDoadoresAptos();
    }
}
