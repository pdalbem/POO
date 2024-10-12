package frameworks;

import entity.Product;
import interfaces.DAO;
import interfaces.Repository;

import java.util.List;

public class ProductRepository implements Repository<Product> {
    private final DAO<Product> dao;

    public ProductRepository(DAO<Product> dao) {
        this.dao = dao;
    }

    @Override
    public void save(Product product) {
        dao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }
}