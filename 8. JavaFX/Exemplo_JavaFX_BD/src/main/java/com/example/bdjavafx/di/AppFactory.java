package com.example.bdjavafx.di;

import com.example.bdjavafx.infra.DepartamentoRepositoryImpl;
import com.example.bdjavafx.infra.FuncionarioRepositoryImpl;
import com.example.bdjavafx.domain.usecase.DepartamentoUseCase;
import com.example.bdjavafx.domain.usecase.FuncionarioUseCase;

public class AppFactory {
    public static DepartamentoUseCase criarDepartamentoUseCase() {
        return new DepartamentoUseCase(new DepartamentoRepositoryImpl());
    }

    public static FuncionarioUseCase criarFuncionarioUseCase() {
        return new FuncionarioUseCase(new FuncionarioRepositoryImpl());
    }
}

