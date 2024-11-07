package adapters.dao;

import domain.entity.Especialidade;

import java.util.List;
import java.util.Optional;

public class EspecialidadeDAOImpl implements EspecialidadeDAO{
    @Override
    public void update(Especialidade especialidade) {

    }

    @Override
    public void delete(Especialidade especialidade) {

    }

    @Override
    public int save(Especialidade type) {
        return 0;
    }

    @Override
    public Optional<Especialidade> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Especialidade> findAll() {
        return List.of();
    }
}
