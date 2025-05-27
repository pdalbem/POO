import adapter.config.DatabaseInitializer;
import adapter.repository.ProductRepositoryImpl;
import domain.entity.Product;
import domain.exception.InvalidProductException;
import usecase.ProductUseCase;

import java.util.Iterator;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        DatabaseInitializer.init();
        ProductUseCase productUseCase = new ProductUseCase(new ProductRepositoryImpl());

        try {
            Product p1 = new Product("smartphone",3000);
            productUseCase.createProduct(p1);

            Product p2 = new Product("laptop", 5000);
            productUseCase.createProduct(p2);

            p2.setPrice(6000);
            productUseCase.updateProduct(p2);
        } catch (InvalidProductException e) {
            System.out.println("ERRO: "+e.getMessage());
        }

        System.out.println("Listando todos os produtos");
        Iterator<Product> produtoIterator = productUseCase.findAllProducts();
        while (produtoIterator.hasNext()) {
            Product product =  produtoIterator.next();
            System.out.println(product);
        }

        System.out.println("Recuperando produto pelo ID");
        Optional<Product> produtoOptional = productUseCase.findProductById(1);
        if (produtoOptional.isPresent())
            System.out.println(produtoOptional.get());
        else
            System.out.println("Produto não encontrado");
    }
}
