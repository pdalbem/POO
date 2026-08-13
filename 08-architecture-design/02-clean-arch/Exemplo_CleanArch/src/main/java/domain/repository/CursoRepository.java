package domain.repository;

import domain.entity.Curso;

import java.util.Iterator;

public interface CursoRepository extends Repository<Curso> {
    Iterator<Curso> findByName(String name);
}
