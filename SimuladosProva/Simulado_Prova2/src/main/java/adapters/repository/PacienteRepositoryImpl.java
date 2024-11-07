package adapters.repository;

import adapters.dao.PacienteDAO;
import domain.entity.Paciente;
import domain.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

public class PacienteRepositoryImpl implements PacienteRepository {
    private final PacienteDAO dao;

    public PacienteRepositoryImpl(PacienteDAO dao) {
        this.dao = dao;
    }


    @Override
    public void save(Paciente paciente) {
        int id=dao.save(paciente);
        paciente.setId(id);
    }

    @Override
    public Optional<Paciente> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Paciente> findAll() {
        return dao.findAll();
    }
}
