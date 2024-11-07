package adapters.repository;

import adapters.dao.MedicoDAO;
import domain.entity.Especialidade;
import domain.entity.Medico;
import domain.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;

public class MedicoRepositoryImpl implements MedicoRepository {

    private final MedicoDAO dao;

    public MedicoRepositoryImpl(MedicoDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Medico> findByEspecialidade(Especialidade especialidade) {
        return dao.findByEspecialidade(especialidade);
    }

    @Override
    public void save(Medico medico) {
        int id=dao.save(medico);
        medico.setId(id);
    }

    @Override
    public Optional<Medico> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Medico> findAll() {
        return dao.findAll();
    }
}
