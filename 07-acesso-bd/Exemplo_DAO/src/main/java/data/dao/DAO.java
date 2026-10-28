
package data.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T save(T entity);
    int update(T entity);
    int delete(int id);
    Optional<T> findById(int id);
    List<T> findAll();
}
