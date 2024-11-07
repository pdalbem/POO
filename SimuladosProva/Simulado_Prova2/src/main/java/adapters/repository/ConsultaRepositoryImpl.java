package adapters.repository;

import adapters.dao.ConsultaDAO;
import domain.entity.Consulta;
import domain.entity.Paciente;
import domain.repository.ConsultaRepository;

import java.util.List;
import java.util.Optional;

public class ConsultaRepositoryImpl implements ConsultaRepository {
    private final ConsultaDAO dao;

    public ConsultaRepositoryImpl(ConsultaDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Consulta> findByPaciente(Paciente paciente) {
        return dao.findByPaciente(paciente);
    }

    @Override
    public void save(Consulta consulta) {
        int id=dao.save(consulta);
        consulta.setId(id);
    }

    @Override
    public Optional<Consulta> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Consulta> findAll() {
        return dao.findAll();
    }
}
