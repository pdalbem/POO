package adapter.config;

import adapter.repository.AlunoRepositoryImpl;
import adapter.repository.CidadeRepositoryImpl;
import adapter.repository.CursoRepositoryImpl;
import usecase.AlunoUseCase;
import usecase.CidadeUseCase;
import usecase.CursoUseCase;

public class AppConfig {
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

