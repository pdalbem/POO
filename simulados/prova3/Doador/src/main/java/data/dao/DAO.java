
package data.dao;

import java.util.List;

public interface DAO<T> {
    T save(T entity);
    List<T> findAll();
}
