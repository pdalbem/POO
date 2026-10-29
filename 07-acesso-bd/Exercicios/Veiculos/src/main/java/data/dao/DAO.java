
package data.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T save(T entity);
    Optional<T> findById(int id);
    List<T> findAll();
}
