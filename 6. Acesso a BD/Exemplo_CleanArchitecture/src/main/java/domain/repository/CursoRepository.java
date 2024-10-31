package domain.repository;

import domain.entity.Curso;

import java.util.Optional;

public interface CursoRepository extends Repository<Curso> {
    Optional<Curso> findByName(String name);
}
