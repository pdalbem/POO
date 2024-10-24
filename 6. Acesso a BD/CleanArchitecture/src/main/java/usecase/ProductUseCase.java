package usecase;

import domain.entity.Product;
import domain.repository.Repository;

import java.util.List;

public class ProductUseCase {
    private final Repository repository;

    public ProductUseCase(Repository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        if (product.getId() == null || product.getName() == null || product.getPrice() <= 0) {
            throw new IllegalArgumentException("Invalid product data");
        }
        repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }
}
