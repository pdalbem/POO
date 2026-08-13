package usecase;

import adapter.repository.ProductRepositoryImpl;
import domain.entity.Product;
import domain.repository.ProductRepository;

import java.util.Iterator;
import java.util.Optional;

public class ProductUseCase {
    private final ProductRepository repository;

    public ProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public void createProduct(Product product) {
        repository.save(product);
    }

    public void updateProduct(Product product) {
          repository.update(product);
    }

    public void deleteProduct(Product product) {
        repository.delete(product);
    }

    public Optional<Product> findProductById(int id) {
        return repository.findById(id);
    }

    public Iterator<Product> findAllProducts() {
        return repository.findAll();
    }
}
