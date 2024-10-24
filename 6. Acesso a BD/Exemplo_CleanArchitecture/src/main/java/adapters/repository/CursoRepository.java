package adapters.repository;

import domain.entity.Curso;
import domain.repository.Repository;

import java.util.Optional;

public interface CursoRepository extends Repository<Curso> {
    Optional<Curso> findByName(String name);
}
