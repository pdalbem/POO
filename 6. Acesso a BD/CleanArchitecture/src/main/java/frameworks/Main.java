package frameworks;

import entity.Product;
import interfaces.DAO;
import interfaces.Repository;
import usecase.ProductService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DAO<Product> productDAO = new PostgresProductDAO();
        Repository<Product> productRepository = new ProductRepository(productDAO);
        ProductService productService = new ProductService(productRepository);

        Scanner scanner=new Scanner(System.in);
        System.out.println("Digite o ID: ");
        String id = scanner.nextLine();
        System.out.println("Digite o nome: ");
        String name=scanner.nextLine();
        System.out.println("Digite o preço: ");
        double price=scanner.nextDouble();

        Product newProduct = new Product(id,name,price);

        productService.addProduct(newProduct);

        List<Product> products = productService.getAllProducts();
        products.forEach(System.out::println);

    }
}
