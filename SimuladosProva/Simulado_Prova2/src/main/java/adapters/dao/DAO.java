package adapters.dao;

import java.util.List;
import java.util.Optional;

public interface DAO <T>{
    int save(T type);
    Optional<T> findById(int id);
    List<T> findAll();
}
