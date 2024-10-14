package adapters;

import java.util.List;

public interface DAO <T>{
    void save(T type);
    List<T> findAll();
}
