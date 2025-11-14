package adapter.config;

import adapter.repository.ProductRepositoryImpl;
import usecase.ProductUseCase;

public class AppConfig {

    public static ProductUseCase createProductUseCase() {
        return new ProductUseCase(new ProductRepositoryImpl());
    }
}

