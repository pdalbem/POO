package adapter.repository;

import domain.entity.Cidade;
import usecase.AlunoUseCase;
import usecase.CidadeUseCase;
import usecase.CursoUseCase;

public class UseCaseFactory {
    public static AlunoUseCase createAlunoUseCase() {
        return new AlunoUseCase(new AlunoRepositoryImpl());
    }

    public static CursoUseCase createCursoUseCase() {
        return new CursoUseCase(new CursoRepositoryImpl());
    }

    public static CidadeUseCase createCidadeUseCase() {
        return new CidadeUseCase(new CidadeRepositoryImpl());
    }
}

