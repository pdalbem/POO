package data.dao;

import model.Curso;
import java.util.List;

public interface CursoDAO extends DAO<Curso>{
    List<Curso> findByNome(String nome);
}
