package com.example.bdjavafx.domain.usecase;


import com.example.bdjavafx.domain.exception.EntityAlreadyExistsException;
import com.example.bdjavafx.domain.repository.DepartamentoRepository;
import com.example.bdjavafx.domain.model.Departamento;


import java.util.List;


public class DepartamentoUseCase {

    private final DepartamentoRepository repo;

    public DepartamentoUseCase(DepartamentoRepository repo) {
        this.repo = repo;
    }

    public void salvar(Departamento departamento) {
        if (repo.findBySigla(departamento.getSigla()).isPresent())
            throw new EntityAlreadyExistsException("Já existe um departamento com a sigla '" + departamento.getSigla() + "'.");

        repo.save(departamento);
    }

    public void atualizar(Departamento departamento) {
        repo.update(departamento);
    }

    public void excluir(Departamento departamento) {
        repo.delete(departamento);
    }

    public List<Departamento> listarTodos() {
        return repo.findAll();
    }

 /*   public Optional<Departamento> buscarPorId(int id) {
        return dao.findById(id);
    }*/
}

