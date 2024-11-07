package adapters.dao;

import domain.entity.Paciente;

import java.util.List;
import java.util.Optional;

public class PacienteDAOImpl implements PacienteDAO{
    @Override
    public int save(Paciente type) {
        return 0;
    }

    @Override
    public Optional<Paciente> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Paciente> findAll() {
        return List.of();
    }
}
