package adapters.dao;

import domain.entity.Especialidade;
import domain.entity.Medico;

import java.util.List;

public interface MedicoDAO extends DAO<Medico>{
    List<Medico> findByEspecialidade(Especialidade especialidade);
}
