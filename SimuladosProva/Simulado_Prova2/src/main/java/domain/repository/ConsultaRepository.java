package domain.repository;

import domain.entity.Consulta;
import domain.entity.Paciente;

import java.util.List;

public interface ConsultaRepository extends Repository<Consulta>{
    List<Consulta> findByPaciente(Paciente paciente);
}
