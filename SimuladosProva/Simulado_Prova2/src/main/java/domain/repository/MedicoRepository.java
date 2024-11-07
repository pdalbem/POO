package domain.repository;

import domain.entity.Especialidade;
import domain.entity.Medico;

import java.util.List;

public interface MedicoRepository extends Repository<Medico>{
    List<Medico> findByEspecialidade(Especialidade especialidade);
}
