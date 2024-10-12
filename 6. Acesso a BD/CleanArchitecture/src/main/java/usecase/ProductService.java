package usecase;

import entity.Product;
import interfaces.Repository;

import java.util.List;

public class ProductService {
    private final Repository repository;

    public ProductService(Repository repository) {
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
