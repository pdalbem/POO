package adapters;

import domain.Aluno;

import java.util.List;
import java.util.Optional;

public class AlunoRepository implements Repository<Aluno> {
    private final DAO<Aluno> dao;

    public AlunoRepository(DAO<Aluno> dao) {
        this.dao = dao;
    }

    @Override
    public int save(Aluno aluno) {
       return dao.save(aluno);
    }

    @Override
    public void update(Aluno aluno) {
        dao.update(aluno);
    }

    @Override
    public void delete(Aluno aluno) {
        dao.delete(aluno);
    }

    @Override
    public Optional<Aluno> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Aluno> findAll() {
        return dao.findAll();
    }
}
