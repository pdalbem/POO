package adapters;

import domain.Curso;

import java.util.List;
import java.util.Optional;

public class CursoRepository implements Repository<Curso> {
    private final DAO<Curso> dao;

    public CursoRepository(DAO<Curso> dao) {
        this.dao = dao;
    }

    @Override
    public int save(Curso curso) {
        return dao.save(curso);
    }

    @Override
    public void update(Curso curso) {
        dao.update(curso);
    }

    @Override
    public void delete(Curso curso) {
        dao.delete(curso);
    }

    @Override
    public Optional<Curso> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Curso> findAll() {
        return dao.findAll();
    }
}
