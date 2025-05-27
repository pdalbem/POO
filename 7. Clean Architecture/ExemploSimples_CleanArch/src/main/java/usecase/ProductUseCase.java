package usecase;

import domain.entity.Product;
import domain.exception.InvalidProductException;
import domain.repository.ProductRepository;

import java.util.Iterator;
import java.util.Optional;

public class ProductUseCase {
    private final ProductRepository repository;

    public ProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public void createProduct(Product product) {
        validate(product);
        repository.save(product);
    }

    public void updateProduct(Product product) {
          validate(product);
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

    private void validate(Product product) {
        if (product.getName() == null || product.getName().isBlank()) {
            throw new InvalidProductException("Nome do produto não pode ser nulo ou vazio");
        }
        if (product.getPrice() < 0) {
            throw new InvalidProductException("Preço não pode ser negativo");
        }
    }

}
