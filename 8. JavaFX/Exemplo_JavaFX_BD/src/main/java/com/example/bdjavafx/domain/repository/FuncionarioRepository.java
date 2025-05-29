package com.example.bdjavafx.domain.repository;

import com.example.bdjavafx.domain.model.Funcionario;

import java.util.Optional;

public interface FuncionarioRepository extends Repository<Funcionario> {
    Optional<Funcionario> findByCPF(String cpf);
}
