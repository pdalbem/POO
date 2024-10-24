import infra.DAO;
import infra.PostgresProductDAO;
import infra.ProductRepository;
import domain.repository.Repository;
import domain.entity.Product;
import usecase.ProductUseCase;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DAO<Product> productDAO = new PostgresProductDAO();
        Repository<Product> productRepository = new ProductRepository(productDAO);
        ProductUseCase productUseCase = new ProductUseCase(productRepository);

        Scanner scanner=new Scanner(System.in);
        System.out.println("Digite o ID: ");
        String id = scanner.nextLine();
        System.out.println("Digite o nome: ");
        String name=scanner.nextLine();
        System.out.println("Digite o preço: ");
        double price=scanner.nextDouble();

        Product newProduct = new Product(id,name,price);

        productUseCase.addProduct(newProduct);

        List<Product> products = productUseCase.getAllProducts();
        products.forEach(System.out::println);

    }
}
