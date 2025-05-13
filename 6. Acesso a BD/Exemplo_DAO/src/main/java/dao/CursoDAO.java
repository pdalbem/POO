package dao;

import model.Curso;

import java.util.Iterator;

public interface CursoDAO extends DAO<Curso>{
    Iterator<Curso> findByName(String name);
}
