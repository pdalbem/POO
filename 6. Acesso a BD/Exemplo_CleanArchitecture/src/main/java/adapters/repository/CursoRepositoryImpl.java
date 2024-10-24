package adapters.repository;

import adapters.dao.CursoDAO;
import domain.entity.Curso;

import java.util.List;
import java.util.Optional;

public class CursoRepositoryImpl implements CursoRepository{
    private final CursoDAO dao;

    public CursoRepositoryImpl(CursoDAO dao) {
        this.dao = dao;
    }

    @Override
    public void save(Curso curso) {
        int id= dao.save(curso);
        curso.setIdCurso(id);
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

    @Override
    public Optional<Curso> findByName(String name) {
        return dao.findByName(name);
    }
}
