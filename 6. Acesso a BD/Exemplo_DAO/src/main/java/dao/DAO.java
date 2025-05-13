
package dao;

import java.util.Iterator;
import java.util.Optional;

public interface DAO<T> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    Optional<T> findById(int id);
    Iterator<T> findAll();
}
