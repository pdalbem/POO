package adapters.dao;

import domain.entity.Especialidade;

public interface EspecialidadeDAO extends DAO<Especialidade>{
    void update(Especialidade especialidade);
    void delete(Especialidade especialidade);
}
