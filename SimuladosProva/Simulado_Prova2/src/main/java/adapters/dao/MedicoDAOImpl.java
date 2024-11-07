package adapters.dao;

import domain.entity.Especialidade;
import domain.entity.Medico;

import java.util.List;
import java.util.Optional;

public class MedicoDAOImpl implements MedicoDAO{
    @Override
    public List<Medico> findByEspecialidade(Especialidade especialidade) {
        return List.of();
    }

    @Override
    public int save(Medico type) {
        return 0;
    }

    @Override
    public Optional<Medico> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Medico> findAll() {
        return List.of();
    }
}
