package adapters.dao;

import domain.entity.Curso;

import java.util.Optional;

public interface CursoDAO extends DAO<Curso> {
    Optional<Curso> findByName(String name);
}
