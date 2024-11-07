package adapters.dao;

import domain.entity.Consulta;
import domain.entity.Paciente;

import java.util.List;

public interface ConsultaDAO extends DAO<Consulta> {
    List<Consulta> findByPaciente(Paciente paciente);
}
