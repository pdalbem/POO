package adapter.config;

import adapter.repository.ProprietarioRepositoryImpl;
import adapter.repository.VeiculoRepositoryImpl;
import usecase.ProprietarioUseCase;
import usecase.VeiculoUseCase;

public class AppConfig {
    public static ProprietarioUseCase createProprietarioUseCase() {
        return new ProprietarioUseCase(new ProprietarioRepositoryImpl());
    }

    public static VeiculoUseCase createVeiculoUseCase() {
        return new VeiculoUseCase(new VeiculoRepositoryImpl());
    }

}

