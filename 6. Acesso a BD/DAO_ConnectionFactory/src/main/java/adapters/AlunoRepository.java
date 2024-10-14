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
    public void save(Aluno aluno) {
       int id= dao.save(aluno);
       aluno.setIdAluno(id);
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
