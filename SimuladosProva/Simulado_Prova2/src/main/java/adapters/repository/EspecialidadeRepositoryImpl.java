package adapters.repository;

import adapters.dao.EspecialidadeDAO;
import domain.entity.Especialidade;
import domain.repository.EspecialidadeRepository;

import java.util.List;
import java.util.Optional;

public class EspecialidadeRepositoryImpl implements EspecialidadeRepository {
   private  final EspecialidadeDAO dao;

    public EspecialidadeRepositoryImpl(EspecialidadeDAO dao) {
        this.dao = dao;
    }

    @Override
    public void update(Especialidade especialidade) {
        dao.update(especialidade);
    }

    @Override
    public void delete(Especialidade especialidade) {
        dao.delete(especialidade);
    }

    @Override
    public void save(Especialidade especialidade) {
        int id=dao.save(especialidade);
        especialidade.setId(id);
    }

    @Override
    public Optional<Especialidade> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Especialidade> findAll() {
        return dao.findAll();
    }
}
