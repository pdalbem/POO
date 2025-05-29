package com.example.bdjavafx.domain.repository;

import com.example.bdjavafx.domain.model.Departamento;

import java.util.Optional;

public interface DepartamentoRepository extends Repository<Departamento> {
    Optional<Departamento> findBySigla(String sigla);
}
