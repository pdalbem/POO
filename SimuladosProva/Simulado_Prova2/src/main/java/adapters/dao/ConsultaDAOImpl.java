package adapters.dao;

import domain.entity.Consulta;
import domain.entity.Paciente;

import java.util.List;
import java.util.Optional;

public class ConsultaDAOImpl implements ConsultaDAO{
    @Override
    public List<Consulta> findByPaciente(Paciente paciente) {
        return List.of();
    }

    @Override
    public int save(Consulta type) {
        return 0;
    }

    @Override
    public Optional<Consulta> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Consulta> findAll() {
        return List.of();
    }
}
