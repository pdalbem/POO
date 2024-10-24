package domain.repository;

import java.util.List;

public interface Repository<T> {
    void save(T type);
    List<T> findAll();
}
