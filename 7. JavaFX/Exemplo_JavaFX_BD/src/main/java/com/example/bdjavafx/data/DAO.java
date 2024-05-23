package com.example.bdjavafx.data;

import java.util.List;

public interface DAO<T> {
    void save(T type);
    void update(T type);
    void delete(T type);
    T findById(int id);
    List<T> findAll();
}
