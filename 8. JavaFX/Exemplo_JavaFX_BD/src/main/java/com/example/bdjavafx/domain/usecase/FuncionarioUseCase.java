package com.example.bdjavafx.domain.usecase;

import com.example.bdjavafx.domain.exception.EntityAlreadyExistsException;
import com.example.bdjavafx.domain.repository.FuncionarioRepository;
import com.example.bdjavafx.domain.model.Funcionario;

import java.util.List;
import java.util.Optional;

public class FuncionarioUseCase {

    private final FuncionarioRepository repo;

    public FuncionarioUseCase(FuncionarioRepository repo) {
        this.repo = repo;
    }

    public void salvar(Funcionario funcionario) {
        if (repo.findByCPF(funcionario.getCpf()).isPresent())
            throw new EntityAlreadyExistsException("Já existe um funcionário com este CPF '" + funcionario.getCpf() + "'.");

        repo.save(funcionario);
    }

    public void atualizar(Funcionario funcionario) {
        repo.update(funcionario);
    }

    public void excluir(Funcionario funcionario) {
        repo.delete(funcionario);
    }

    public List<Funcionario> listarTodos() {
        return repo.findAll();
    }

    public Optional<Funcionario> buscarPorId(int id) {
        return repo.findById(id);
    }
}
