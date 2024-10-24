package adapters.repository;

import adapters.dao.AlunoDAO;
import adapters.dao.DAO;
import domain.entity.Aluno;
import domain.repository.Repository;

import java.util.List;
import java.util.Optional;

public class AlunoRepositoryImpl implements AlunoRepository {
    private final AlunoDAO dao;

    public AlunoRepositoryImpl(AlunoDAO dao) {
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

    @Override
    public Optional<Aluno> findByProntuario(String prontuario) {
        return dao.findByProntuario(prontuario);
    }
}
